package com.parkinglot.constants;

/**
 * Contains the ERROR/INFO constants used across application
 */
public interface ParkingApplicationConstants {
    String VALID_FILE_FORMAT = "txt";
    // Error constants
    String ERR_PLS_CORRECT_CMD = "Please correct the command";
    String ERR_CMD_INCORRECT_CMD_ARG = "Command arguments are incorrect";
    String ERR_PARKING_LOT_NOT_EXIST = "Parking lot does not exist";
    String ERR_PARKING_LOT_EXIST = "Parking lot already created";
    String ERR_NO_SLOT_ALLOTTED = "No slots allotted";
    String ERR_CMD_NOT_DEFINED = "Entered Command Not Defined";
    String ERR_CMD_NOT_FOUND = "Command not found";
    String ERR_FILE_PROCESSING_EXCE = "Exception during file processing";
    String ERR_CMD_NOT_EXECUTED = "Command didn't execute";

    // Info Constants
    String INFO_PARKING_FULL = "Sorry, parking lot is full";
    String INFO_SLOT_IS_FREE = "Slot number %d is free";
    String INFO_PARKING_LOT_CREATED = "Created a parking lot with %d slots";
    String INFO_SLOT_ALLOCATED = "Allocated slot number: %d";
    String INFO_STATUS_HEADER = "Slot No.\t Registration No\t Colour";
    String INFO_NO_CARS_WITH_COLOR = "No Cars parked with %s color";
    String INFO_NO_SLOT_WITH_LICENCE_NUMBER = "Not Found";
    String INFO_ALLOTTED_PARKING_SLOT = "Parking slot %d allotted";

    String EMPTY_STRING = "";

}
