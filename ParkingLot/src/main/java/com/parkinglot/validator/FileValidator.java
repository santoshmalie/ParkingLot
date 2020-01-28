package com.parkinglot.validator;

import com.parkinglot.constants.ParkingApplicationConstants;

import java.io.File;

/**
 * This is a Validator and can be used to validate File or any other data member
 */
public class FileValidator {
    public static boolean isValidFileFormat(StringBuilder fileName) {
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return ParkingApplicationConstants.VALID_FILE_FORMAT.equals(fileName.substring(fileName.lastIndexOf(".")+1));
        } else {
            return false;
        }
    }
}
