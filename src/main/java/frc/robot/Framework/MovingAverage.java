/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.Framework;
import java.util.Arrays;
/**
 * Add your docs here.  Yinneng xu
 */
public class MovingAverage {
    double[] list;
    int i = 0;
    boolean hasFilled = false;
    double sum;
    double length;
    public MovingAverage(int len){
        sum =0;
        length = len;
        list = new double[len];
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
        if (i==length){
            if(!hasFilled){
                hasFilled = true;
            }
            i=0;
        }
    }
    public boolean isFull(){
        return hasFilled;
    }
    public double get(){
        sum = 0;
        if(hasFilled){
        for(int j=0; j<list.length; j++)
            {
                sum += list[j];
            }
        }
        return sum/list.length;
    }
    public void clear(){
        for(int z=0; z<list.length; z++){
            list [z] = 0;
        }
    }
}