package com.mjc813.mjc_library;

public class Main {
    public static void main(String[] args) {
        MjcPoint mp = new MjcPoint();
        mp.getMarketPoint();
        mp.addPoint(null, 10);
        mp.addPoint(new SampleMarketInfo(), 50);

        mp.subPoint(null, 20);
        mp.subPoint(new SampleMarketInfo(), 20);
    }
}
