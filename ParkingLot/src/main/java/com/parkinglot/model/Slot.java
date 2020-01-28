package com.parkinglot.model;

import com.parkinglot.constants.ParkingApplicationConstants;

/**
 * Slot represents single slot in Parking lot
 */
public class Slot {
    private int slotId;
    private Vehicle vehicle;
    private boolean isOccupied;

    public Slot(int slotId, Vehicle vehicle, boolean isOccupied) {
        this.slotId = slotId;
        this.vehicle = vehicle;
        this.isOccupied = isOccupied;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotId=" + slotId +
                ", vehicle=" + vehicle +
                ", isOccupied=" + isOccupied +
                '}';
    }
}
