package rover;

import grid.Grid;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class Rover {
    private int x;
    private int y;
    private Direction direction;
    private Grid grid;
    private Set<String> encounteredObstacles;
    private Set<String> encounteredOutOfBounds;
    private static final Logger logger = Logger.getLogger(Rover.class.getName());

    public Rover(int x, int y, Direction direction, Grid grid) {
        if (grid == null) {
            throw new IllegalArgumentException("Grid cannot be null");
        }
        this.grid = grid;
        if (!grid.isWithinBounds(x, y)) {
            logger.warning("Rover initial position out of bounds; clamping to grid.");
            this.x = Math.max(0, Math.min(x, grid.getWidth()-1));
            this.y = Math.max(0, Math.min(y, grid.getHeight()-1));
        } else {
            this.x = x;
            this.y = y;
        }
        this.direction = direction;
        this.encounteredObstacles = new HashSet<>();
        this.encounteredOutOfBounds = new HashSet<>();
    }

    public void move() {
        int newX = x;
        int newY = y;
        switch (direction) {
            case N -> newY += 1;
            case E -> newX += 1;
            case S -> newY -= 1;
            case W -> newX -= 1;
        }
        if (grid.isWithinBounds(newX, newY) && !grid.isObstacle(newX, newY)) {
            x = newX;
            y = newY;
        } else if (grid.isObstacle(newX, newY)) {
            encounteredObstacles.add("(" + newX + "," + newY + ")");
        } else {
            encounteredOutOfBounds.add("(" + newX + "," + newY + ")");
        }
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void turnBack() {
        direction = direction.turnBack();
    }   

    public StatusReport getStatusReport() {
        return new StatusReport(x, y, direction);
    }

    public Set<String> getEncounteredOutOfBounds() {
        return encounteredOutOfBounds;
    }
    public Set<String> getEncounteredObstacles() {
        return encounteredObstacles;
    }
}
