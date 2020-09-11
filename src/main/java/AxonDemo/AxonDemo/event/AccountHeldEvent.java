package AxonDemo.AxonDemo.event;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountHeldEvent extends BaseEvent<String> {
  private String status;

  public AccountHeldEvent(String id, String status) {
    super(id);
    this.status = status;
  }
}
