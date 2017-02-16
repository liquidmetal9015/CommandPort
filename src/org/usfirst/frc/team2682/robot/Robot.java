
package org.usfirst.frc.team2682.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2682.robot.subsystems.*;
import org.usfirst.frc.team2682.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team2682.robot.commands.*;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	
	public static Joystick stick;
	public static DriveTrain chassis;
	public static VisionSystem vision;
	public static OrientLoop loop;
	public static OI oi;


	
	@Override
	public void robotInit() {
		
		oi = new OI();
		
		
		
		vision = new VisionSystem();
		stick = new Joystick(RobotMap.DRIVE_STICK);
		chassis = new DriveTrain(stick, RobotMap.LEFT_MOTOR_PWM, RobotMap.RIGHT_MOTOR_PWM);
		loop = new OrientLoop(RobotMap.ORIENT_P,RobotMap.ORIENT_I,RobotMap.ORIENT_D, chassis);
		
		// chooser.addObject("My Auto", new MyAutoCommand());
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	
	DT_AutoOrient b;
	DT_SimpleBoilTrack c;
	@Override
	public void autonomousInit() {
		//b = new AutoOrient(chassis,loop,45,false);
		//b.start();
		
		c = new DT_SimpleBoilTrack(chassis, loop, vision);
		c.start();
		
		SmartDashboard.putBoolean("AutoRan", false);
		
		
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		
		
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		if(stick.getRawButton(1) && chassis.getCurrentCommand() instanceof DT_JoystickDrive){
			DT_TurnToTarget a = new DT_TurnToTarget(chassis,loop,vision);
			a.start();
		}
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
