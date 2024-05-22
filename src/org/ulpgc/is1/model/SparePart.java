package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class SparePart {
    private final String name;
    private final int price;

    public SparePart(String name, int price, RepairManager repairManager) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }



    @Override
    public String toString() {
        return "Nombre: " + this.name + ". Precio: " + this.price;
    }
}