package com.gvssimux.com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Round {
    private double roundX;
    private double roundY;
    private double roundR;
    public final double PI = 3.14;

    public double getArea(){
        return PI*roundR*roundR;
    }


    /**
     * 返回值为1 包含
     * 返回值为2 相交
     * 返回值为3 相离
     * */
    public int getRelation(Round r){

        double rr = r.getRoundR()+this.getRoundR();//两圆的半径之和

        double xx = r.getRoundX()-this.getRoundX();//两圆的圆心的x轴距离

        double yy = r.getRoundY()-this.getRoundY();//两圆的圆心的y轴距离

        double d2 = xx*xx+yy*yy;//两圆的圆心距离的平方

        double rSum = r.getRoundR()+this.getRoundR();//半径合

        double rLoss = r.getRoundR()-this.getRoundR();//半径差

        if(d2>rr*rr){
            System.out.println(r+"与"+this+"相离");
            return 3;
        }

        if( d2<rSum*rSum && rLoss*rLoss<d2 ){
            System.out.println(r+"与"+this+"相交");
            return 2;
        }

        if( d2 < rLoss*rLoss){
            System.out.println(r+"与"+this+"包含");
            return 1;
        }

        return 0;

    }

}
