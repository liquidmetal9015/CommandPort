package org.usfirst.frc.team2682.robot.commands;

import org.usfirst.frc.team2682.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2682.robot.subsystems.OrientLoop;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DT_JoyPoint extends DT_AutoOrient {

	public DT_JoyPoint(double angle, boolean rel){
	  super(angle,rel);
	}
	
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	super.execute();
    	loop.setTargetAbsolue(chassis.getJoy().getDirectionDegrees());
    }

  
}
