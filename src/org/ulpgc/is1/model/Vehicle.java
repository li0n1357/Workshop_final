package org.ulpgc.is1.model;

public class Vehicle {
    private final String make;
    private final String model;
    private final Plate plate;

    public Vehicle(String make, String model, Plate plate) {
        this.make = make;
        this.model = model;
        this.plate = plate;
    }

    @Override
    public String toString() {
        return "Vehiculo -> " + "marca: '" + make + ", modelo: '" + model + ", matrícula: " + plate;
    }
}