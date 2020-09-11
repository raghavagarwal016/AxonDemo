package AxonDemo.AxonDemo.event;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountActivatedEvent extends BaseEvent<String> {
 private String  status;

  public AccountActivatedEvent(String id, String status) {
    super(id);
    this.status = status;
  }
}
