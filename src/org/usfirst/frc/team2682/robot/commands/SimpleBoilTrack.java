package org.usfirst.frc.team2682.robot.commands;

import org.usfirst.frc.team2682.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2682.robot.subsystems.OrientLoop;
import org.usfirst.frc.team2682.robot.subsystems.VisionSystem;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.lang.Math;
/**
 *
 */
public class SimpleBoilTrack extends Command {

	DriveTrain chassis;
	double targetAngle;
	OrientLoop loop;
	VisionSystem visSys;
	
	
    public SimpleBoilTrack(DriveTrain a, OrientLoop b, VisionSystem v) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	
    	
    	chassis = a;
    	loop = b;
    	visSys = v;
    	requires(chassis);
    	
    	
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    
    AutoOrient runner;
    boolean hat = true;
    
    protected void execute() {	
    	
    	SmartDashboard.putNumber("Current Angle", chassis.getRotation());
    	SmartDashboard.putNumber("Target X Value", visSys.getBoilX());
    	SmartDashboard.putNumber("Target Angle", visSys.getBoilAngle());
    	
    	SmartDashboard.putNumber("PID Error", loop.getPIDController().getError());
    	SmartDashboard.putNumber("PID output", chassis.getPIDValue());
    	SmartDashboard.putBoolean("OnTarget?", loop.getPIDController().onTarget());
    	
    	
    	
    	loop.setTargetRelative(visSys.getBoilAngle());
    	
    	
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
    }
}
