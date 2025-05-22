package com.mjc.studyjava;

public class Carnivore extends Mammalia {

    public Carnivore(String name,int age) {
        super(name,age);

    }

    @Override
    void eat(Object feed) {
        if (feed instanceof Herbivore realFood) {
            System.out.println(getName() + "은" + realFood + "를 먹는다.");
        }

    }
    @Override
    Animal reproduce(String newName) {
        return new Carnivore(newName,getAge());
    }

}
