package creational.abstractfactory;

import creational.abstractfactory.interfaces.Spacecraft;
import creational.abstractfactory.interfaces.SpacecraftFactory;

public class RoverFactory implements SpacecraftFactory {
    @Override
    public Spacecraft createSpacecraft(String name, int crewCapacity) {
        return new Rover(name, crewCapacity);
    }
}
