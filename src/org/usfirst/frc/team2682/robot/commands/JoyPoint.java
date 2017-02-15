package org.usfirst.frc.team2682.robot.commands;

import org.usfirst.frc.team2682.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2682.robot.subsystems.OrientLoop;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoyPoint extends AutoOrient {

	public JoyPoint(DriveTrain a, OrientLoop b, double angle, boolean rel){
	  super(a,b,angle,rel);
	}
	
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	super.execute();
    	loop.setTargetAbsolue(chassis.getJoy().getDirectionDegrees());
    }

  
}
