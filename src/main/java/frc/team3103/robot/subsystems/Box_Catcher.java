package frc.team3103.robot.subsystems;

import frc.team3103.robot.RobotMap;
import frc.team3103.robot.commands.GrabberStop_command;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Box_Catcher extends Subsystem {
	//WPI_TalonSRX mover = new WPI_TalonSRX(RobotMap.actuatingBoxCatcherMotor);
	WPI_TalonSRX catcher1 = new WPI_TalonSRX(RobotMap.boxCatcherRoller1);
	WPI_TalonSRX catcher2 = new WPI_TalonSRX(RobotMap.boxCatcherRoller2);
	
	Solenoid piston = new Solenoid(21, 1);
	
	public void Box_CatcherInit() {
		//inversion
		//mover.setInverted(false);
		catcher1.setInverted(false);
		catcher2.setInverted(true);
		//follow
		catcher2.follow(catcher1);
	
}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	// actuating stuff forwards and backwards
        // Set the default command for a subsystem here.
        setDefaultCommand(new GrabberStop_command());
    }
    	
    public void open_Catcher() {
    	piston.set(true);
    	
    }
    public void close_Catcher() {
    	piston.set(false);
    	
    }
    
    public void stop() {
    	catcher1.set(0); 
    }
    
    public void intake_Box() {
    	catcher1.set(1);
    	
    }
    public void outake_Box() {
    	catcher1.set(-1);
    }
    
    
    
}

