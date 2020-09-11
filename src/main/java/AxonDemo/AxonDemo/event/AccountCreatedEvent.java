package AxonDemo.AxonDemo.event;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountCreatedEvent extends BaseEvent<String> {
  private double accountBalance;
  private String currency;

  public AccountCreatedEvent(String id, double accountBalance, String currency) {
    super(id);
    this.accountBalance = accountBalance;
    this.currency = currency;
  }
}
