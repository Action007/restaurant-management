package com.restaurant.menu.impl;

import com.restaurant.entities.Staff;
import com.restaurant.entities.impl.DefaultStaff;
import com.restaurant.menu.Menu;
import com.restaurant.services.StaffManagementService;
import com.restaurant.services.impl.DefaultStaffManagerService;
import com.restaurant.state.ApplicationContext;
import com.restaurant.utils.InputHandler;

public class SignUpMenu implements Menu {
  StaffManagementService staffManagementService;
  ApplicationContext context;
  InputHandler inputHandler;

  public SignUpMenu() {
    this.context = ApplicationContext.getInstance();
    this.staffManagementService = DefaultStaffManagerService.getInstance();
    this.inputHandler = new InputHandler();
  }

  private Staff initializeStaff() {
    while (true) {
      try {
        String firstName = inputHandler.getInput("Enter First Name:");
        if (inputHandler.isMenuCommand(firstName)) {
          return null; // cancel registration
        }
        String lastName = inputHandler.getInput("Enter Last Name:");
        if (inputHandler.isMenuCommand(lastName)) {
          return null; // cancel registration
        }
        String id = inputHandler.getInput("Enter Id:");
        if (inputHandler.isMenuCommand(id)) {
          return null; // cancel registration
        }
        String password = inputHandler.getInput("Enter Password:");
        if (inputHandler.isMenuCommand(password)) {
          return null; // cancel registration
        }
        String role = inputHandler.getInput("Enter Role:");
        if (inputHandler.isMenuCommand(role)) {
          return null; // cancel registration
        }
        Staff staff = new DefaultStaff(firstName, lastName, id, password, role);
        return staff;
      } catch (IllegalArgumentException error) {
        System.err.println("Error: " + error.getMessage());
        System.err.println("Try Again or write \"menu\" to return main menu.");
      }
    }
  }

  @Override
  public void start() {
    printHeader();

    Staff staff = initializeStaff();

    String errorMessage = staffManagementService.registerStaff(staff);
    if (errorMessage.isEmpty()) {
      context.setLoggedInStaff(staff);
      System.err.println("Staff member created successfully.");
    } else {
      System.err.println(errorMessage);
    }
  }

  @Override
  public void printHeader() {
    System.err.println("=== REGISTRATION MENU ===");
  }
}
