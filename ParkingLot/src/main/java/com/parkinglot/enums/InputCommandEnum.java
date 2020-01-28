package com.parkinglot.enums;

/**
 * Allowed commands are defined here. int argument represents the count of words in a commands which includes command name
 * and parameters count
 */

public enum InputCommandEnum {
    CREATE_PARKING_LOT("create_parking_lot",2),
    PARK("park",3),
    LEAVE("leave",2),
    STATUS("status",1),
    REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR("registration_numbers_for_cars_with_colour",2),
    SLOT_NUMBERS_FOR_CARS_WITH_COLOUR("slot_numbers_for_cars_with_colour",2),
    SLOT_NUMBER_FOR_REGISTRATION_NUMBER("slot_number_for_registration_number",2),
    EXIT("exit",0);

    private final String commandStr;
    private final int cmdWordCnt;

    InputCommandEnum(String commandStr, int cmdWordCnt) {
        this.commandStr = commandStr;
        this.cmdWordCnt = cmdWordCnt;
    }

    public String getCommandStr() {
        return commandStr;
    }

    public int getCmdWordCnt() {
        return cmdWordCnt;
    }

    @Override
    public String toString() {
        return this.commandStr;
    }
}