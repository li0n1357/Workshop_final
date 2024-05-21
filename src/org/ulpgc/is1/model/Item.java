package org.ulpgc.is1.model;

public class Item {
    private final int quantity;

    public Item(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public String toString() {
        return "Cantidad: " + this.quantity;
    }
}