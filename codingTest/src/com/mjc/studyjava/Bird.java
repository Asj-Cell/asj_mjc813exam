package com.mjc.studyjava;

public class Bird extends Animal {

    private  String wings;

    public Bird(String name,int age ,String wings) {
        super(name,age);
        this.wings = wings;

    }
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    void flap() {
        System.out.println(getName()+wings +" 날개짓한다.");
    }
    void fly() {
        System.out.println(getWings()+wings +" 난다.");
    }


    @Override
    Animal reproduce(String newName) {
        return new Bird(newName,getAge(),wings);
    }

    public String getWings() {
        return this.wings;
    }


}
