/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import java.util.ArrayList;
import java.util.HashMap;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SendableRegistry;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Subsystem;

/**
 * A base for subsystems that handles registration in the constructor, and provides a more intuitive
 * method for setting the default command.
 */
public abstract class SmartDashboardSubsystem implements Subsystem, Sendable {
    //HashMap<String,Object> variableMap = new HashMap<String,Object>();
    ArrayList<String> variableStringList = new ArrayList<String>();
    ArrayList<Object> variableObjectList = new ArrayList<Object>();
    ArrayList<String> variableListTypes = new ArrayList<String>();
    final int defaultInt = 0;
    final float defaultFloat = 0;
    final double defaultDouble = 0; 
    final boolean defaultBoolean =false;
    final String defaultString = ""; 
    boolean wasPutSD =false;
    boolean getData = false;
    String subsystemName;
    /**
     * Constructor.
     */
    public SmartDashboardSubsystem(String subsystemName) {
        String name = this.getClass().getSimpleName();
        name = name.substring(name.lastIndexOf('.') + 1);
        SendableRegistry.addLW(this, name, name);
        CommandScheduler.getInstance().registerSubsystem(this);
        SmartDashboard.putBoolean("Get subsystem data " + subsystemName, false);
        this.subsystemName = subsystemName;
    }

  /**
   * Gets the name of this Subsystem.
   *
   * @return Name
   */
  @Override
  public String getName() {
    return SendableRegistry.getName(this);
  }

  /**
   * Sets the name of this Subsystem.
   *
   * @param name name
   */
  @Override
  public void setName(String name) {
    SendableRegistry.setName(this, name);
  }

  /**
   * Gets the subsystem name of this Subsystem.
   *
   * @return Subsystem name
   */
  @Override
  public String getSubsystem() {
    return SendableRegistry.getSubsystem(this);
  }

  /**
   * Sets the subsystem name of this Subsystem.
   *
   * @param subsystem subsystem name
   */
  @Override
  public void setSubsystem(String subsystem) {
    SendableRegistry.setSubsystem(this, subsystem);
  }


  /**
   * Associates a {@link Sendable} with this Subsystem.
   * Also update the child's name.
   *
   * @param name name to give child
   * @param child sendable
   */
  public void addChild(String name, Sendable child) {
    SendableRegistry.addLW(child, getSubsystem(), name);

    }

  @Override
  public void initSendable(SendableBuilder builder) {
    builder.setSmartDashboardType("Subsystem");

    builder.addBooleanProperty(".hasDefault", () -> getDefaultCommand() != null, null);
    builder.addStringProperty(".default",
        () -> getDefaultCommand() != null ? getDefaultCommand().getName() : "none", null);
    builder.addBooleanProperty(".hasCommand", () -> getCurrentCommand() != null, null);
    builder.addStringProperty(".command",
        () -> getCurrentCommand() != null ? getCurrentCommand().getName() : "none", null);
  }
  
  public void addVariable(Object o, String s){
    variableStringList.add(s);
    variableObjectList.add(o);  
    String name = o.getClass().getSimpleName().substring(o.getClass().getSimpleName().lastIndexOf('.') + 1);
    variableListTypes.add(name);    
   
  }
  public void updateVariables(){
    for(int i =0; i < variableListTypes.size();i++){
        switch(variableListTypes.get(i)){
            case "Integer":
              SmartDashboard.putNumber("hey",0);
              double d = SmartDashboard.getNumber("hey",0);
                variableObjectList.set(i,(int)SmartDashboard.getNumber(variableStringList.get(i),defaultInt));
                break;
            case "Float":
                variableObjectList.set(i,(float)SmartDashboard.getNumber(variableStringList.get(i),defaultFloat));
                break;
            case "Double":
            variableObjectList.set(i,(double)SmartDashboard.getNumber(variableStringList.get(i),defaultDouble));
                break;
            case "Boolean":
            variableObjectList.set(i,SmartDashboard.getBoolean(variableStringList.get(i),defaultBoolean));
                break;
            case "String":
            variableObjectList.set(i,SmartDashboard.getString(variableStringList.get(i),defaultString));
                break;
        }
    }

  }
  public Object get(String s){
    for(int i =0; i < variableStringList.size();i++){
      if(s.equals(variableStringList.get(i))){
        return variableObjectList.get(i);
      }
    }
    return null;
  }
  public void periodic(){
      if(SmartDashboard.getBoolean("Get subsystem data " + subsystemName,false)){
          if(!wasPutSD){
              for(int i =0; i < variableStringList.size();i++){
                switch(variableListTypes.get(i)){
                    case "Integer":
                        SmartDashboard.putNumber(variableStringList.get(i),defaultInt);
                        break;
                    case "Float":
                        SmartDashboard.putNumber(variableStringList.get(i),defaultFloat);
                        break;
                    case "Double":
                        SmartDashboard.putNumber(variableStringList.get(i),defaultDouble);
                    case "Boolean":
                        SmartDashboard.putBoolean(variableStringList.get(i),defaultBoolean);
                        break;
                    case "String":
                        SmartDashboard.putString(variableStringList.get(i),defaultString);
                        break;
                }
              
              }
              wasPutSD = true;
          }
        updateVariables();
      }
    }
  
}
