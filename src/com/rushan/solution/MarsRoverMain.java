package com.rushan.solution;

import com.rushan.solution.model.Plateau;
import com.rushan.solution.rover.Rover;
import com.rushan.solution.ui.UserInterface;

public class MarsRoverMain {

  public static void main(String args[]) {

    
    Plateau plateau = UserInterface.getUpperRightCoordinatesofPlateau();

    while (true) {
      Rover rover = UserInterface.getCurrentPositionOfRover(plateau);
      UserInterface.HandleCommads(rover);
    }

  }

}
