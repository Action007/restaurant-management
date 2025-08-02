package com.restaurant;

import com.restaurant.menu.Menu;
import com.restaurant.menu.impl.MainMenu;
import com.restaurant.services.impl.DefaultStaffManagerService;
import com.restaurant.state.ApplicationContext;

public class App {
    public static void main(String[] args) {
        DefaultStaffManagerService staffService = new DefaultStaffManagerService();
        ApplicationContext context = new ApplicationContext();

        MainMenu mainMenu = new MainMenu(staffService, context);

        mainMenu.start();
    }
}
