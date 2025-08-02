package com.restaurant.entities;

import com.restaurant.enums.StaffRole;

public interface Staff {
  public String getFirstName();

  public String getId();

  public String getPassword();

  public StaffRole getRole();

  public StaffRole validateStaffRole(String role);

  public boolean isPasswordValid(String candidate);
}
