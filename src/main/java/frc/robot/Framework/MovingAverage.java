/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.Framework;
import java.util.Arrays;
/**
 * Add your docs here. Moving average(Yinneng's impl)
 */
public class MovingAverage {
    double[] list;
    int index = 0;
    boolean hasFilled = false;
    double sum;
    double length;
    /**
     * 
     * @param len The length of the array, basically how many points do we want to average, more points removes more noise but responds
     * more slowly to changes. So a 50hz sys takes 100ms to respond on len 5 but 400ms on len 20
     */
    public MovingAverage(int len){
        sum =0;
        length = len;
        list = new double[len];
    }
    /**
     * Resets has filled and index and also clears up the array
     */
    public void clearInitialize(){
        index=0;
        for(int i =0; i < list.length;i++){
            list[i]=0;
        }
        hasFilled = false;

    }
    /**
     * Adds element to array. If not full just straight add an inc. index. Else move index through the array
     * @param n
     */
    public void add(double n){
        list [index] = n;
        index ++;
        if (index==length){
            if(!hasFilled){
                hasFilled = true;
            }
            index=0;
        }
    }
    /**
     * 
     * @return If we have added elements length of array or > then true(this way no skewed readings if you want to wait for array to
     * fill)
     */
    public boolean isFull(){
        return hasFilled;
    }
    /**
     * if full use list lenght, other wise use the index
     * @return
     */
    public double get(){
        sum = 0;
        if(hasFilled){
        for(int j=0; j<list.length; j++)
            {
                sum += list[j];
            }
        
            return sum/(double)list.length;
        }
        else{
            for(int j = 0; j < index;j++){
                sum += list[j];
            }
            return sum/(double)index;
        }
    }
    /**
     * Clears, but doesn't initialize!!!!!!!(if you wanna reset all use clearInitialize)
     */
    public void clearListNotIndex(){
        for(int z=0; z<list.length; z++){
            list [z] = 0;
        }
    }
}