package com.rushan.solution.util;

public class Validator {

  public static boolean isValidUpperRightCoordinates(String input) {

    if (input == null || input.replaceAll("\\s+", "").length() == 0 || !input.replaceAll("\\s+", "").matches("[0-9]+") || input.split("\\s+").length != 2) {
      return false;
    }

    return true;
  }

  public static boolean isValidRoverCurrentCoordinates(String input) {
    String[] splitted = input.split("\\s+");
    if (input == null || input.replaceAll("\\s+", "").length() == 0 || splitted.length != 3 || !splitted[0].matches("[0-9]+") || !splitted[1].matches("[0-9]+")) {
      return false;
    }

    if (splitted[2].equals("N") || splitted[2].equals("E") || splitted[2].equals("S") || splitted[2].equals("W")) {
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
