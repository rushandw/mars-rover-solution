package com.rushan.solution.rover;

import com.rushan.solution.constants.Direction;
import com.rushan.solution.exception.AttemptToMoveOutOfPlateauException;
import com.rushan.solution.model.Coordinates;
import com.rushan.solution.model.Plateau;

public class Rover {

  private Coordinates currentCoordinates;

  private Direction currentDirection;

  private Plateau plateau;

  public Rover(Coordinates currentCoordinates, Direction currentDirection, Plateau plateau) {
    super();
    this.currentCoordinates = currentCoordinates;
    this.currentDirection = currentDirection;
    this.plateau = plateau;
  }

  public Coordinates getCurrentCoordinates() {
    return currentCoordinates;
  }

  public void setCurrentCoordinates(Coordinates currentCoordinates) {
    this.currentCoordinates = currentCoordinates;
  }

  public Direction getCurrentDirection() {
    return currentDirection;
  }

  public void setCurrentDirection(Direction currentDirection) {
    this.currentDirection = currentDirection;
  }

  public Plateau getPlateau() {
    return plateau;
  }

  public void setPlateau(Plateau plateau) {
    this.plateau = plateau;
  }

  public void move() {

    switch (currentDirection) {
    case N:
      if (this.getCurrentCoordinates().getyValue() + 1 > this.plateau.getUpperRightCoordinates().getyValue()){
        throw new AttemptToMoveOutOfPlateauException("Attempting to move out of the Plateau");
      }
      this.currentCoordinates = new Coordinates(this.currentCoordinates.getxValue(), this.getCurrentCoordinates().getyValue() + 1);
      break;

    case E:
      if (this.currentCoordinates.getxValue() + 1 > this.plateau.getUpperRightCoordinates().getxValue()){
        throw new AttemptToMoveOutOfPlateauException("Attempting to move out of the Plateau");
      }
      this.currentCoordinates = new Coordinates(this.currentCoordinates.getxValue() + 1, this.getCurrentCoordinates().getyValue());
      break;

    case S:
      if (this.getCurrentCoordinates().getyValue() - 1 < 0){
        throw new AttemptToMoveOutOfPlateauException("Attempting to move out of the Plateau");
      }
      this.currentCoordinates = new Coordinates(this.currentCoordinates.getxValue(), this.getCurrentCoordinates().getyValue() - 1);
      break;

    case W:
      if (this.currentCoordinates.getxValue() - 1 < 0){
        throw new AttemptToMoveOutOfPlateauException("Attempting to move out of the Plateau");
      }
      this.currentCoordinates = new Coordinates(this.currentCoordinates.getxValue() - 1, this.getCurrentCoordinates().getyValue());
      break;
    }

  }

  public void turnLeft() {

    switch (currentDirection) {

    case N:
      this.currentDirection = Direction.W;
      break;
    case E:
      this.currentDirection = Direction.N;
      break;
    case S:
      this.currentDirection = Direction.E;
      break;
    case W:
      this.currentDirection = Direction.S;
      break;

    }

  }

  public void turnRight() {

    switch (currentDirection) {

    case N:
      this.currentDirection = Direction.E;
      break;
    case E:
      this.currentDirection = Direction.S;
      break;
    case S:
      this.currentDirection = Direction.W;
      break;
    case W:
      this.currentDirection = Direction.N;
      break;

    }

  }

  public String toString() {
    return this.currentCoordinates.getxValue() + " " + this.currentCoordinates.getyValue() + " " + this.currentDirection;

  }

}
