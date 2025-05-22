package com.mjc813.studyjava.abstractj;

public abstract class Vehicle {

    private int wheelCount;


    abstract void move();

    void stop() {
        System.out.println("정지합니다.");
    }

    public int getWheelCount() {
        return wheelCount;
    }

    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }

}
