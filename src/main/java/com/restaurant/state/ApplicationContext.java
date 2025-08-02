package com.restaurant.state;

import com.restaurant.entities.Staff;

public class ApplicationContext {
  private Staff loggedInStaff;

  public void setLoggedInStaff(Staff staff) {
    this.loggedInStaff = staff;
  }

  public Staff getLoggedInStaff() {
    return this.loggedInStaff;
  }

  public boolean isLoggedIn() {
    return loggedInStaff != null;
  }

  public boolean isMenuCommand(String input) {
    return "menu".equalsIgnoreCase(input.trim());
  }
}