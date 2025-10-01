package creational.abstractfactory.interfaces;

public interface Spacecraft {
    void launch() throws Exception;
    void land() throws Exception;
    void refuel(int amount) throws Exception;
    void showStatus();
}
