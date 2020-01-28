#!/bin/sh
arg1=$1
dir=target
jar_name=ParkingLot.jar
cd ..
mvn clean install
if [ -z "$1" ] ; then
  java -jar $dir/$jar_name
else
	java -jar $dir/$jar_name $arg1
fi
