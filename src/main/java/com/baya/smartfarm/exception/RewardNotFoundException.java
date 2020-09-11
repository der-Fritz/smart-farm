package com.baya.smartfarm.exception;

public class RewardNotFoundException extends RuntimeException {

  public RewardNotFoundException(String message) {
    super(message);
  }

  public RewardNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public RewardNotFoundException(final Throwable cause) {
    super(cause);
  }
}
