package com.gvssimux.pojo;


/*编写汽车类的子类汽油车

汽油车特有属性：剩余油量

汽油车实现父类中的抽象类（用在控制台打印文字表述具体实现）*/
public class OilCar extends Car{
    private String haveOil;

    public void setHaveOil(String haveOil) {
        this.haveOil = haveOil;
    }

    public String getHaveOil() {
        return haveOil;
    }


    public OilCar(String colour, String brand, String carNumber, String haveOil) {
        super(colour, brand, carNumber);
        this.haveOil = haveOil;
    }

    public void drive() {
        System.out.println("汽油车驱动");
    }

    public void setEnergy() {
        System.out.println("汽油车补充能量");
    }



}
