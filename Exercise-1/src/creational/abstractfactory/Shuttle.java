package creational.abstractfactory;

import common.exceptions.InvalidActionException;
import common.logging.AppLogger;
import creational.abstractfactory.interfaces.Spacecraft;

public class Shuttle implements Spacecraft {
    private String name;
    private int fuelLevel;
    private int crewCapacity;
    private String status;
    private static final int FUEL_CONSUMPTION = 40;
    private static final int MAX_FUEL = 150;

    public Shuttle(String name, int crewCapacity) {
        this.name = name;
        this.crewCapacity = crewCapacity;
        this.fuelLevel = MAX_FUEL;
        this.status = "READY";
        AppLogger.info("Shuttle " + name + " created with crew capacity " + crewCapacity);
    }

    @Override
    public void launch() throws InvalidActionException {
        if (fuelLevel < FUEL_CONSUMPTION) {
            throw new InvalidActionException("Not enough fuel to launch!");
        }
        if (status.equals("LAUNCHED")) {
            throw new InvalidActionException("Shuttle is already launched!");
        }
        fuelLevel -= FUEL_CONSUMPTION;
        status = "LAUNCHED";
        AppLogger.info("Shuttle " + name + " launched. Fuel left: " + fuelLevel);
    }

    @Override
    public void land() throws InvalidActionException {
        if (!status.equals("LAUNCHED")) {
            throw new InvalidActionException("Shuttle must be launched before landing!");
        }
        status = "LANDED";
        AppLogger.info("Shuttle " + name + " landed successfully.");
    }

    @Override
    public void refuel(int amount) throws InvalidActionException {
        if (status.equals("LAUNCHED")) {
            throw new InvalidActionException("Cannot refuel while in flight!");
        }
        fuelLevel = Math.min(fuelLevel + amount, MAX_FUEL);
        AppLogger.info("Shuttle " + name + " refueled. Current fuel: " + fuelLevel);
    }

    @Override
    public void showStatus() {
        AppLogger.info("Shuttle " + name + " [Crew: " + crewCapacity + 
                       ", Fuel: " + fuelLevel + ", Status: " + status + "]");
    }
}
