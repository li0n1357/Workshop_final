package org.ulpgc.is1.model;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class RepairManager {
    private final Map<String, Mechanic> mechanics;
    private final Map<String, Vehicle> vehicles;
    private final Map<Integer, Repair> repairs;
    private final List<SparePart> parts;

    public RepairManager() {
        this.mechanics = new HashMap<>();
        this.vehicles = new HashMap<>();
        this.repairs = new HashMap<>();
        this.parts = new ArrayList<>();
    }

    public void addMechanic(String name, Mechanic mechanic) {
        mechanics.put(name, mechanic);
    }

    public void addVehicle(String model, Vehicle vehicle) {
        vehicles.put(model, vehicle);
    }

    public void addPart(SparePart part) {
        parts.add(part);
    }

    public Mechanic getMechanic(String name) {
        return mechanics.get(name);
    }

    public Vehicle getVehicle(String model) {
        return vehicles.get(model);
    }

    public void addRepair(Repair repair) {
        repairs.put(repair.getID(), repair);
        Vehicle vehicle = repair.getVehicle();
        if (vehicle != null) {
            vehicle.addRepair(repair);
        }
    }

    public void removeVehicle(String model) {
        vehicles.remove(model);
    }

    public int getNumberOfVehicles() {
        return vehicles.size();
    }

    public Map<Integer, Repair> getRepairs() {
        return repairs;
    }

    public void repair(Repair repair) {
        Vehicle vehicle = repair.getVehicle();
        if (vehicle != null) {
            addRepair(repair);
            Payment payment = repair.getPayment();
            System.out.println("Se ha facturado $" + payment.amount() + " por la reparación.");
        } else {
            System.out.println("No se pudo realizar la reparación. Vehículo no encontrado.");
        }
    }
}