package com.restaurant.entities.impl;

public final class Password {
  private final String value;

  public Password(String value) {
    if (value == null || value.length() < 6) {
      throw new IllegalArgumentException("Password must be at least 6 characters");
    }
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public boolean matches(String candidate) {
    return value.equals(candidate);
  }
}