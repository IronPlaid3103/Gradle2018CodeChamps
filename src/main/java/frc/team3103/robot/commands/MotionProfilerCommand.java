package frc.team3103.robot.commands;

import frc.team3103.robot.Robot;
import frc.team3103.robot.subsystems.MotionProfiling;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MotionProfilerCommand extends CommandGroup {

    public MotionProfilerCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	requires(Robot.mainDrive);
    }
    	
    MotionProfiling motionProfiling;
    	  
    	    // Called just before this Command runs the first time
       	    		
   
    // Called just before this Command runs the first time
    protected void initialize() {
    	motionProfiling = new MotionProfiling(Robot.mainDrive.flDrive, Robot.mainDrive.frDrive);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	motionProfiling.startMotionProfile();
    	motionProfiling.control();
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
