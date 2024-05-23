package org.ulpgc.is1.model;
import org.ulpgc.is1.control.RepairManager;


import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private final String make;
    private final String model;
    private final Plate plate;
    private final Customer owner;
    private final RepairManager repairManager;
    private final List<Repair> repairs;


    public Vehicle(String make, String model, Plate plate, Customer owner, RepairManager repairManager) {
        this.make = make;
        this.model = model;
        this.plate = plate;
        this.owner = owner;
        this.repairManager = repairManager;
        this.repairs = new ArrayList<>();
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Plate getPlate() {
        return plate;
    }

    public Customer getOwner() {
        return owner;
    }

    public RepairManager getRepairManager() {
        return repairManager;
    }

    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    public List<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        return "Vehiculo -> " + "marca: '" + make + ", modelo: '" + model + ", matrícula: " + plate;
    }
}