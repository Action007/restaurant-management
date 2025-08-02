package com.restaurant.validation;

public class ValidationService {
  public static ValidationResult validateStaffRegistration(String firstName, String lastName, String id,
      String password, String role) {
    ValidationResult validationResult = new ValidationResult(true, "");

    if (firstName == null || firstName.trim().isEmpty()) {
      return validationResult = new ValidationResult(false, "First Name can't be empty.");
    }
    if (lastName == null || lastName.trim().isEmpty()) {
      return validationResult = new ValidationResult(false, "Last Name can't be empty.");
    }
    if (id == null || !id.matches("^\\d{4}$")) {
      return validationResult = new ValidationResult(false,
          "Employee ID must be exactly 4 digits and unique across all staff.");
    }
    if (password == null || password.length() < 6) {
      return validationResult = new ValidationResult(false, "Password must be at least 6 characters long.");
    }

    if (role == null) {
      return validationResult = new ValidationResult(false, "Role cannot be null.");
    }

    if (!role.equals("Manager") && !role.equals("Waiter")) {
      return validationResult = new ValidationResult(
          false, "Invalid role: '" + role + "'. Must be 'Manager' or 'Waiter' (case-sensitive).");
    }

    return validationResult;
  }
}
