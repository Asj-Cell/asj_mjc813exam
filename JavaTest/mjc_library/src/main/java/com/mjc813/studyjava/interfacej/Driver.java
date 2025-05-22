package com.mjc813.studyjava.interfacej;

public class Driver {

    private String name;
    private int age;
    private IVehicle ivehicle;

    public Driver(String name, int age, IVehicle ivehicle) {
        this.name = name;
        this.age = age;
        this.ivehicle = ivehicle;
    }

    public void drive() {
        if (ivehicle instanceof Truck truck) {
            System.out.println("운전수"+name+"은 "+truck.drive());
        } else if (ivehicle instanceof Bicycle bicycle) {
            System.out.println("운전수"+name+"은 "+bicycle.drive());
        }
    }
    public void breakk() {
        System.out.println(name + "은" + ivehicle.breakk());
    }
}
