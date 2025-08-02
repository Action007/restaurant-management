package com.restaurant;

import com.restaurant.menu.Menu;
import com.restaurant.menu.impl.MainMenu;

public class App {
    public static void main(String[] args) {
        Menu mainMenu = new MainMenu();
        mainMenu.start();
    }
}
