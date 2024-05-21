package org.ulpgc.is1.model;

public class Mechanic {
    private final String name;
    private final String surname;

    public Mechanic(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    @Override
    public String toString() {
        return "Nombre y Apellido: " + this.name + " " + this.surname;
    }
}