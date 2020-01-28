package com.parkinglot.enums;


import com.parkinglot.constants.ParkingApplicationConstants;
import com.parkinglot.service.ParkingLotService;
import com.parkinglot.service.ParkingLotServiceImpl;
import com.parkinglot.util.ParkingLotUtil;
import com.parkinglot.validator.CommandValidator;

/**
 * This is an Enum to execute commands and it will be treated as Singleton class
 */
public enum CommandExecutorEnum {
    INSTACE;

    /**
     * Delegates the calls to ParkingLotService class after validating the method passed by user
     * @param command
     */
    public String executeCommand (String command) {
        String output = null;
        if(command != null && command.isEmpty()) {
            System.out.println("Input is not valid!!");
        } else {
            String[] commandArr =  command.split(" ");
            int noOfWordsInCmd = commandArr.length;
            InputCommandEnum commandEnum = InputCommandEnum.valueOf(commandArr[0].toUpperCase());
            if(CommandValidator.validateCmdArgs(commandEnum,noOfWordsInCmd)) {
                ParkingLotService parkingLotServiceImpl = ParkingLotServiceImpl.getParkingLotServiceInstance();
                switch (commandEnum) {
                    case CREATE_PARKING_LOT:
                        output = parkingLotServiceImpl.creatingParkingLot(Integer.parseInt(commandArr[1]));
                        break;
                    case PARK:
                        output = parkingLotServiceImpl.manageParkingLotEntry(commandArr[1], commandArr[2]);
                        break;
                    case LEAVE:
                        output = parkingLotServiceImpl.manageParkingLotExit(Integer.parseInt(commandArr[1]));
                        break;
                    case STATUS:
                        parkingLotServiceImpl.getParkingLotStatus();
                        break;
                    case REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR:
                        output = parkingLotServiceImpl.getRegNoOfCarWithPassedColor(commandArr[1]);
                        break;
                    case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
                        output = parkingLotServiceImpl.getSlotNoOfCarWithPassedRegNo(commandArr[1]);
                        break;
                    case SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:
                        output = parkingLotServiceImpl.getSlotNoOfCarWithPassedColor(commandArr[1]);
                        break;
                    case EXIT:
                        System.exit(0);
                        break;
                    default:
                        System.out.println(ParkingApplicationConstants.ERR_CMD_NOT_DEFINED);
                        break;
                }
                if(!ParkingLotUtil.isStringEmptyOrNull(output)) {
                    System.out.println(output);
                }
            }else {
                System.out.println(ParkingApplicationConstants.ERR_PLS_CORRECT_CMD);
            }
        }
        return output;
    }
}