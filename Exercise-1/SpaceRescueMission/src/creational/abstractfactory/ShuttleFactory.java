package creational.abstractfactory;

import creational.abstractfactory.interfaces.Spacecraft;
import creational.abstractfactory.interfaces.SpacecraftFactory;

public class ShuttleFactory implements SpacecraftFactory {
    @Override
    public Spacecraft createSpacecraft(String name, int crewCapacity) {
        return new Shuttle(name, crewCapacity);
    }
}
