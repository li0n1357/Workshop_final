package org.ulpgc.is1.model;

import java.util.Date;

public class Repair {
    private static int NEXT_ID = 0;
    private final int id;
    private final Date date;
    private final String description;
    private final int effort;
    private final Payment payment;

    public Repair(Date date, String description, int effort, Payment payment) {
        this.date = new Date(date.getTime());
        this.id = NEXT_ID++;
        this.description = description;
        this.effort = effort;
        this.payment = payment;
    }

    public Date getDate() {
        return this.date;
    }

    public int getID() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public int getEffort() {
        return this.effort;
    }

    //getPayment() == price()
    public Payment getPayment() {
        return this.payment;
    }

    @Override
    public String toString() {
        return "Reparaciones -> " + "id: " + this.id + ", fecha: '" + this.date + '\'' +
                ", pago realizado: '" + payment.amount() + ", descripción: '" + this.description +
                ", effort: " + this.effort;
    }
}