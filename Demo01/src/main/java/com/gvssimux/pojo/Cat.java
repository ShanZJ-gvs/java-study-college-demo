package com.gvssimux.pojo;

public class Cat extends Pet{

    private String color;

    public Cat(String color) {
        this.color = color;
    }

    public Cat(String price, String color) {
        super(price);
        this.color = color;
    }

    public void sound() {
        System.out.println("喵~~~");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
