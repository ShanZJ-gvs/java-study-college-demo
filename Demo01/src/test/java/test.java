import com.gvssimux.pojo.*;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

public class test {
    @Test
    public void testECar(){
        ElectricCar electricCar = new ElectricCar("蓝色", "eCar", "e232211", "210km");
        electricCar.drive();
        electricCar.setEnergy();
        System.out.println(electricCar.getColour());
    }

    @Test
    public void testOilCar(){
        OilCar oilCar = new OilCar("黑色","卡宴", "A1323","250km");
        System.out.println(oilCar.getHaveOil());
        System.out.println(oilCar);
    }

    @Test
    public void testCat(){
        Cat car = new Cat("1000元", "橘色");
        car.sound();
    }

    @Test
    public void testDog(){
        Dog dog = new Dog("5000元", "阿拉斯加");
        System.out.println(dog);
    }

    @Test
    public void testPet(){
        Pet pet = new Dog("5000元", "阿拉斯加");
        pet.sound();
        System.out.println(pet.getPrice());
        System.out.println(pet);
    }
}
