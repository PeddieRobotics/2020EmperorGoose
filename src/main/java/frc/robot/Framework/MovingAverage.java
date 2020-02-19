/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.Framework;
import java.util.Arrays;
/**
 * Add your docs here.
 */
public class MovingAverage {
    double[] list;
    int i = 0;
    boolean hasFilled = false;
    double sum;
    public MovingAverage(int listLen){
        sum =0;
        list = new double[listLen];
    }

    public void clearInitialize(){
        i=0;
        for(int i =0; i < list.length;i++){
            list[i]=0;
        }
    }
    public void add(double n){
        list [i] = n;
        i ++;
        if (i==10){
            if(!hasFilled){
                hasFilled = true;
            }
            i=0;
        }
    }
    public double get(){
        sum = 0;
        if(!hasFilled){
            for(int j =0; j < i; j++){
                sum+=list[j];
            }
            return sum/(double)i;
        }
        else{
        for(int j=0; j<list.length; j++)
            {
                sum += list[i];
            }
        }
        return sum/list.length;
    }
    
}
