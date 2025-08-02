package com.restaurant.menu;

import com.restaurant.menu.impl.MenuResult;

public interface Menu {
  MenuResult start();

  void printHeader();
}
