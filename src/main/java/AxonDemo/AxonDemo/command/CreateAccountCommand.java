package AxonDemo.AxonDemo.command;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateAccountCommand extends BaseCommand<String> {
  private double accountBalance;
  private String currency;

  public CreateAccountCommand(String id, double accountBalance, String currency) {
    super(id);
    this.accountBalance = accountBalance;
    this.currency = currency;
  }

}
