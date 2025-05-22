package com.mjc.studyjava;

public class Parrot extends Bird {

    public Parrot(String name, int age, String wings) {
        super(name, age, wings);
    }

    @Override
    void fly() {
        System.out.println(getName() + super.getWings() + " 조금만 난다.");
    }

    @Override
    void eat(Object feed) {
        if (feed instanceof String str) {
            System.out.println(getName() + "은" + str + "를 먹는다.");
        }
    }

    @Override
    Animal reproduce(String newName) {
        return new Parrot(newName, getAge(), getWings());
    }


}
