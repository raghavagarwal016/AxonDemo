package AxonDemo.AxonDemo.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AxonDemo.AxonDemo.dto.AccountCreateDTO;
import AxonDemo.AxonDemo.dto.MoneyCreditDTO;
import AxonDemo.AxonDemo.dto.MoneyDebitDTO;
import AxonDemo.AxonDemo.service.AccountCommandService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/bank-accounts")
@Api(value = "Account Commands", description = "Account Commands Related Endpoints", tags = "Account Commands")
public class AccountCommandController {
  private final AccountCommandService accountCommandService;

  public AccountCommandController(AccountCommandService accountCommandService) {
    this.accountCommandService = accountCommandService;
  }

  @PostMapping
  public CompletableFuture<String> createAccount(@RequestBody AccountCreateDTO accountCreateDTO){
    return accountCommandService.createAccount(accountCreateDTO);
  }

  @PutMapping(value = "/credits/{accountNumber}")
  public CompletableFuture<String> creditMoneyToAccount(@PathVariable(value = "accountNumber") String accountNumber,
      @RequestBody MoneyCreditDTO moneyCreditDTO){
    return accountCommandService.creditMoneyToAccount(accountNumber, moneyCreditDTO);
  }

  @PutMapping(value = "/debits/{accountNumber}")
  public CompletableFuture<String> debitMoneyFromAccount(@PathVariable(value = "accountNumber") String accountNumber,
      @RequestBody MoneyDebitDTO moneyDebitDTO){
    return accountCommandService.debitMoneyFromAccount(accountNumber, moneyDebitDTO);
  }

}
