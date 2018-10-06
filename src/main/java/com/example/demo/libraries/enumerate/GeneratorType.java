package com.example.demo.libraries.enumerate;

public enum GeneratorType {

    mongodb("mongodb"),
    hibernate("hibernate");

    private String name;

    private GeneratorType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
