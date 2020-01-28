package com.parkinglot;

import com.parkinglot.constants.ParkingApplicationConstants;
import com.parkinglot.enums.CommandExecutorEnum;
import com.parkinglot.validator.FileValidator;

import java.io.*;

/**
 * This is an entry-point of the Parking lot application. It will delegate command execution to Executor
 */
public class ParkingLotApplication {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = null;
        try {
            String command;
            if (args.length == 0) {
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            } else {
                StringBuilder commandFilePath = new StringBuilder(args[0]);
                if (FileValidator.isValidFileFormat(commandFilePath)) {
                    bufferedReader = new BufferedReader(new FileReader(String.valueOf(commandFilePath)));
                }
            }
            while ((command = bufferedReader.readLine()) != null) {
                if (command != null && !command.isEmpty()) {
                   CommandExecutorEnum.INSTACE.executeCommand(command);
                } else {
                    System.out.println(ParkingApplicationConstants.ERR_CMD_NOT_FOUND);
                }
            }
        } catch (IOException ex) {
            System.out.println(ParkingApplicationConstants.ERR_FILE_PROCESSING_EXCE + ex.getMessage());
        } finally {
            if(bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }
}
