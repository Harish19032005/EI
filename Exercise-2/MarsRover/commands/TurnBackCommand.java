package commands;

import rover.Rover;

public class TurnBackCommand implements Command{
    @Override
    public void execute(Rover rover) {
        rover.turnBack();
    }
}
