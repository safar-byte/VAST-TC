package com.example.vasttc;

public class Data {
    private final String name;
    private final String dept;
    private final String comp;

    public Data(String name, String dept,String comp) {
        this.name = name;
        this.dept = dept;
        this.comp = comp;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public String getComp() {
        return comp;
    }
}
