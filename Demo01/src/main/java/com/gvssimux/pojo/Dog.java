package com.gvssimux.pojo;


public class Dog extends Pet{
    private String breed;

    public Dog(String breed) {
        this.breed = breed;
    }

    public Dog(String price, String breed) {
        super(price);
        this.breed = breed;
    }

    public void sound() {
        System.out.println("汪~~~");
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
