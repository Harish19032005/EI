package structural.composite;

import structural.composite.interfaces.Resource;
import common.logging.AppLogger;

import java.util.ArrayList;
import java.util.List;

public class ColonyResourceGroup implements Resource {
    private String name;
    private List<Resource> resources = new ArrayList<>();

    public ColonyResourceGroup(String name) {
        this.name = name;
    }

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    public void removeResource(Resource resource) {
        resources.remove(resource);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getQuantity() {
        return resources.stream().mapToInt(Resource::getQuantity).sum();
    }

    @Override
    public void showDetails() {
        AppLogger.info("Resource Group: " + name);
        for (Resource resource : resources) {
            resource.showDetails();
        }
        AppLogger.info("Total in " + name + ": " + getQuantity());
    }
}
