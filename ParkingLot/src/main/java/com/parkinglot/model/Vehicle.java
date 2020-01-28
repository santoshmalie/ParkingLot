package com.parkinglot.model;

public class Vehicle {
    private String color;
    private String licenceNo;

    public Vehicle(String color, String licenceNo) {
        this.color = color;
        this.licenceNo = licenceNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }
}
