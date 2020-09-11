package AxonDemo.AxonDemo.service;

import java.util.concurrent.CompletableFuture;

import AxonDemo.AxonDemo.dto.AccountCreateDTO;
import AxonDemo.AxonDemo.dto.MoneyCreditDTO;
import AxonDemo.AxonDemo.dto.MoneyDebitDTO;

public interface AccountCommandService {
  public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO);
  public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO);
  public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO);
}

