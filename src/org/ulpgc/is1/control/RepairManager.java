package org.ulpgc.is1.control;

import java.util.ArrayList;
import java.util.List;
import org.ulpgc.is1.model.*;


public class RepairManager {
    private List<Mechanic> mechanics;
    private List<Vehicle> vehicles;
    private List<SparePart> spareParts;
    private List<Repair> repairs;

    public RepairManager() {
        this.mechanics = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.spareParts = new ArrayList<>();
        this.repairs = new ArrayList<>();
    }

    public void addMechanic(Mechanic mechanic) {
        this.mechanics.add(mechanic);
    }

    public Mechanic getMechanic(int index) {
        return this.mechanics.get(index);
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public Vehicle getVehicle(int index) {
        return this.vehicles.get(index);
    }

    public Vehicle getVehicle(String model) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getModel().equals(model)) {
                return vehicle;
            }
        }
        return null;
    }

    public void addPart(SparePart part) {
        this.spareParts.add(part);
    }

    public SparePart getParts(String name) {
        for (SparePart part : spareParts) {
            if (part.getName().equals(name)) {
                return part;
            }
        }
        return null;
    }

    public void repair(Repair repair) {
        this.repairs.add(repair);
        repair.getVehicle().addRepair(repair);
        for (Mechanic mechanic : mechanics) {
            mechanic.addRepair(repair);
        }
    }

    public void removeVehicle(String model) {
        this.vehicles.removeIf(vehicle -> vehicle.getModel().equals(model));
    }

    public int getNumberOfVehicles() {
        return this.vehicles.size();
    }

    public List<Repair> getRepairs() {
        return new ArrayList<>(this.repairs);
    }
}
