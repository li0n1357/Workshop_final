package org.ulpgc.is1.model;

public class Customer {
    private final String name;
    private final Phone phone;

    public Customer(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }

    public Phone getPhone() {
        return this.phone;
    }

    @Override
    public String toString() {
        return "Cliente: " + this.name + ". Teléfono de contacto: " + this.phone;
    }
}