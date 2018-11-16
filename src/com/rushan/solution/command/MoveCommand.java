package com.rushan.solution.command;

import com.rushan.solution.core.Rover;

public class MoveCommand implements Command{

  @Override
  public void execute(final Rover rover) {
    rover.move();
    
  }

}
