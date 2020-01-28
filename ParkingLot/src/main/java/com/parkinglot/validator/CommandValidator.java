package com.parkinglot.validator;

import com.parkinglot.constants.ParkingApplicationConstants;
import com.parkinglot.enums.InputCommandEnum;

public class CommandValidator {
    public static boolean validateCmdArgs(InputCommandEnum inputCommandEnum, int noOfCmdArg) {
        if(inputCommandEnum.getCmdWordCnt() == noOfCmdArg) {
            return true;
        }else {
            System.out.println(inputCommandEnum.toString() + " " + ParkingApplicationConstants.ERR_CMD_INCORRECT_CMD_ARG);
            return false;
        }
    }
}
