package com.gvssimux.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* 编写汽车类（Car），

包括属性：颜色，品牌，车牌号

构造函数：实现属性初始化

抽象方法：驱动，能量补充

成员方法：播放音乐，开空调（用在控制台打印文字表述具体实现）*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Car {
    private String colour;
    private String brand;
    private String carNumber;


    public abstract void drive();

    public abstract void setEnergy();

    public void startMusic() {
        System.out.println("car播放音乐");
    }
    public void openAirConditioner() {
        System.out.println("car播放音乐");
    }



}
