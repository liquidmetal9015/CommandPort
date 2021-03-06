package org.usfirst.frc.team2682.robot.commands;

import org.usfirst.frc.team2682.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DT_HybridDrive extends Command {

	Joystick stick;
	DriveTrain chassis;
	
    public DT_HybridDrive(DriveTrain a, Joystick b) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	chassis = a;
    	stick = b;
    	requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	chassis.getDrive().arcadeDrive(stick.getY(), stick.getX() + (chassis.getPIDValue()));
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
