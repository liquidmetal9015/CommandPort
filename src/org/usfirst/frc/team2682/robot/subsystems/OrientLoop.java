package org.usfirst.frc.team2682.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



/**
 *
 */
public class OrientLoop extends PIDSubsystem {

	DriveTrain chassis;


	double startPoint;
	double setpoint;
	
	
	boolean absolute;

    // Initialize your subsystem here
    public OrientLoop(double p, double i, double d, DriveTrain a) {
    	super(p,i,d);
    	
    	
    	chassis = a;
    	
    	this.getPIDController().setInputRange(0, 360);
    	this.getPIDController().setContinuous(true);
    	this.getPIDController().setOutputRange(-1, 1);
    	this.setPercentTolerance(5);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	this.enable();
 
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	
    }

    protected double returnPIDInput() {
    	double heading = chassis.getRotation();   	
        return heading;
    }

    protected void usePIDOutput(double output) {
    	chassis.setPIDValue(output);
    	SmartDashboard.putNumber("PID Output", output);
    	SmartDashboard.putNumber("Error", this.getPIDController().getError());
    	SmartDashboard.putNumber("CurrentPosition", this.getPosition());
    	SmartDashboard.putNumber("Chassis Position", chassis.getRotation());
    	
    }
    
    public void setTargetAbsolue(double target){
    	this.getPIDController().setSetpoint(target);
    }
    
    public void setTargetRelative(double target){
    	if(target < 0){
    		target = target + 360;
    	} else if (target > 360){
    		target = target - 360;
    	}
    	
    	this.getPIDController().setSetpoint(chassis.getRotation() + target);
    }
    
    public void setAbsolute(boolean a){
    	absolute = a;
    }
    
    
}
