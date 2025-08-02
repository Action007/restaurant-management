package com.restaurant.services;

import com.restaurant.entities.Staff;

public interface StaffManagementService {
  Staff login(String id, String password);

  Staff getStaffById(String staffId);

  String registerStaff(Staff staff);
}
