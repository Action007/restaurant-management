package com.restaurant.state;

import com.restaurant.entities.Staff;
import com.restaurant.enums.StaffRole;

public class ApplicationContext {
  private static ApplicationContext instance;

  private Staff loggedInStaff;

  public static ApplicationContext getInstance() {
    if (instance == null) {
      instance = new ApplicationContext();
    }
    return instance;
  }

  public void setLoggedInStaff(Staff staff) {
    loggedInStaff = staff;
  }

  public Staff getLoggedInStaff() {
    return loggedInStaff;
  }

  public boolean isLoggedIn() {
    return loggedInStaff != null;
  }

  public boolean isManager() {
    return loggedInStaff.getRole() == StaffRole.MANAGER;
  }
}
