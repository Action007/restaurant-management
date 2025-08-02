package com.restaurant.entities.impl;

import com.restaurant.entities.Staff;
import com.restaurant.enums.StaffRole;
import com.restaurant.validation.ValidationResult;
import com.restaurant.validation.ValidationService;

public class DefaultStaff implements Staff {
  private String firstName;
  private String lastName;
  private String id;
  private String password;
  private StaffRole role;

  public DefaultStaff(String firstName, String lastName, String id, String password, String role) {
    ValidationResult validationService = ValidationService.validateStaffRegistration(firstName, lastName, id,
        password, role);

    if (!validationService.getIsValid()) {
      throw new IllegalArgumentException(validationService.getErrorMessage());
    }

    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
    this.password = password;
    this.role = convertStringToRole(role);
  }

  private StaffRole convertStringToRole(String role) {
    if (role.equals("Manager")) {
      return StaffRole.MANAGER;
    }
    return StaffRole.WAITER;
  }

  @Override
  public String getFirstName() {
    return this.firstName;
  }

  @Override
  public String getId() {
    return this.id;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public StaffRole getRole() {
    return this.role;
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
