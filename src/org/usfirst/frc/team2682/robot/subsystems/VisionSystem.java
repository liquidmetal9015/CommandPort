package org.usfirst.frc.team2682.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Command;


import org.usfirst.frc.team2682.robot.commands.VS_BoilCamRun;
import org.usfirst.frc.team2682.robot.commands.VS_HookCamRun;

/**
 *
 */
public class VisionSystem extends Subsystem {

    
	NetworkTable visTable;
	
	
	
	
	private double hookY;
	private double hookX;
	
	private double boilX;
	private double boilY;
	
	private double boilHeight = 1;
	
	private final String modeKey = "isBoil";
	private final String hookXKey = "hookX";
	private final String hookYKey = "hookY";
	private final String boilXKey = "boundRectX";
	private final String boilYKey = "boundRectY";
	
	
	private final double cameraHeight = 720;
	private final double cameraWidth = 480;
	
	private final double cameraFOV = 90;
	
	public VisionSystem(){
		super();
		visTable = NetworkTable.getTable("visionTable");
		hookY = 0;
		hookX = 0;
		boilY = 0;
		boilX = 0;
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new VS_BoilCamRun(this));
    }
    
    
    public void setBoil(){
    	visTable.putBoolean(modeKey, true);
    }
    
    public void updateBoil(){
    	boilX = visTable.getNumber(boilXKey, boilX);
    	boilY = visTable.getNumber(boilYKey, boilY);
    	SmartDashboard.putNumber("BoilerXValue", boilX);
    	SmartDashboard.putNumber("BoilerYValue", boilY);
    	SmartDashboard.putNumber("BoilerAngle", getBoilAngle());
    }
    
    public double getBoilX(){
    	return boilX;
    }
    
    public void setHook(){
    	visTable.putBoolean(modeKey, false);
    }
    
   
    public void updateHook(){
    	hookX = visTable.getNumber(hookXKey, hookX);
    	hookY = visTable.getNumber(hookYKey, hookY);
    }
    
    public double getHookX(){
    	return hookX;
    }
    
    public double getHookY(){
    	return hookY;
    }
    
    public double getHookDis(){
    	
    	return 0;
    }
    
    
    
    public double getBoilDisHeight(){
    	
    	return 0;
    }
    
    public double getBoilDisAngle(){
    	
    	return 0;
    }
    
    public double getHookAngle(){
    	
    	return 0;
    }
    
    double rangeTop = 620;
    double rangeBotton = 0;
    
    public double getBoilAngle(){
    	return (((90)*(boilX))/(620))-50;
    	
    }
    
    public double getBoilAngle(double pixel){
    	return ((90)*(pixel))/(620)-50;
    	
    }
    
    
    
    
}

