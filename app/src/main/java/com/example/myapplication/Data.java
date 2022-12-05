package com.example.myapplication;

public class Data {
    private final String name;
    private final String dept;

    public Data(String name, String dept) {
        this.name = name;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }
}
