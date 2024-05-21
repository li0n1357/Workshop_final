package org.ulpgc.is1.model;

import java.util.HashMap;
import java.util.Map;

public class RepairManager {
    private final Map<String, Mechanic> mechanics;
    private final Map<String, Vehicle> vehicles;

    public RepairManager() {
        this.mechanics = new HashMap<>();
        this.vehicles = new HashMap<>();
    }

    public void addMechanic(String name, Mechanic mechanic) {
        mechanics.put(name, mechanic);
    }

    public void addVehicle(String model, Vehicle vehicle) {
        vehicles.put(model, vehicle);
    }

    public Mechanic getMechanic(String name) {
        return mechanics.get(name);
    }

    public Vehicle getVehicle(String model) {
        return vehicles.get(model);
    }

    public void repair() {

    }
}