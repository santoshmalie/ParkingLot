package com.parkinglot.model;

import java.util.HashMap;
import java.util.Map;

/**
 *  Creating parking lot with Slots.
 */
public class ParkingLot {
    private String parkingLotId;
    private Map<Integer,Slot> slotMap;

    public ParkingLot(String parkingLotId, Map<Integer, Slot> slotMap) {
        this.parkingLotId = parkingLotId;
        this.slotMap = slotMap;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Map<Integer, Slot> getSlotMap() {
        return slotMap;
    }

    public void setSlotMap(HashMap<Integer, Slot> slotMap) {
        this.slotMap = slotMap;
    }


}
