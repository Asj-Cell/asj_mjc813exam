package com.mjc.studyjava;

public enum Graphic {
    GTX_1660("GTX_1660"), RTX_4080("RTX_4080"), Intel_A770("Intel_A770"), DEFALUT("조립중입니다.");

    private final String label;

    private Graphic(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
