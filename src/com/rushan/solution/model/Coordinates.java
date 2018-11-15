package com.rushan.solution.model;

public class Coordinates {
  private int xValue;
  private int yValue;

  public Coordinates() {
  }

  public Coordinates(int xValue, int yValue) {
    super();
    this.xValue = xValue;
    this.yValue = yValue;
  }

  public int getxValue() {
    return xValue;
  }

  public void setxValue(int xValue) {
    this.xValue = xValue;
  }

  public int getyValue() {
    return yValue;
  }

  public void setyValue(int yValue) {
    this.yValue = yValue;
  }

}
