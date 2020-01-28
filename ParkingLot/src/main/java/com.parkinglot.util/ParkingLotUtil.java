package com.parkinglot.util;

import com.parkinglot.model.Slot;
import com.parkinglot.model.Vehicle;
import java.util.Map;

/**
 * This is an utility class contains utility method which can be used at multiple places
 */
public class ParkingLotUtil {

    /**
     * Checks if the Slot object is null/empty and returns boolean value
     * @param slot
     * @return
     */
    public static boolean isSlotNotEmpty (Slot slot) {
        if(slot != null && slot.getSlotId() != 0 && slot.isOccupied() && isVehicleNotEmpty(slot.getVehicle())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the Vehicle object is null/empty and returns boolean value
     * @param vehicle
     * @return
     */
    public static boolean isVehicleNotEmpty(Vehicle vehicle) {
        if(vehicle != null &&  ((!isStringEmptyOrNull(vehicle.getColor())
                && (!isStringEmptyOrNull(vehicle.getLicenceNo()))))){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if passed string is null/empty
     * @param str
     * @return
     */
    public static boolean isStringEmptyOrNull(String str) {
        return (str == null || str.length() == 0) ? true : false;
    }

    /**
     * Checks if Slot objects' map is not null and has at least one element
     * @param slotMap
     * @return
     */
    public static boolean isValidSlotMap(Map<Integer, Slot> slotMap) {
        return  (slotMap != null && slotMap.size() >= 1) ? true : false;
    }
}
