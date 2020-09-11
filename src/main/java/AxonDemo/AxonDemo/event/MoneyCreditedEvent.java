package AxonDemo.AxonDemo.event;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MoneyCreditedEvent extends BaseEvent<String> {
  private double creditAmount;
  private String currency;

  public MoneyCreditedEvent(String id, double creditAmount, String currency) {
    super(id);
    this.creditAmount = creditAmount;
    this.currency = currency;
  }
}
