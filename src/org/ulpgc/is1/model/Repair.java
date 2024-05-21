package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Repair {
    private static int NEXT_ID = 0;
    private final int id;
    private final Date date;
    private final String description;
    private final int effort;
    private final Payment payment;
    private final BreakdownTypes type;
    private final List<SparePart> partsReplaced;
    private final Vehicle vehicle;

    public Repair(Date date, String description, int effort, Payment payment, BreakdownTypes type, List<SparePart> partsReplaced, Vehicle vehicle) {
        this.date = new Date(date.getTime());
        this.id = NEXT_ID++;
        this.description = description;
        this.effort = effort;
        this.payment = payment;
        this.type = type;
        this.partsReplaced = new ArrayList<>();
        this.vehicle = vehicle;
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

    public Payment getPayment() {
        return this.payment;
    }

    public BreakdownTypes getType() {
        return this.type;
    }

    public List<SparePart> getPartsReplaced() {
        return partsReplaced;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String toString() {
        return "Reparaciones -> " +
                "id: " + id +
                ", fecha: '" + date + '\'' +
                ", descripción: '" + description + '\'' +
                ", effort: " + effort +
                ", pago realizado: '" + payment.amount() + '\'' +
                ", tipo de reparación: '" + type + '\'' +
                ", partes reemplazadas: " + partsReplaced +
                ", vehículo reparado: " + vehicle;
    }
}