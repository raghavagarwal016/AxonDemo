package AxonDemo.AxonDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyCreditDTO {
  private double creditAmount;
  private String currency;
}
