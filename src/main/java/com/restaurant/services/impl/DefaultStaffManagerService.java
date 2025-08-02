package com.restaurant.services.impl;

import java.util.HashMap;

import com.restaurant.entities.Staff;
import com.restaurant.entities.impl.DefaultStaff;
import com.restaurant.services.StaffManagementService;

public class DefaultStaffManagerService implements StaffManagementService {
  private static DefaultStaffManagerService instance;
  private HashMap<String, Staff> staffMap = new HashMap<>();

  private DefaultStaffManagerService() {
    staffMap.put("1000", new DefaultStaff("Default", "Manager", "1000", "manager", "Manager"));
  }

  public static DefaultStaffManagerService getInstance() {
    if (instance == null) {
      instance = new DefaultStaffManagerService();
    }
    return instance;
  }

  public String registerStaff(Staff staff) {
    if (staff == null) {
      return "Staff cannot be null.";
    }

    if (staffMap.containsKey(staff.getId())) {
      return "A user with this ID already exists.";
    }

    staffMap.put(staff.getId(), staff);
    return "";
  }

  public Staff login(String id, String password) {
    Staff staff = staffMap.get(id);
    if (staff != null && staff.getPassword().equals(password)) {
      return staff;
    } else {
      return null;
    }
  }

  public Staff getStaffById(String staffId) {
    Staff staff = staffMap.get(staffId);
    if (staff != null) {
      return staff;
    } else {
      return null;
    }
  }
}