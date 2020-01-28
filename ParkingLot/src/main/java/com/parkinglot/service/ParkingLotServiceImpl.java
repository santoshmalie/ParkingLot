package com.parkinglot.service;

import com.parkinglot.constants.ParkingApplicationConstants;
import com.parkinglot.filter.ParkingLotFilter;
import com.parkinglot.model.ParkingLot;
import com.parkinglot.model.Slot;
import com.parkinglot.model.Vehicle;
import com.parkinglot.util.ParkingLotUtil;

import java.util.*;

/**
 * This service class contains methods to handle parking lot operations
 */
public class ParkingLotServiceImpl implements ParkingLotService{
    private static ParkingLotService parkingLotServiceImpl = null;
    private static ParkingLot parkingLot = null;

    private ParkingLotServiceImpl() {
    }

    /**
     * Creates ParkingLot service instance to handle all parking operations
     * @return ParkingLotService
     */
    public static ParkingLotService getParkingLotServiceInstance() {
        if (parkingLotServiceImpl == null) {
            return new ParkingLotServiceImpl();
        } else {
            return parkingLotServiceImpl;
        }
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public  void clearParkingLot () {
        parkingLot = null;
    }

    /**
     * Creates parking lot with provided number of slots
     * @param noOfSlots
     */
    public String creatingParkingLot(int noOfSlots) {
        if (parkingLot == null) {
            Map<Integer, Slot> slotMap = new TreeMap<>();
            for (int i = 1; i <= noOfSlots; i++) {
                slotMap.put(i, new Slot(i, null, false));
            }
            parkingLot = new ParkingLot("P001", slotMap);
            return String.format(ParkingApplicationConstants.INFO_PARKING_LOT_CREATED, noOfSlots);
        } else {
            return ParkingApplicationConstants.ERR_PARKING_LOT_EXIST;
        }
    }

    /**
     * Try to allot parking slot to the newly entered vehicle if it's available
     * @param vehicleNo
     * @param vehicleColor
     */
    public String manageParkingLotEntry(String vehicleNo, String vehicleColor) {
        if (parkingLot != null) {
            Map<Integer, Slot> slotMap = parkingLot.getSlotMap();
            int availableSlot = 0;
            boolean parkingFlag = false;
            for (Map.Entry<Integer, Slot> slotEntry : slotMap.entrySet()) {
                availableSlot++;
                if (slotEntry.getValue().isOccupied() == false) {
                    parkingFlag = true;
                    break;
                }
            }
            if (availableSlot != 0 && parkingFlag) {
                parkingLot.getSlotMap().put(availableSlot, new Slot(availableSlot, new Vehicle(vehicleColor, vehicleNo), true));
                return String.format(ParkingApplicationConstants.INFO_SLOT_ALLOCATED, availableSlot);
            } else {
                return ParkingApplicationConstants.INFO_PARKING_FULL;
            }
        } else {
            return ParkingApplicationConstants.ERR_PARKING_LOT_NOT_EXIST;
        }
    }

    /**
     * This method updates records when Car leaves the parking lot
     * @param slotNo
     */
    public String manageParkingLotExit(int slotNo) {
        if (parkingLot != null && parkingLot.getSlotMap().size() >= slotNo) {
            Map<Integer, Slot> slotMap = parkingLot.getSlotMap();
            slotMap.put(slotNo, new Slot(slotNo, null, false));
            return String.format(ParkingApplicationConstants.INFO_SLOT_IS_FREE, slotNo);
        } else {
            return ParkingApplicationConstants.ERR_PARKING_LOT_NOT_EXIST ;
        }
    }

    /**
     * Prints the parking lots' current status of occupied slots with car details
     */
    public void getParkingLotStatus() {
        if (parkingLot != null) {
            Map<Integer, Slot> slotMap = parkingLot.getSlotMap();
            if (ParkingLotUtil.isValidSlotMap(slotMap)) {
                Slot slot = null;
                Vehicle vehicle = null;
                System.out.println(ParkingApplicationConstants.INFO_STATUS_HEADER);
                for (Map.Entry<Integer, Slot> slotEntry : slotMap.entrySet()) {
                    slot = slotEntry.getValue();
                    if (ParkingLotUtil.isSlotNotEmpty(slot)) {
                        vehicle = slot.getVehicle();
                        System.out.println(slot.getSlotId() + "\t\t\t " + vehicle.getLicenceNo() + "\t\t " + vehicle.getColor());
                    }
                }
            } else {
                System.out.println(ParkingApplicationConstants.ERR_NO_SLOT_ALLOTTED);
            }
        }
    }

    /**
     * Get registration number of the parked car which matches with the passed color
     * @param color
     */
    public String getRegNoOfCarWithPassedColor(String color) {
        if (parkingLot != null && !(ParkingLotUtil.isStringEmptyOrNull(color))) {
            Map<Integer, Slot> slotMap = parkingLot.getSlotMap();
            if (ParkingLotUtil.isValidSlotMap(slotMap)) {
                String carsWithGivenColor = ParkingLotFilter.filterCarsWithColor(slotMap, color);
                if (!ParkingLotUtil.isStringEmptyOrNull(carsWithGivenColor)) {
                    return carsWithGivenColor;
                } else {
                    return String.format(ParkingApplicationConstants.INFO_NO_CARS_WITH_COLOR, color);
                }
            } else {
                return ParkingApplicationConstants.ERR_NO_SLOT_ALLOTTED;
            }
        }
        return ParkingApplicationConstants.EMPTY_STRING;
    }

    /**
     * Displays the parking slot number if the car which matches with passed license number
     * @param licenseNo
     */
    public String getSlotNoOfCarWithPassedRegNo(String licenseNo) {
        if (parkingLot != null && !(ParkingLotUtil.isStringEmptyOrNull(licenseNo))) {
            Map<Integer, Slot> slotMap = parkingLot.getSlotMap();
            if (ParkingLotUtil.isValidSlotMap(slotMap)) {
                String slotWithCarNo = ParkingLotFilter.filterSlotWithCarNo(slotMap, licenseNo);
                if (!ParkingLotUtil.isStringEmptyOrNull(slotWithCarNo)) {
                    return slotWithCarNo;
                } else {
                    return String.format(ParkingApplicationConstants.INFO_NO_SLOT_WITH_LICENCE_NUMBER, licenseNo);
                }
            } else {
                return ParkingApplicationConstants.ERR_NO_SLOT_ALLOTTED;
            }
        }
        return ParkingApplicationConstants.EMPTY_STRING;
    }

    /**
     * Displays the parking slot number of the Car which matches the passed color
     * @param color
     */
    public String getSlotNoOfCarWithPassedColor(String color) {
        if (parkingLot != null && !(ParkingLotUtil.isStringEmptyOrNull(color))) {
            Map<Integer, Slot> slotMap = parkingLot.getSlotMap();
            if (ParkingLotUtil.isValidSlotMap(slotMap)) {
                String slotForGivenColor = ParkingLotFilter.filterSlotWithCarColor(slotMap, color);
                if (!ParkingLotUtil.isStringEmptyOrNull(slotForGivenColor)) {
                    return slotForGivenColor;
                } else {
                    return String.format(ParkingApplicationConstants.INFO_NO_CARS_WITH_COLOR, color);
                }
            } else {
                return ParkingApplicationConstants.ERR_NO_SLOT_ALLOTTED;
            }
        }
        return ParkingApplicationConstants.EMPTY_STRING;
    }
}
