package AxonDemo.AxonDemo.service.impl;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import AxonDemo.AxonDemo.command.CreateAccountCommand;
import AxonDemo.AxonDemo.command.CreditMoneyCommand;
import AxonDemo.AxonDemo.command.DebitMoneyCommand;
import AxonDemo.AxonDemo.dto.AccountCreateDTO;
import AxonDemo.AxonDemo.dto.MoneyCreditDTO;
import AxonDemo.AxonDemo.dto.MoneyDebitDTO;
import AxonDemo.AxonDemo.service.AccountCommandService;

@Service
public class AccountCommandServiceImpl implements AccountCommandService {

  private final CommandGateway commandGateway;

  public AccountCommandServiceImpl(CommandGateway commandGateway) {
    this.commandGateway = commandGateway;
  }

  @Override
  public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO) {
    return commandGateway.send(
        new CreateAccountCommand(UUID.randomUUID().toString(), accountCreateDTO.getStartingBalance(),
            accountCreateDTO.getCurrency()));
  }

  @Override
  public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO) {
    return commandGateway
        .send(new CreditMoneyCommand(accountNumber, moneyCreditDTO.getCreditAmount(), moneyCreditDTO.getCurrency()));
  }

  @Override
  public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO) {
    return commandGateway
        .send(new DebitMoneyCommand(accountNumber, moneyDebitDTO.getDebitAmount(), moneyDebitDTO.getCurrency()));
  }
}
