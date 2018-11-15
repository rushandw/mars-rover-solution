package com.rushan.solution.util;

public class Validator {

  public static boolean isValidUpperRightCoordinates(String input) {

    if (input == null || input.replaceAll("\\s+", "").length() != 2 || !input.replaceAll("\\s+", "").matches("[0-9]+")) {
      return false;
    }

    return true;
  }

  public static boolean isValidRoverCurrentCoordinates(String input) {
    if (input == null || input.replaceAll("\\s+", "").length() != 3 || !input.replaceAll("\\s+", "").substring(0, 2).matches("[0-9]+")) {
      return false;
    }

    if (input.replaceAll("\\s+", "").substring(2).equals("N") || input.replaceAll("\\s+", "").substring(2).equals("E") || input.replaceAll("\\s+", "").substring(2).equals("S")
        || input.replaceAll("\\s+", "").substring(2).equals("W")) {
      return true;
    }

    return false;
  }

  public static boolean isValidommands(String input) {

    if (!input.matches("[a-zA-Z]+")) {
      return false;
    }

    for (char c : input.toCharArray()) {
      if (!(c == 'M' || c == 'L' || c == 'R')) {
        return false;
      }
    }

    return true;

  }

}
