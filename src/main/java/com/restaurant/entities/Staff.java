package com.restaurant.entities;

import com.restaurant.enums.StaffRole;

public interface Staff {
  public String getFirstName();

  public String getId();

  public String getPassword();

  public StaffRole getRole();
}
