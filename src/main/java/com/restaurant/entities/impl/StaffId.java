package com.restaurant.entities.impl;

public final class StaffId {
  private final String value;

  public StaffId(String value) {
    if (value == null || !value.matches("^\\d{4}$")) {
      throw new IllegalArgumentException("Staff ID must be exactly 4 digits");
    }
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    StaffId staffId = (StaffId) o;
    return value.equals(staffId.value);
  }

  @Override
  public int hashCode() {
    return value.hashCode();
  }
}
