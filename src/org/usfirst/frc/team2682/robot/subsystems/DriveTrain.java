package org.usfirst.frc.team2682.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team2682.robot.commands.DT_JoystickDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Encoder;

import org.usfirst.frc.team2682.robot.ADIS16448_IMU;
/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Talon rightMotors;
	Talon leftMotors;
	Joystick defaultStick;
	RobotDrive chassis;
	Encoder nCodeR;
	Encoder nCodeL;
	
	
	private double pidOutput;
	
	
	ADIS16448_IMU imu;
	
	PIDController orientLoop;
	
	public DriveTrain(Joystick a, int left, int right){
		super();
		defaultStick = a;
		rightMotors = new Talon(right);
		leftMotors = new Talon(left);
		
		nCodeR = new Encoder(0,1);
		nCodeL = new Encoder(2,3);
		
		imu = new ADIS16448_IMU();
		
		chassis = new RobotDrive(leftMotors, rightMotors);
		
		chassis.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		chassis.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		
	}
	
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DT_JoystickDrive(this, defaultStick));
    }
    
    
    public void moveMotors(double left, double right){
    	chassis.tankDrive(left, right);
    }
    
    public RobotDrive getDrive(){
    	return chassis;
    }
    
    
    public ADIS16448_IMU getIMU(){
    	return imu;
    }
    
    public double getRotation(){
    	return imu.getAngleZ();
    }
    
    
    public void setPIDValue(double value){
    	pidOutput = value;
    	SmartDashboard.putNumber("Drive train pid value", pidOutput);
    }
    
    public double getPIDValue(){
    	SmartDashboard.putNumber("PID value gotten",1);
    	return pidOutput;
    }

    public Joystick getJoy(){
    	return defaultStick;
    }
    
    public void resetEncoders(){
    	nCodeR.reset();
    	nCodeL.reset();
    }
    
    public double getDistance(){
    	return (nCodeR.get() + nCodeL.get())/2;
    }

    
    
    
    
}

