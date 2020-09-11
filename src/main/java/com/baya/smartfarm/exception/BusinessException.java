package com.baya.smartfarm.exception;

public class BusinessException extends RuntimeException {

  public BusinessException(String message) {
    super(message);
  }

  public BusinessException(String message, Throwable cause) {
    super(message, cause);
  }

  public BusinessException(final Throwable cause) {
    super(cause);
  }
}
