package com.mjc.studyjava;

public class Herbivore extends Mammalia {

    public Herbivore(String name,int age) {
        super(name,age);
    }

    @Override
    Animal reproduce(String newName) {
        return new Herbivore(newName,getAge());
    }

    @Override
    public String toString() {
        return getName();
    }
}
