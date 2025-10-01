package rover;

public enum Direction {
    N, E, S, W;

    public Direction turnLeft() {
        return values()[(ordinal() + 3) % 4];
    }

    public Direction turnRight() {
        return values()[(ordinal() + 1) % 4];
    }    

    public Direction turnBack() {
        return values()[(ordinal() + 2) % 4];
    }

    @Override
    public String toString() {
        return switch (this) {
            case N -> "North";
            case E -> "East";
            case S -> "South";
            case W -> "West";
        };
    }
}
