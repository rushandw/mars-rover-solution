package com.rushan.solution.core;

import com.rushan.solution.model.Plateau;

@FunctionalInterface
public interface InputForRoverStartPositionHandler {

  Rover getCurrentPositionOfRover(Plateau plateau);
}
