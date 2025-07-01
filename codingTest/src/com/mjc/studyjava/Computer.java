package com.mjc.studyjava;

import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Stack;


@Getter
@Setter
@Data
public class Computer implements Comparable<Computer>{

    private String name;
    private String cpu;
    private String ram;
    private String storage;
    private Graphic graphic;
    private Mouse mouse = new Mouse();
    private Integer price;
    private Integer qty;


    public Computer(String name, String cpu, String ram, String storage, Graphic graphic, Integer price, Integer qty) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.graphic = graphic;
        this.mouse = mouse;
        this.price = price;
        this.qty = qty;
    }






    public void start() {
        System.out.println(name+"이 켜졌습니다.");
    }
    public void off() {
        System.out.println(name+"이 꺼집니다.");
    }
    public void clickLeftButton(int x,int y) {
        mouse.clickLeftButton(x, y);
    }
    public void clickRightButton(int x,int y) {
        mouse.clickRightButton(x, y);
    }


    public String getCpu() {
        if (cpu == null) {
            return "조립중입니다.";
        }
        return cpu;
    }

    public String getRam() {
        if (ram == null) {
            return "조립중입니다.";
        }
        return ram;
    }

    public String getStorage() {
        if (storage == null) {
            return "조립중입니다.";
        }
        return storage;
    }

    public String getGraphic() {
        if (graphic == null) {
            return Graphic.DEFALUT.getLabel();
        }
        return graphic.getLabel();
    }

    public Mouse getMouse() {
        return mouse;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", graphic=" + graphic +
                ", mouse=" + mouse +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Objects.equals(name, computer.name) && Objects.equals(cpu, computer.cpu) && Objects.equals(ram, computer.ram) && Objects.equals(storage, computer.storage) && graphic == computer.graphic && Objects.equals(mouse, computer.mouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cpu, ram, storage, graphic, mouse);
    }

    @Override
    public int compareTo(Computer o) {
        return this.getCpu().compareTo(o.getCpu());

    }

//    public int getPrice() {
//    }
}
