package com.parkinglot;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CommandExecutorTest.class,
        ParkingLotServiceImplTest.class
})
public class ParkingLotTestSuite {
}
