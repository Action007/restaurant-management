package com.restaurant.menu.impl;

import java.util.HashMap;
import java.util.Scanner;

import com.restaurant.menu.Menu;
import com.restaurant.services.StaffManagementService;
import com.restaurant.state.ApplicationContext;

public class MainMenu implements Menu {
  private StaffManagementService staffService;
  private ApplicationContext context;

  public final HashMap<String, Menu> unauthorizedMenuOptionMap = new HashMap<>();
  public final HashMap<String, Menu> authorizedMenuOptionMap = new HashMap<>();
  public final String MENU_OPTIONS_AUTHORIZED = "Please select option to proceed.";

  public final String MENU_INFO = "Please select option to proceed.";
  public final String MENU_INFO_UNAUTHORIZED = "1. Staff Sign Up" + System.lineSeparator() + "2. Staff Sign In";
  public final String MENU_INFO_AUTHORIZED = "1. Staff Sign Out";
  public final String ERROR_MESSAGE = "Only 1, 2, 3, 4, 5 is allowed. Try again.";

  public MainMenu(StaffManagementService staffService, ApplicationContext context) {
    this.staffService = staffService;
    this.context = context;

    unauthorizedMenuOptionMap.put("1", new SignUpMenu(staffService, context));
    unauthorizedMenuOptionMap.put("2", new SignInMenu(staffService, context));

    authorizedMenuOptionMap.put("1", new SignOutMenu(context));
  }

  @Override
  public void start() {
    Menu menu = null;
    Scanner sc = new Scanner(System.in);

    while (true) {
      printHeader();

      String userInput = sc.nextLine().trim();

      if (context.getLoggedInStaff() == null) {
        menu = unauthorizedMenuOptionMap.get(userInput);
      } else {
        menu = authorizedMenuOptionMap.get(userInput);
      }

      if (menu != null) {
        menu.start();
      } else {
        System.err.println(ERROR_MESSAGE);
      }
    }
  }

  @Override
  public void printHeader() {
    System.err.println("=== RESTAURANT MANAGEMENT SYSTEM ===");
    System.err.println(MENU_INFO);
    if (context.getLoggedInStaff() == null) {
      System.err.println(MENU_INFO_UNAUTHORIZED);
    } else {
      System.err.println(MENU_INFO_AUTHORIZED);
    }
  }
}