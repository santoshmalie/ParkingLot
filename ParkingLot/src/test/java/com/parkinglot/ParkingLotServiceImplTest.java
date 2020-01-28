package com.parkinglot;

import com.parkinglot.constants.ParkingApplicationConstants;
import com.parkinglot.service.ParkingLotService;
import com.parkinglot.service.ParkingLotServiceImpl;
import com.parkinglot.util.ParkingLotUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

/**
 * Junit based unit testing class.
 */
public class ParkingLotServiceImplTest {
    ParkingLotService parkingLotServiceImpl = null;
    String output = ParkingApplicationConstants.EMPTY_STRING;;

    @Before
    public void init() {
            if (parkingLotServiceImpl != null) {
                parkingLotServiceImpl.clearParkingLot();
            }
            output = ParkingApplicationConstants.EMPTY_STRING;
            parkingLotServiceImpl = ParkingLotServiceImpl.getParkingLotServiceInstance();
            parkingLotServiceImpl.creatingParkingLot(6);
            parkingLotServiceImpl.manageParkingLotEntry("KA-01-HH-1234", "White");
            parkingLotServiceImpl.manageParkingLotEntry("KA-01-HH-9999", "White");
            parkingLotServiceImpl.manageParkingLotEntry("KA-01-BB-0001", "Black");
            parkingLotServiceImpl.manageParkingLotEntry("KA-01-HH-7777", "Red");
            parkingLotServiceImpl.manageParkingLotEntry("KA-01-HH-2701", "Blue");
            parkingLotServiceImpl.manageParkingLotEntry("KA-01-HH-3141", "Black");
    }

    @After
    public void after() {
        parkingLotServiceImpl.clearParkingLot();
    }

    @Test
    public void testManageParkingLotEntry() {
        try {
            output = ParkingApplicationConstants.EMPTY_STRING;
            output = parkingLotServiceImpl.manageParkingLotEntry("TN-51-LH-7777", "Coal");
            assertEquals("Vehicle Parking not successful",ParkingApplicationConstants.INFO_PARKING_FULL, output);
        } catch (Exception ex) {
            fail("Test failed for Manage Parking Lot Entry");
        }

    }

    @Test
    public void testManageParkingLotExit() {
        try {
            output = ParkingApplicationConstants.EMPTY_STRING;
            output = parkingLotServiceImpl.manageParkingLotExit(4);
            assertEquals("Vehicle left from parking", String.format(ParkingApplicationConstants.INFO_SLOT_IS_FREE, 4), output);
//            output = parkingLotServiceImpl.manageParkingLotExit(8);
//            assertEquals("Vehicle left from parking", String.format(ParkingApplicationConstants.INFO_SLOT_IS_FREE, 1), output);
        } catch (Exception ex) {
            fail("Test failed for Manage ParkingLot Exit");
        }
    }


    @Test
    public void testGetRegNoOfCarWithPassedColor() {
        try {
            output = ParkingApplicationConstants.EMPTY_STRING;
            output = parkingLotServiceImpl.getRegNoOfCarWithPassedColor("White");
            assertEquals("Registration number of the parked car which matches with the passed color", "KA-01-HH-1234, KA-01-HH-9999", output);

            output = parkingLotServiceImpl.getRegNoOfCarWithPassedColor("Silver");
            assertEquals("Registration number of the parked car which matches with the passed color", String.format(ParkingApplicationConstants.INFO_NO_CARS_WITH_COLOR, "Silver"), output);
        } catch (Exception ex) {
            fail("Test failed for Get registration number of car with passed color");
        }
    }

    @Test
    public void testGetSlotNoOfCarWithPassedColor() {
        try {
            output = ParkingApplicationConstants.EMPTY_STRING;
            output = parkingLotServiceImpl.getSlotNoOfCarWithPassedColor("White");
            if(!ParkingLotUtil.isStringEmptyOrNull(output) && output.indexOf('4') == -1) {
                assertEquals("Displays the parking slot number of the Car which matches the passed color", "1, 2", output);
            } else {
                assertEquals("Displays the parking slot number of the Car which matches the passed color", "1, 2, 4", output);
            }

            output = parkingLotServiceImpl.getSlotNoOfCarWithPassedColor("Yellow");
            assertEquals(" Displays the parking slot number of the Car which matches the passed color",
                    String.format(ParkingApplicationConstants.INFO_NO_CARS_WITH_COLOR, "Yellow"), output);
        } catch (Exception ex) {
            fail("Test failed for Get slot number of the car with passed color");
        }
    }

    @Test
    public void testGetSlotNoOfCarWithPassedRegNo() {
        try {
            output = ParkingApplicationConstants.EMPTY_STRING;
            output = parkingLotServiceImpl.getSlotNoOfCarWithPassedRegNo("KA-01-HH-3141");
            assertEquals("Parking slot number if the car which matches with passed license number", "6", output);

            output = parkingLotServiceImpl.getSlotNoOfCarWithPassedRegNo("MP-09-LP-2558");
            assertEquals("Parking slot number if the car which matches with passed license number",
                    ParkingApplicationConstants.INFO_NO_SLOT_WITH_LICENCE_NUMBER, output);
        } catch (Exception ex) {
            fail("Test failed for Get slot number of the car with passed licese number");
        }
    }
}
