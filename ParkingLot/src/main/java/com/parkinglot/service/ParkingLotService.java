package com.parkinglot.service;

import com.parkinglot.model.ParkingLot;

/**
 * Interface contains essential methods for parkinglot management
 */
public interface ParkingLotService {
    String creatingParkingLot(int noOfSlots);

    String manageParkingLotEntry(String vehicleNo, String vehicleColor);

    String manageParkingLotExit(int slotNo);

    void getParkingLotStatus();

    String getRegNoOfCarWithPassedColor(String color);

    String getSlotNoOfCarWithPassedRegNo(String licenseNo);

    String getSlotNoOfCarWithPassedColor(String color);

    ParkingLot getParkingLot(); // Added for testing

    void clearParkingLot (); // Added for testing
}
