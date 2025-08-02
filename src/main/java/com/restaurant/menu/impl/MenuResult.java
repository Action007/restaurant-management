package com.restaurant.menu.impl;

public class MenuResult {
  private boolean success;
  private String message;
  private boolean shouldReturnToMainMenu;

  public MenuResult(boolean success, String message, boolean shouldReturnToMainMenu) {
    this.success = success;
    this.message = message;
    this.shouldReturnToMainMenu = shouldReturnToMainMenu;
  }

  public boolean isSuccess() {
    return success;
  }

  public String getMessage() {
    return message;
  }

  public boolean shouldReturnToMainMenu() {
    return shouldReturnToMainMenu;
  }
}