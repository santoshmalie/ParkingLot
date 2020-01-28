package com.parkinglot;

import com.parkinglot.enums.CommandExecutorEnum;
import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class CommandExecutorTest {

    @Test
    public void testCommandExecutor () {
        try{
            String output = null;
            String command = "create_parking_lot 6";
            output = CommandExecutorEnum.INSTACE.executeCommand(command);
            assertEquals("Test for create_parking_lot","Created a parking lot with 6 slots", output);

            command = "park KA-01-HH-1234 White";
            output = CommandExecutorEnum.INSTACE.executeCommand(command);
            assertEquals("Test for allocating parking slot","Allocated slot number: 1", output);

            command = "park KA-01-HH-9999 White";
            output = CommandExecutorEnum.INSTACE.executeCommand(command);
            assertEquals("Test for allocating parking slot","Allocated slot number: 2", output);

            command = "park KA-01-BB-0001 Black";
            output = CommandExecutorEnum.INSTACE.executeCommand(command);
            assertEquals("Test for allocating parking slot","Allocated slot number: 3", output);

            command = "park KA-01-HH-7777 Red";
            output = CommandExecutorEnum.INSTACE.executeCommand(command);
            assertEquals("Test for allocating parking slot","Allocated slot number: 4", output);

            command = "park KA-01-HH-2701 Blue";
            output = CommandExecutorEnum.INSTACE.executeCommand(command);
            assertEquals("Test for allocating parking slot","Allocated slot number: 5", output);

            command = "park KA-01-HH-3141 Black";
            output = CommandExecutorEnum.INSTACE.executeCommand(command);
            assertEquals("Test for allocating parking slot","Allocated slot number: 6", output);

            command = "leave 4";
            output = CommandExecutorEnum.INSTACE.executeCommand(command);
            assertEquals("Test for de-allocating parking slot","Slot number 4 is free", output);

            command = "park KA-01-P-333 White";
            output = CommandExecutorEnum.INSTACE.executeCommand(command);
            assertEquals("Test for allocating parking slot","Allocated slot number: 4", output);

            command = "park DL-12-AA-9999 White";
            output = CommandExecutorEnum.INSTACE.executeCommand(command);
            assertEquals("Test for allocating parking slot","Sorry, parking lot is full", output);

            command = "registration_numbers_for_cars_with_colour White";
            output = CommandExecutorEnum.INSTACE.executeCommand(command);
            assertEquals("Test for registration numbers of cars with colour white","KA-01-HH-1234, KA-01-HH-9999, KA-01-P-333", output);

            command = "slot_numbers_for_cars_with_colour White";
            output = CommandExecutorEnum.INSTACE.executeCommand(command);
            assertEquals("Test for slot numbers of cars with colour white","1, 2, 4", output);

            command = "slot_number_for_registration_number KA-01-HH-3141";
            output = CommandExecutorEnum.INSTACE.executeCommand(command);
            assertEquals("Test for slot number of car which matches with registration number ","6", output);

            command = "slot_number_for_registration_number MH-04-AY-1111";
            output = CommandExecutorEnum.INSTACE.executeCommand(command);
            assertEquals("Test for slot number of car which matches with registration number ","Not Found", output);
        } catch (Exception e) {
            TestCase.fail("Test failed for Command execution");
        }
    }





}
