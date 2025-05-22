package com.mjc813.studyjava.abstractj;

public class Driver {

    private String name;
    private int age;
    private Vehicle vehicle;


    public Driver(String name, int age, Vehicle vehicle) {
        this.name = name;
        this.age = age;
        this.vehicle = vehicle;
    }

    public void drive() {
        if (vehicle instanceof Truck truck) {
            System.out.println("운전수"+this+"은 "+truck.getTon()+"개의 바퀴의 트럭"+truck.getName()+"을 운전한다.");
        } else if (vehicle instanceof Bicycle bicycle) {
            System.out.println("운전수"+this+"은 "+bicycle.getWheelCount()+"개의 바퀴의 트럭"+bicycle.getName()+"을 운전한다.");
        }

    }

    void breakk(){
        if (vehicle instanceof Truck truck) {
            System.out.println("운전수 "+name+"은 "+truck.getName()+" 을 정지한다.");
        } else if (vehicle instanceof Bicycle bicycle) {
            System.out.println("운전수 "+name+"은 "+bicycle.getName()+" 을 정지한다.");
        }
    }
    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", age=" + age + '}';
    }
}
