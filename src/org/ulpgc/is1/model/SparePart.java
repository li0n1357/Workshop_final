package org.ulpgc.is1.model;

public class SparePart {
    private final String name;
    private final int price;

    public SparePart(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.name + ". Precio: " + this.price;
    }
}