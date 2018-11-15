package com.rushan.solution.command;

import com.rushan.solution.rover.Rover;

public interface Command {
  
  public void execute(final Rover rover);

}
