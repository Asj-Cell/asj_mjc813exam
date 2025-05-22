package com.mjc.studyjava;

public class AnimalMain {

    public static void main(String[] args) {
        Animal animal1 = new Animal("Animal1",20);
        Bird bird1 = new Bird("Bird1",10,"작은 날개");
        Parrot parrot1 = new Parrot("Parrot1",2000,"적당한 날개");
        Eagle eagle1 = new Eagle("Eagle1",3,"큰 날개");
        Mammalia mammalia1 = new Mammalia("Mammalia1",10);
        Herbivore herbivore1 = new Herbivore("Herbivore1",10);
        Carnivore carnivore1 = new Carnivore("Carnivore1",200000);

        animal1.move();
        bird1.fly();
        parrot1.fly();
        eagle1.fly();
        mammalia1.eat("풀때기");
        Animal newHerbivore1 = herbivore1.reproduce("newHerbivore1");
        carnivore1.eat(newHerbivore1);

        new Mammalia("젖소", 7);
    }
}
