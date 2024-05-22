package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Mechanic {
    private String name;
    private String surname;
    private ArrayList<Repair> repairs;

    public Mechanic(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.repairs = new ArrayList<Repair>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    public ArrayList<Repair> getRepair() {
        return repairs;
    }

    @Override
    public String toString() {
        return "Nombre y Apellidos: " + this.name + " " + this.surname;
    }
}