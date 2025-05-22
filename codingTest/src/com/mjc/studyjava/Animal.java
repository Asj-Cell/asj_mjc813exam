package com.mjc.studyjava;

public class Animal {
    private String name;
    private int age=10;

    public Animal(String name) {
        this(name, 10);
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void eat(Object feed) {
        System.out.println(name + "은" + feed + "를 먹는다.");
    }

    void sleep() {
        System.out.println(name + "이 잔다");
    }

    void move() {
        System.out.println(name + "이 이동한다");
    }
    Animal reproduce(String newName) {
        return new Animal(newName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
