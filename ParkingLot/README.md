------------------------------------------------------------------------------------------------------------------------
                                           Gojek : PARKING LOT 
------------------------------------------------------------------------------------------------------------------------
This is parking lot application to be used from command prompt.

It will support following use-cases
1.  Creating parking with N slots
2.  Allot nearest parking to the Car
3.  Record Cars' Color and License plate
4.  It will allow data retrieval on the basis of available slots occupied with Car and its details, Car with same color

------------------------------------------------------------------------------------------------------------------------
Technical requirements - 
    JDK 1.8.
    Maven 4.0
    Junit 4.12
------------------------------------------------------------------------------------------------------------------------
Maven execution command : 
    To test the application, please add the "functional_spec/spec/test" folder in src(if not present) and execute 
    following command to run test suite
    Run Test Suite  : mvn clean test
    This Jar can be used as an input to the shell script
    Build JAR       : mvn clean install -DskipTests
------------------------------------------------------------------------------------------------------------------------
Project can accept the commands through interactive CLI or File 
./parkinglot.sh [COMMAND_FILE_PATH] : This can be used to run program through shell
./parkinglot.sh : Interactive CLI can be used using this command
 -----------------------------------------------------------------------------------------------------------------------
 
 
