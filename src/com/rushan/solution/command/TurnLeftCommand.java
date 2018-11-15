package com.rushan.solution.command;

import com.rushan.solution.rover.Rover;

public class TurnLeftCommand implements Command {

  @Override
  public void execute(final Rover rover) {
    rover.turnLeft();

  }

}
