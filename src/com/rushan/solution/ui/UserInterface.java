package com.rushan.solution.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import com.rushan.solution.constants.Constants;
import com.rushan.solution.constants.Direction;
import com.rushan.solution.exception.AttemptToMoveOutOfPlateauException;
import com.rushan.solution.exception.UserInputCollectingException;
import com.rushan.solution.model.Coordinates;
import com.rushan.solution.model.Plateau;
import com.rushan.solution.rover.Rover;
import com.rushan.solution.util.Parser;
import com.rushan.solution.util.Validator;

public class UserInterface {

  public static Plateau getUpperRightCoordinatesofPlateau() {
    String userInputForUpperRightCoordinates = getInput(Constants.MESSAGE_FOR_UPPER_RIGHT_COORDINATES);
    while (true) {
      if (Validator.isValidUpperRightCoordinates(userInputForUpperRightCoordinates)) {
        Coordinates upperRightCoordinates = Parser.parseToCoordinates(userInputForUpperRightCoordinates);
        return new Plateau(upperRightCoordinates);
      }
      System.out.println(Constants.INVALID_UPPER_RIGHT_COORDINATES);
      userInputForUpperRightCoordinates = getInput(Constants.MESSAGE_FOR_UPPER_RIGHT_COORDINATES);
    }
  }

  public static Rover getCurrentPositionOfRover(Plateau plateau) {

    String userInputForRoverCuurentCoordinates = getInput(Constants.MESSAGE_FOR_ROVER_CURRENT_COORDINATES);
    while (true) {
      if (Validator.isValidRoverCurrentCoordinates(userInputForRoverCuurentCoordinates)) {

        int xValue = Integer.parseInt(userInputForRoverCuurentCoordinates.replaceAll("\\s+", "").substring(0, 1));
        int yValue = Integer.parseInt(userInputForRoverCuurentCoordinates.replaceAll("\\s+", "").substring(1, 2));
        Direction direction = Direction.valueOf(userInputForRoverCuurentCoordinates.replaceAll("\\s+", "").substring(2).toUpperCase(Locale.ENGLISH));
        return new Rover(new Coordinates(xValue, yValue), direction, plateau);
      }
      System.out.println(Constants.INVALID_CURRENT_COORDINATES);
      userInputForRoverCuurentCoordinates = getInput(Constants.MESSAGE_FOR_ROVER_CURRENT_COORDINATES);
    }

  }

  public static void HandleCommads(Rover rover) {
    String userInputForCommands = getInput(Constants.MESSAGE_FOR_COMMANDS);
    while (true) {
      if (Validator.isValidommands(userInputForCommands)) {

        char[] commandsArray = userInputForCommands.toCharArray();
        for (char c : commandsArray) {
          try {
            Parser.getCommand(c).execute(rover);
          } catch (AttemptToMoveOutOfPlateauException e) {
            System.out.println("Trying to move out of the Plateau : Therefore moving stopped.");
            System.out.print("Current Position is : ");
            break;
          }

        }

        System.out.println(rover.toString());
        break;
      }
      System.out.println(Constants.INVALID_COMMANDS);
      userInputForCommands = getInput(Constants.MESSAGE_FOR_COMMANDS);
    }
  }

  public static String getInput(final String messageToUser) {

    System.out.println(messageToUser);
    String input = "";
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    try {
      input = reader.readLine();
    } catch (IOException e) {
      throw new UserInputCollectingException("Can not collect user inputs");
    }
    return input;
  }

}
