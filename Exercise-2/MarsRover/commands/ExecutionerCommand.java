package commands;
import java.util.List;
import rover.Rover;
public class ExecutionerCommand implements Command {
    private final List<Command> commands;
    public ExecutionerCommand(List<Command> commands) {
        this.commands = commands;
    }
    @Override
    public void execute(Rover rover) {
        for (Command command : commands) {
            command.execute(rover);
        }
    }
}