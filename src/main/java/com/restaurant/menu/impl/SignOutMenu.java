package com.restaurant.menu.impl;

import com.restaurant.menu.Menu;
import com.restaurant.state.ApplicationContext;

public class SignOutMenu implements Menu {
  ApplicationContext context;

  public SignOutMenu() {
    this.context = ApplicationContext.getInstance();
  }

  @Override
  public MenuResult start() {
    String firstName = context.getLoggedInStaff().getFirstName();
    context.setLoggedInStaff(null);
    return new MenuResult(true, "Have a nice day " + firstName + "!", true);
  }

  @Override
  public void printHeader() {
    System.err.println(
        "Have a nice day " + context.getLoggedInStaff().getFirstName() + "!" + "Look forward to welcoming back!");
  }
}
