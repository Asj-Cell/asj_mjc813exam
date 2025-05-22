package com.mjc813.studyjava.abstractj;

public class DriverMain {

    public static void main(String[] args) {
        Bicycle bicycle1 = new Bicycle("bicycle1", 2);
        Truck truck1 = new Truck("truck1", 4);

        bicycle1.move();
        truck1.move();

        bicycle1.stop();
        truck1.stop();

        Driver driver1 = new Driver("driver1", 20, bicycle1);
        Driver driver2 = new Driver("driver2", 30, truck1);

        driver1.drive();
        driver2.drive();

        driver1.breakk();
        driver2.breakk();




    }
}
