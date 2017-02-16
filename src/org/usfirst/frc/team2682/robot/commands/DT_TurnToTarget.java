package org.usfirst.frc.team2682.robot.commands;

import org.usfirst.frc.team2682.robot.Robot;
import org.usfirst.frc.team2682.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2682.robot.subsystems.OrientLoop;
import org.usfirst.frc.team2682.robot.subsystems.VisionSystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class DT_TurnToTarget extends Command {

	
	Timer time;
	
	DriveTrain chassis;
	double targetAngle;
	OrientLoop loop;
	VisionSystem visSys;
	
	  
    double lastValue = -1;
    boolean set;
    double newValue;
    
    double sum = 0;
    
    int slot = 0;
	
	double[] target = {0,0,0,0,0,0,0,0};
	
    public DT_TurnToTarget(DriveTrain a, OrientLoop b, VisionSystem v) {

    	chassis = a;
    	loop = b;
    	visSys = v;
    
    	requires(chassis);
    	
   
    
    
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	set = false;
    	slot = 0;
    }

    
  
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    	
    	if(set == false){
    		newValue = visSys.getBoilX();
    		if(newValue != lastValue){
    			target[slot] = newValue;
    			slot++;
    		}	
    	} else {
    		
    		chassis.getDrive().arcadeDrive(0,chassis.getPIDValue());
    		SmartDashboard.putNumber("Chasis pid Value", chassis.getPIDValue());
    	}
    	
    	chassis.getDrive().arcadeDrive(0,chassis.getPIDValue());
    	
    	System.out.println(slot);
    	if(slot >= target.length-1){
    		set = true;
    		
    		for(double i : target){
    			sum += i;
    		}
    		
    		sum = sum / target.length;
    		double newTar = chassis.getRotation() + visSys.getBoilAngle(sum);
    		if(newTar > 360){
    			newTar = newTar - 360;
    		} else if (newTar < 0){
    			newTar = newTar + 360;
    		}
    		
    		loop.setSetpoint(newTar);
    		SmartDashboard.putNumber("10Avg", visSys.getBoilAngle(sum));
    		SmartDashboard.putNumber("10AvgTarget", chassis.getRotation() + visSys.getBoilAngle(sum));
    		
    	}
    	
    	
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.stick.getRawButton(3);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
