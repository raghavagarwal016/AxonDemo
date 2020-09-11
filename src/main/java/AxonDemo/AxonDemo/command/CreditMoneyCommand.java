package AxonDemo.AxonDemo.command;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreditMoneyCommand extends BaseCommand<String> {
  private double creditAmount;
  private String currency;

  public CreditMoneyCommand(String id, double creditAmount, String currency) {
    super(id);
    this.creditAmount = creditAmount;
    this.currency = currency;
  }

}
