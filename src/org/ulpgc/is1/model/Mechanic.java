package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Mechanic {
    private final String name;
    private final String surname;
    private final List<Repair> repairs;
    private final RepairManager repairManager;

    public Mechanic(String name, String surname, RepairManager repairManager) {
        this.name = name;
        this.surname = surname;
        this.repairs = new ArrayList<>();
        this.repairManager = repairManager;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    public RepairManager getRepairManager() {
        return this.repairManager;
    }

    @Override
    public String toString() {
        return "Nombre y Apellido: " + this.name + " " + this.surname;
    }
}