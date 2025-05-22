package com.mjc.studyjava;

public class Eagle extends Bird{

    public Eagle(String name,int age, String wigs) {
        super(name,age,wigs);
    }

    @Override
    void fly() {
        System.out.println(getName()+getWings() +"높이 난다.");
    }

    @Override
    void eat(Object feed) {
        if (feed instanceof String AnimalName) {
            System.out.println(getName() + "은" + AnimalName + "를 먹는다.");
        }
    }


    @Override
    Animal reproduce(String newName) {
        return new Eagle(newName,getAge(),getWings());
    }

}
