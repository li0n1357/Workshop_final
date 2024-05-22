package org.ulpgc.is1.model;

public class Phone {
    private String number;

    public Phone(String number) {
        this.number = number;
    }

    public boolean isValid() {
        return number.matches("\\d{9}");
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
