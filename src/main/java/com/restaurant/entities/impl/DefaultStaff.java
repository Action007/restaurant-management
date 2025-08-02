package com.restaurant.entities.impl;

import com.restaurant.entities.Staff;
import com.restaurant.enums.StaffRole;

public class DefaultStaff implements Staff {
  private final StaffId id;
  private final Password password;
  private final String firstName;
  private final String lastName;
  private final StaffRole role;

  public DefaultStaff(String firstName, String lastName, String id,
      String password, String role) {
    this.id = new StaffId(id);
    this.password = new Password(password);

    if (firstName == null || firstName.trim().isEmpty()) {
      throw new IllegalArgumentException("First Name can't be empty.");
    }
    if (lastName == null || lastName.trim().isEmpty()) {
      throw new IllegalArgumentException("Last Name can't be empty.");
    }

    this.firstName = firstName;
    this.lastName = lastName;
    this.role = validateStaffRole(role);
  }

  @Override
  public boolean isPasswordValid(String candidate) {
    return password.matches(candidate);
  }

  @Override
  public String getFirstName() {
    return firstName;
  }

  @Override
  public String getId() {
    return id.getValue();
  }

  @Override
  public String getPassword() {
    return password.getValue();
  }

  @Override
  public StaffRole getRole() {
    return role;
  }

  @Override
  public StaffRole validateStaffRole(String role) {
    if (role == null) {
      throw new IllegalArgumentException("Role cannot be null.");
    }

    if (role.equals("Manager")) {
      return StaffRole.MANAGER;
    } else if (role.equals("Waiter")) {
      return StaffRole.WAITER;
    } else {
      throw new IllegalArgumentException(
          "Invalid role: '" + role + "'. Must be 'Manager' or 'Waiter' (case-sensitive).");
    }
  }

  @Override
  public String toString() {
    return "Staff Details {" +
        "ID='" + id + '\'' +
        ", Name='" + firstName + " " + lastName + '\'' +
        ", Role=" + role +
        '}';
  }
}