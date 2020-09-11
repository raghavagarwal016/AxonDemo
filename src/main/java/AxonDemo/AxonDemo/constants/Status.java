package AxonDemo.AxonDemo.constants;

public enum Status {
  ACTIVATED("ACTIVATED"),HOLD("HOLD"),CREATED("CREATED");

  private String status;

  Status(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

}
