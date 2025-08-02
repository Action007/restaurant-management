package com.restaurant.menu.impl;

import com.restaurant.entities.impl.DefaultStaff;
import com.restaurant.menu.Menu;
import com.restaurant.services.impl.DefaultStaffManagerService;
import com.restaurant.state.ApplicationContext;

public class SignOutMenu implements Menu {
  ApplicationContext context;

  public SignOutMenu(ApplicationContext context) {
    this.context = context;
  }

  @Override
  public void start() {
    printHeader();
    context.setLoggedInStaff(null);
  }

  @Override
  public void printHeader() {
    System.err.println(
        "Have a nice day " + context.getLoggedInStaff().getFirstName() + "!" + "Look forward to welcoming back!");
  }
}
