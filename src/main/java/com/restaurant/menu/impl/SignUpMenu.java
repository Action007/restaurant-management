package com.restaurant.menu.impl;

import java.util.Scanner;

import com.restaurant.entities.Staff;
import com.restaurant.entities.impl.DefaultStaff;
import com.restaurant.menu.Menu;
import com.restaurant.services.StaffManagementService;
import com.restaurant.state.ApplicationContext;

public class SignUpMenu implements Menu {
  private StaffManagementService staffService;
  private ApplicationContext context;

  public SignUpMenu(StaffManagementService staffService, ApplicationContext context) {
    this.staffService = staffService;
    this.context = context;
  }

  private Staff initializeStaff() {
    Scanner sc = new Scanner(System.in);

    while (true) {
      try {
        System.err.println("Enter First Name:");
        String firstName = sc.nextLine();
        if (context.isMenuCommand(firstName)) {
          return null; // cancel registration
        }
        System.err.println("Enter Last Name:");
        String lastName = sc.nextLine();
        if (context.isMenuCommand(lastName)) {
          return null; // cancel registration
        }
        System.err.println("Enter Id:");
        String id = sc.nextLine();
        if (context.isMenuCommand(id)) {
          return null; // cancel registration
        }
        System.err.println("Enter Password:");
        String password = sc.nextLine();
        if (context.isMenuCommand(password)) {
          return null; // cancel registration
        }
        System.err.println("Enter Role:");
        String role = sc.nextLine();
        if (context.isMenuCommand(role)) {
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

    String errorMessage = staffService.registerStaff(staff);
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