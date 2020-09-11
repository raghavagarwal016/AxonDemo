package AxonDemo.AxonDemo.event_source_entity;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import AxonDemo.AxonDemo.command.CreateAccountCommand;
import AxonDemo.AxonDemo.command.CreditMoneyCommand;
import AxonDemo.AxonDemo.command.DebitMoneyCommand;
import AxonDemo.AxonDemo.event.AccountActivatedEvent;
import AxonDemo.AxonDemo.event.AccountCreatedEvent;
import AxonDemo.AxonDemo.event.AccountHeldEvent;
import AxonDemo.AxonDemo.event.MoneyCreditedEvent;
import AxonDemo.AxonDemo.event.MoneyDebitedEvent;
import AxonDemo.AxonDemo.constants.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
@Aggregate annotation tells Axon that this entity will be managed by Axon. Basically, this is similar to @Entity annotation
available with JPA. However, we will be using the Axon recommended annotation.
@AggregateIdentifier annotation is used for the identifying a particular instance of the Aggregate. In other words, this
is similar to JPA’s @Id annotation.
*/

@Aggregate
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountAggregate {

  @AggregateIdentifier
  private String id;

  private double accountBalance;

  private String currency;

  private String status;

  @CommandHandler
  public AccountAggregate(CreateAccountCommand createAccountCommand) {
    AggregateLifecycle.apply(
        new AccountCreatedEvent(createAccountCommand.getId(), createAccountCommand.getAccountBalance(),
            createAccountCommand.getCurrency()));
  }

  @EventSourcingHandler
  protected void on(AccountCreatedEvent accountCreatedEvent){
    this.id = accountCreatedEvent.getId();
    this.accountBalance = accountCreatedEvent.getAccountBalance();
    this.currency = accountCreatedEvent.getCurrency();
    this.status = String.valueOf(Status.CREATED.getStatus());
    AggregateLifecycle.apply(new AccountActivatedEvent(this.getId(), Status.ACTIVATED.getStatus()));
  }

  @EventSourcingHandler
  protected void on(AccountActivatedEvent accountActivatedEvent){
    this.status = accountActivatedEvent.getStatus();
  }

  @CommandHandler
  protected void on(CreditMoneyCommand creditMoneyCommand) {
    AggregateLifecycle.apply(new MoneyCreditedEvent(creditMoneyCommand.getId(), creditMoneyCommand.getCreditAmount(),
        creditMoneyCommand.getCurrency()));
  }

  @EventSourcingHandler
  protected void on(MoneyCreditedEvent moneyCreditedEvent){
    if (this.accountBalance < 0 & (this.accountBalance + moneyCreditedEvent.getCreditAmount()) >= 0){
      AggregateLifecycle.apply(new AccountActivatedEvent(this.getId(), Status.ACTIVATED.getStatus()));
    }
    this.accountBalance += moneyCreditedEvent.getCreditAmount();
  }

  @CommandHandler
  protected void on(DebitMoneyCommand debitMoneyCommand){
    AggregateLifecycle.apply(new MoneyDebitedEvent(debitMoneyCommand.getId(), debitMoneyCommand.getDebitAmount(),
        debitMoneyCommand.getCurrency()));
  }

  @EventSourcingHandler
  protected void on(MoneyDebitedEvent moneyDebitedEvent){

    if (this.accountBalance >= 0 & (this.accountBalance - moneyDebitedEvent.getDebitAmount()) < 0){
      AggregateLifecycle.apply(new AccountHeldEvent(this.id, Status.HOLD.getStatus()));
    }

    this.accountBalance -= moneyDebitedEvent.getDebitAmount();

  }

  @EventSourcingHandler
  protected void on(AccountHeldEvent accountHeldEvent){
    this.status = accountHeldEvent.getStatus();
  }

}
