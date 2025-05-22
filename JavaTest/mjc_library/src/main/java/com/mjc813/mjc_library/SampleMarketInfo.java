package com.mjc813.mjc_library;

public class SampleMarketInfo implements IMarketInfo {
    @Override
    public String getMessageOfMarketInfo() {
        return "=== This is example market ===";
    }

    @Override
    public String getMessageOfNotValidData() {
        return "!!! input data is not valid !!!";
    }
}
