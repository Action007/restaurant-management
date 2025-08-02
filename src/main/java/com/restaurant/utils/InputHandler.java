package com.restaurant.utils;

import java.util.Scanner;
import java.util.function.Predicate;

public class InputHandler {
  private Scanner scanner;

  public InputHandler() {
    scanner = new Scanner(System.in);
  }

  public String getInput(String prompt) {
    System.err.println(prompt);
    String input = scanner.nextLine();
    return input;
  };

  // public String getValidatedInput(String prompt, Predicate<String> validator,
  // String errorMessage) {
  // if (validator.test(prompt)) {
  // return errorMessage;
  // }
  // return "";
  // };

  public boolean isMenuCommand(String input) {
    return "menu".equalsIgnoreCase(input.trim());
  }

  public void close() {
    scanner.close();
  };
}
