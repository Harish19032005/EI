package commands;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rover.Rover;

public class ExecutionerCommand implements Command {
    private static final Logger logger = Logger.getLogger(ExecutionerCommand.class.getName());
    private final List<Command> commands;

    public ExecutionerCommand(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute(Rover rover) {
        logger.info("Beginning command execution: " + commands.size() + " commands.");
        for (Command command : commands) {
            try {
                command.execute(rover);
            } catch (Exception ex) {
                logger.log(Level.SEVERE, "Command execution failed for " + command.getClass().getSimpleName(), ex);
                // continue to next command
            }
        }
        logger.info("Finished command execution.");
    }
}
