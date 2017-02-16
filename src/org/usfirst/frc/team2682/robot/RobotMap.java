package org.usfirst.frc.team2682.robot;



/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	
	
	
//ORIENT LOOP

	public static final double ORIENT_P = 0.02;
	public static final double ORIENT_I = 0;
	public static final double ORIENT_D = -0.001;
	
	
	
//DRIVE TRAIN
	
	public static final int LEFT_MOTOR_PWM = 1;
	public static final int RIGHT_MOTOR_PWM = 0;
	
	
	
	public static final int DRIVE_STICK = 1;
	public static final int AUX_STICK = 2;
	
			
	
	
}
