package frc.team3103.robot.commands;

import frc.team3103.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class deliverBox_command extends Command {

    public deliverBox_command() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gripper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gripper.open_Catcher();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gripper.outake_Box();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gripper.close_Catcher();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
