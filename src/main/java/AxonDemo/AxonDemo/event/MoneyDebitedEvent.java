package AxonDemo.AxonDemo.event;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MoneyDebitedEvent extends BaseEvent<String> {
  private double debitAmount;
  private String currency;

  public MoneyDebitedEvent(String id, double debitAmount, String currency) {
    super(id);
    this.debitAmount = debitAmount;
    this.currency = currency;
  }
}
