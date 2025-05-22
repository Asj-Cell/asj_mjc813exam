package com.mjc813.studyjava.abstractj;

public class Truck extends Vehicle{

    private String name;
    private int ton;

    public Truck(String name, int ton) {
        this.name = name;
        this.ton = ton;
    }
    @Override
    void stop() {
        System.out.println(name+"이 정지합니다");
    }
    @Override
    void move() {
        System.out.println(name+"을 움직입니다.");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTon() {
        return ton;
    }

    public void setTon(int ton) {
        this.ton = ton;
    }
}
