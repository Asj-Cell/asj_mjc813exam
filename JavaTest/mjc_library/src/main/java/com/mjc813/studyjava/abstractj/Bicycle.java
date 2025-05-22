package com.mjc813.studyjava.abstractj;

public class Bicycle extends Vehicle{

    private String name;

    public Bicycle(String name , int wheelCount) {
        this.name = name;
        setWheelCount(wheelCount);
    }

    @Override
    void move() {
        System.out.println(name+"을 움직입니다.");
    }

    @Override
    void stop() {
        System.out.println(name+"이 정지합니다");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Bicycle{" +
                "name='" + name + '\'' +
                '}';
    }


}
