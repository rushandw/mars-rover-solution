package com.rushan.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import com.rushan.solution.constants.Constants;
import com.rushan.solution.constants.Direction;
import com.rushan.solution.core.InputForCommandsHandler;
import com.rushan.solution.core.InputForRoverStartPositionHandler;
import com.rushan.solution.core.InputForUpperRightCoordinatesHandler;
import com.rushan.solution.core.Rover;
import com.rushan.solution.exception.AttemptToMoveOutOfPlateauException;
import com.rushan.solution.exception.UserInputCollectingException;
import com.rushan.solution.model.Coordinates;
import com.rushan.solution.model.Plateau;
import com.rushan.solution.util.Parser;
import com.rushan.solution.util.Validator;

public class MarsRoverMain {

  public static void main(String args[]) {

    InputForUpperRightCoordinatesHandler forUpperRightCoordinatesHandler = () -> {
      String userInputForUpperRightCoordinates = getInput(Constants.MESSAGE_FOR_UPPER_RIGHT_COORDINATES);
      while (true) {
        if (Validator.isValidUpperRightCoordinates(userInputForUpperRightCoordinates)) {
          Coordinates upperRightCoordinates = Parser.parseToCoordinates(userInputForUpperRightCoordinates);
          return new Plateau(upperRightCoordinates);
        }
        System.out.println(Constants.INVALID_UPPER_RIGHT_COORDINATES);
        userInputForUpperRightCoordinates = getInput(Constants.MESSAGE_FOR_UPPER_RIGHT_COORDINATES);
      }

    };

    Plateau plateau = forUpperRightCoordinatesHandler.getUpperRightCoordinatesofPlateau();

    while (true) {

      InputForRoverStartPositionHandler inputForRoverStartPositionHandler = (plateauOfRover) -> {
        String userInputForRoverCuurentCoordinates = getInput(Constants.MESSAGE_FOR_ROVER_CURRENT_COORDINATES);
        while (true) {
          if (Validator.isValidRoverCurrentCoordinates(userInputForRoverCuurentCoordinates)) {
            String[] splittedArray = Parser.getSplittedArray(userInputForRoverCuurentCoordinates);
            int xValue = Integer.parseInt(splittedArray[0]);
            int yValue = Integer.parseInt(splittedArray[1]);
            Direction direction = Direction.valueOf(splittedArray[2].toUpperCase(Locale.ENGLISH));
            return new Rover(new Coordinates(xValue, yValue), direction, plateau);
          }
          System.out.println(Constants.INVALID_CURRENT_COORDINATES);
          userInputForRoverCuurentCoordinates = getInput(Constants.MESSAGE_FOR_ROVER_CURRENT_COORDINATES);
        }
      };

      Rover rover = inputForRoverStartPositionHandler.getCurrentPositionOfRover(plateau);

      InputForCommandsHandler inputForCommandsHandler = (currentRover) -> {
        String userInputForCommands = getInput(Constants.MESSAGE_FOR_COMMANDS);
        while (true) {
          if (Validator.isValidommands(userInputForCommands)) {

            char[] commandsArray = userInputForCommands.toCharArray();
            for (char c : commandsArray) {
              try {
                Parser.getCommand(c).execute(rover);
              } catch (AttemptToMoveOutOfPlateauException e) {
                System.out.println(Constants.TRYING_TO_MOVE_OUT_OF_PLATEAU);
                break;
              }

            }

            System.out.println(Constants.ROVER_NEW_POSITION + rover.toString() + "\n\n");
            break;
          }
          System.out.println(Constants.INVALID_COMMANDS);
          userInputForCommands = getInput(Constants.MESSAGE_FOR_COMMANDS);
        }
      };

      inputForCommandsHandler.HandleCommads(rover);
    }

  }

  public static String getInput(final String messageToUser) {

    System.out.println(messageToUser);
    String input = "";
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    try {
      input = reader.readLine();
    } catch (IOException e) {
      throw new UserInputCollectingException(Constants.CAN_NOT_COLLECT_USER_INPUTS);
    }
    return input;
  }

}
