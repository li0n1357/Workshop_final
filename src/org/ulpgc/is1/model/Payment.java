package org.ulpgc.is1.model;

import java.util.Date;

public record Payment(Date date, int amount) {
    public Payment(Date date, int amount) {
        this.date = new Date(date.getTime());
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Importe: " + this.amount + ". Fecha: " + this.date;
    }
}