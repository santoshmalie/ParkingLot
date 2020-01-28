package com.parkinglot.filter;

import com.parkinglot.constants.ParkingApplicationConstants;
import com.parkinglot.model.Slot;

import java.util.Collection;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Filters passed collection based upon the defined Predicate
 */
public class ParkingLotFilter {

    /**
     * Filters passed map and returns the Cars' license number which matches the passed color
     * @param slotMap
     * @param color
     * @return
     */
    public static String filterCarsWithColor(Map<Integer, Slot> slotMap, String color) {
        String carsWithGivenColor = ParkingApplicationConstants.EMPTY_STRING;
        Predicate<Slot> licenceNoPredicate = parking -> parking != null && parking.getVehicle() !=null &&
                parking.getVehicle().getColor().equalsIgnoreCase(color);
        Collection<Slot> slotList = slotMap.values();
        carsWithGivenColor = slotList.stream()
                .filter(licenceNoPredicate)
                .map(e -> e.getVehicle().getLicenceNo())
                .collect(Collectors.joining(", "));
        return  carsWithGivenColor;
    }

    /**
     * Filters the passed the map and returns the Cars' slot number if cars color matches with parked car
     * @param slotMap
     * @param color
     * @return
     */
    public static String filterSlotWithCarColor(Map<Integer, Slot> slotMap, String color) {
        String slotWithCarColor = ParkingApplicationConstants.EMPTY_STRING;
        Predicate<Slot> licenceNoPredicate =  parking -> parking != null && parking.getVehicle() !=null &&
                parking.getVehicle().getColor().equalsIgnoreCase(color);
        Collection<Slot> slotList = slotMap.values();
        slotWithCarColor = slotList.stream()
                .filter(licenceNoPredicate)
                .map(e -> String.valueOf(e.getSlotId()))
                .collect(Collectors.joining(", "));
        return  slotWithCarColor;
    }

    /**
     * Filters the passed map and returns the parking slot number if car's licence number matches with passed one
     * @param slotMap
     * @param licenceNo
     * @return
     */
    public static String filterSlotWithCarNo(Map<Integer, Slot> slotMap, String licenceNo) {
        String slotWithCarNO = ParkingApplicationConstants.EMPTY_STRING;
        Predicate<Slot> licenceNoPredicate =  parking -> parking != null && parking.getVehicle() !=null &&
                parking.getVehicle().getLicenceNo().equalsIgnoreCase(licenceNo);
        Collection<Slot> slotList = slotMap.values();
        slotWithCarNO = slotList.stream()
                .filter(licenceNoPredicate)
                .map(e -> String.valueOf(e.getSlotId()))
                .collect(Collectors.joining(", "));
        return  slotWithCarNO;
    }

}
