package com.rushan.solution.model;

public class Plateau {

  private Coordinates upperRightCoordinates;

  public Plateau() {
  }

  public Plateau(Coordinates upperRightCoordinates) {
    super();
    this.upperRightCoordinates = upperRightCoordinates;
  }

  public Coordinates getUpperRightCoordinates() {
    return upperRightCoordinates;
  }

  public void setUpperRightCoordinates(Coordinates upperRightCoordinates) {
    this.upperRightCoordinates = upperRightCoordinates;
  }
  
 

}
