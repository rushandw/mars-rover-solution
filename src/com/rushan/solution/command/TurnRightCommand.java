package com.rushan.solution.command;

import com.rushan.solution.core.Rover;

public class TurnRightCommand implements Command {

  @Override
  public void execute(final Rover rover) {
    rover.turnRight();

  }

}
