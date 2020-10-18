package com.gvssimux.pojo;


/*
* 编写汽车类的子类电动汽车

电动汽车特有属性：剩余里程

电动汽车实现父类中的抽象类（用在控制台打印文字表述具体实现）*/
public class ElectricCar extends Car{

    private String haveMile;

    public void setHaveMile(String haveMile) {
        haveMile = haveMile;
    }

    public String getHaveMile() {
        return haveMile;
    }


    public ElectricCar() {
        super();
    }

    public ElectricCar(String colour, String brand, String carNumber, String haveMile) {
        super(colour, brand, carNumber);
        this.haveMile = haveMile;
    }

    public void drive() {
        System.out.println("电动汽车驱动");
    }

    public void setEnergy() {
        System.out.println("电动汽车补充能量");
    }

}
