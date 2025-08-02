package com.restaurant.menu.impl;

import com.restaurant.entities.Staff;
import com.restaurant.menu.Menu;
import com.restaurant.services.StaffManagementService;
import com.restaurant.services.impl.DefaultStaffManagerService;
import com.restaurant.state.ApplicationContext;
import com.restaurant.utils.InputHandler;

public class SignInMenu implements Menu {
  StaffManagementService staffManagementService;
  ApplicationContext context;
  InputHandler inputHandler;

  public SignInMenu() {
    this.staffManagementService = DefaultStaffManagerService.getInstance();
    this.context = ApplicationContext.getInstance();
    this.inputHandler = new InputHandler();
  }

  private Staff initializeStaff() {

    while (true) {
      String idString = inputHandler.getInput("Staff ID:");
      if (inputHandler.isMenuCommand(idString)) {
        return null;
      }
      String passwoString = inputHandler.getInput("Password:");
      if (inputHandler.isMenuCommand(passwoString)) {
        return null;
      }

      Staff staff = staffManagementService.login(idString, passwoString);

      if (staff == null) {
        System.err.println("Incorrect ID or password.");
        System.err.println("Try Again or write \"menu\" to return main menu.");
        continue;
      }

      return staff;
    }
  }

  @Override
  public void start() {
    printHeader();
    Staff staff = initializeStaff();
    context.setLoggedInStaff(staff);
    System.err.println("Welcome back" + context.getLoggedInStaff().getFirstName() + "!");
  }

  @Override
  public void printHeader() {
    System.err.println("=== SIGN-IN MENU ===");
  }
}
