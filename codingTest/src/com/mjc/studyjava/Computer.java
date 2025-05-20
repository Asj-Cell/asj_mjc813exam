package com.mjc.studyjava;

import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Data
public class Computer {

    private String name;
    private String cpu;
    private String ram;
    private String storage;
    private Graphic graphic;
    private Mouse mouse = new Mouse();

    public Computer() {
        this.name = "computer";
        this.cpu = null;
        this.ram = null;
        this.storage = null;
        this.graphic = null;
    }
    public Computer(String name) {
        this.name = name;
        this.cpu = null;
        this.ram = null;
        this.storage = null;
        this.graphic = null;
    }
    public Computer(String name,String cpu) {
        this.name = name;
        this.cpu = cpu;
        this.ram = null;
        this.storage = null;
        this.graphic = null;
    }
    public Computer(String name,String cpu,String ram) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = null;
        this.graphic = null;
    }
    public Computer(String name,String cpu,String ram,String storage) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.graphic = null;
    }
    public Computer(String name, String cpu, String ram, String storage, Graphic graphic) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.graphic = graphic;
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
    public String getName() {
        if (name == null) {
            return "조립중입니다.";
        }
        return name;
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
        return "Computer{ " + getCpu()+", " + getRam()+", " + getStorage()+", " + getGraphic() + "}";
    }


}
