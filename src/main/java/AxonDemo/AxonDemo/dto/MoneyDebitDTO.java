package AxonDemo.AxonDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoneyDebitDTO {
  private double debitAmount;
  private String currency;
}
