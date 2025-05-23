package com.mjc.studyjava;

public class Mammalia extends Animal{

    public Mammalia(String name ,int age) {
        super(name,age);
    }

    void feedingMilk() {
        System.out.println(getName() + " 젖을 먹인다.");
    }

    @Override
    void eat(Object feed) {
        if (feed instanceof String foodName ) {
            System.out.println(getName() + "은" + foodName + "를 먹는다.");
        }
    }

    @Override
    Animal reproduce(String newName) {
        return new Mammalia(newName,getAge());
    }


}
