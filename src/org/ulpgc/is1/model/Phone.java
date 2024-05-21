package org.ulpgc.is1.model;

public record Phone(String number) {

    public String isValid() {
        if (!number.matches("\\d{9}")) {
            throw new IllegalArgumentException("El número de teléfono debe tener 9 digitos.");
        } else {
            return this.number;
        }
    }
}