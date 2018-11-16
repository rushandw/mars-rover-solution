package com.rushan.solution.util;

import com.rushan.solution.command.Command;
import com.rushan.solution.command.MoveCommand;
import com.rushan.solution.command.TurnLeftCommand;
import com.rushan.solution.command.TurnRightCommand;
import com.rushan.solution.model.Coordinates;

public class Parser {

  public static Coordinates parseToCoordinates(String userInput) {

    String[] splittedInputArray = getSplittedArray(userInput);
    int xValue = Integer.parseInt(splittedInputArray[0]);
    int yValue = Integer.parseInt(splittedInputArray[1]);

    Coordinates coordinates = new Coordinates(xValue, yValue);

    return coordinates;
  }

  public static Command getCommand(Character command) {

    switch (command) {

    case 'M':
      return new MoveCommand();
    case 'R':
      return new TurnRightCommand();
    case 'L':
      return new TurnLeftCommand();
    }

    return null;

  }

  public static String[] getSplittedArray(String input) {
    String[] splitedinputArray = input.split("\\s+");
    return splitedinputArray;
  }
}
