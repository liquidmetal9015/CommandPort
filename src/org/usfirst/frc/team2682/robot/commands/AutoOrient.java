package org.usfirst.frc.team2682.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2682.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2682.robot.subsystems.OrientLoop;
import org.usfirst.frc.team2682.robot.*;

/**
 *
 */
public class AutoOrient extends Command {

	DriveTrain chassis;
	double targetAngle;
	OrientLoop loop;
	boolean relative;
	
    public AutoOrient(DriveTrain a, OrientLoop b, double angle, boolean rel) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	chassis = a;
    	//loop = b;
    	requires(chassis);
    	//requires(loop);
    	targetAngle = angle;
    	
    	relative = rel;
    	
    	SmartDashboard.putNumber("HasStarted", 234);
    	
    }

    // Called just before this Command runs the first time
    
    //TargetLoop target;
    
    protected void initialize() {
    	//target = new TargetLoop(chassis, loop, targetAngle, relative);
    	//target.start();
    	
    	loop.getPIDController().setSetpoint(targetAngle);
    	
    	//System.out.println(targetAngle);
    	//System.out.println(relative);
    	//SmartDashboard.putNumber("TargetAngle", targetAngle);
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
    	chassis.getDrive().arcadeDrive(0, chassis.getPIDValue());
    	
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
    	SmartDashboard.putNumber("Was interrupted", 345);
    }
}
