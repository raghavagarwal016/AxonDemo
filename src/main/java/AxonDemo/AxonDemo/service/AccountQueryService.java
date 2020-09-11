package AxonDemo.AxonDemo.service;

import java.util.List;

public interface AccountQueryService {
  public List<Object> listEventsForAccount(String accountNumber);
}
