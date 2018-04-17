package frc.team3103.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team3103.robot.Robot;

/**
 *
 */
public class dumbMoveForwardAuto_command extends CommandGroup {

    public dumbMoveForwardAuto_command() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	requires(Robot.mainDrive);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Timer timer = new Timer();
        timer.reset();
        timer.start();
        double currentTime = timer.get();
        Robot.mainDrive.dumbautoforward();
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
