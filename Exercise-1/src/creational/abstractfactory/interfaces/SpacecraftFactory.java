package creational.abstractfactory.interfaces;

public interface SpacecraftFactory {
    Spacecraft createSpacecraft(String name, int crewCapacity);
}
