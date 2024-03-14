package com.programming.techie.service.exception;

public class AulaAlreadyTakenExepction  extends RuntimeException {

  public AulaAlreadyTakenExepction(String message) {
    super("These relation already exist "+message);
  }
}
