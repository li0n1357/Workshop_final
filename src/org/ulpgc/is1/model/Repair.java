package org.ulpgc.is1.model;

import java.util.Date;
import java.util.List;

public class Repair {
    private static int NEXT_ID = 0;
    private int id;
    private Date date;
    private String description;
    private int effort;
    private Payment payment;
    private BreakdownTypes type;
    private List<SparePart> partsReplaced;
    private Vehicle vehicle;

    public Repair(Date date, String description, int effort, Payment payment, BreakdownTypes type, List<SparePart> partsReplaced, Vehicle vehicle) {
        this.id = NEXT_ID++;
        this.date = date;
        this.description = description;
        this.effort = effort;
        this.payment = payment;
        this.type = type;
        this.partsReplaced = partsReplaced;
        this.vehicle = vehicle;
    }

    public List<SparePart> getPartsReplaced() {
        return partsReplaced;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String toString() {
        StringBuilder partsList = new StringBuilder();
        for (SparePart part : partsReplaced) {
            partsList.append(part.getName()).append(", ");
        }
        if (partsList.length() > 0) {
            partsList.setLength(partsList.length() - 2); // Eliminar la última coma y espacio
        }

        return "Reparación -> " +
                "id: " + id +
                ", fecha: '" + date + '\'' +
                ", descripción: '" + description + '\'' +
                ", esfuerzo: " + effort +
                ", pago realizado: '" + payment + '\'' +
                ", tipo de reparación: '" + type + '\'' +
                ", partes reemplazadas: " + partsList +
                ", vehículo reparado: " + vehicle.getModel();
    }
}
