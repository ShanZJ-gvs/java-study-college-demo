package com.gvssimux.pojo;

public abstract class Pet {
    private String price;

    public Pet() {
    }

    public Pet(String price) {
        this.price = price;
    }

    public abstract void sound();

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "price='" + price + '\'' +
                '}';
    }
}
