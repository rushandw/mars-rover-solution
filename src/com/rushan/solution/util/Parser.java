package com.rushan.solution.util;

import com.rushan.solution.command.Command;
import com.rushan.solution.command.MoveCommand;
import com.rushan.solution.command.TurnLeftCommand;
import com.rushan.solution.command.TurnRightCommand;
import com.rushan.solution.model.Coordinates;

public class Parser {

  public static Coordinates parseToCoordinates(String userInput){
    
    int xValue =Integer.parseInt(userInput.replaceAll("\\s+","").substring(0, 1));
    int yValue =Integer.parseInt(userInput.replaceAll("\\s+","").substring(1));
    Coordinates upperRightCoordinates = new Coordinates(xValue,yValue);  
    
    return upperRightCoordinates;
  }
  
  public static Command getCommand(Character command){
    
    switch (command){
      
    case 'M' : return new MoveCommand();
    case 'R' : return new TurnRightCommand();
    case 'L' : return new TurnLeftCommand();
    }   
    
    return null;
    
  }
}
