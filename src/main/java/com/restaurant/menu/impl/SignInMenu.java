package com.restaurant.menu.impl;

import java.util.Scanner;

import com.restaurant.entities.Staff;
import com.restaurant.menu.Menu;
import com.restaurant.services.StaffManagementService;
import com.restaurant.services.impl.DefaultStaffManagerService;
import com.restaurant.state.ApplicationContext;

public class SignInMenu implements Menu {
  private StaffManagementService staffService;
  private ApplicationContext context;

  public SignInMenu(StaffManagementService staffService, ApplicationContext context) {
    this.staffService = staffService;
    this.context = context;
  }

  private Staff initializeStaff() {
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.err.println("Staff ID:");
      String idString = sc.nextLine();
      if (context.isMenuCommand(idString)) {
        return null;
      }
      System.err.println("Password:");
      String passwoString = sc.nextLine();
      if (context.isMenuCommand(passwoString)) {
        return null;
      }

      Staff staff = staffService.login(idString, passwoString);

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
    if (staff == null) {
      return;
    }
    context.setLoggedInStaff(staff);
    System.err.println("Welcome back" + context.getLoggedInStaff().getFirstName() + "!");
  }

  @Override
  public void printHeader() {
    System.err.println("=== SIGN-IN MENU ===");
  }
}