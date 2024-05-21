package org.ulpgc.is1.model;

public record Plate(String number) {

    public String isValid() {
        if (number == null) {
            throw new IllegalArgumentException("La placa debe tener 6 caracteres alfanuméricos.");
        }
        if (!number.matches("[A-Za-z0-9]{6}")) {
            throw new IllegalArgumentException("La placa debe tener 6 caracteres alfanuméricos.");
        } else {
            return this.number;
        }
    }

    public String toString() {
        return this.number;
    }
}