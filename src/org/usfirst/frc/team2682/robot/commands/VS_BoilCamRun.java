package org.usfirst.frc.team2682.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2682.robot.subsystems.VisionSystem;
/**
 *
 */
public class VS_BoilCamRun extends Command {

	VisionSystem visSystem;
	
    public VS_BoilCamRun(VisionSystem a) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	visSystem = a;
    	requires(visSystem);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	visSystem.setBoil();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	visSystem.updateBoil();
    	
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
