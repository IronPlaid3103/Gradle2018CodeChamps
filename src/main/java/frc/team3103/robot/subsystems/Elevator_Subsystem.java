package frc.team3103.robot.subsystems;

import frc.team3103.robot.RobotMap;
import frc.team3103.robot.commands.ElevatorStop_command;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator_Subsystem extends Subsystem {

    WPI_TalonSRX elevatorMotor1 = new WPI_TalonSRX(RobotMap.elevatorMotor1);
    WPI_TalonSRX elevatorMotor2 = new WPI_TalonSRX(RobotMap.elevatorMotor2);
    //gains
	double kP = 0.04;
	double kD = 0;

    public void initializeElevator() {
    	//Invert motors
    	
        elevatorMotor1.setInverted(false);
        elevatorMotor2.setInverted(false);
        
        //Follow 
        elevatorMotor2.follow(elevatorMotor1);
        
		elevatorMotor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		elevatorMotor1.configOpenloopRamp(0.2, 10);
		elevatorMotor2.configOpenloopRamp(0.2, 10);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	
        setDefaultCommand(new ElevatorStop_command());
    }
    
    /*
     * The method makes the elevator go up 
     */
    public void up(Joystick joystick) {
    	//elevatorMotor1.set(joystick.getRawAxis(3));
    	//elevatorMotor1.set(ControlMode.PercentOutput, joystick.getRawAxis(3));
    	elevatorMotor1.set(0.9);
    }
    
    public void down(Joystick joystick) {
    	//elevatorMotor1.set(joystick.getRawAxis(2)*-1);
      	//elevatorMotor1.set(ControlMode.PercentOutput, joystick.getRawAxis(3)*-1);
    	elevatorMotor1.set(-0.9);
    }
    
    public void stop() {
    	elevatorMotor1.set(0);
    }
    
    double rpm = FeedbackDevice.CTRE_MagEncoder_Relative.value;
    
    public void upSwitch() {
    	Timer timer = new Timer();
    	timer.reset();
    	timer.start();
    	double currentTime = timer.get();
    	double currentDistance = rpm * currentTime / 60;
    	if (currentDistance < 9) {
    		elevatorMotor1.set(0.75);
    	}
    	else if (currentDistance >= 9) {
    		elevatorMotor1.set(0);
    	}
    }
    
    public void upScale() {
    	Timer timer = new Timer();
    	timer.reset();
    	timer.start();
    	double currentTime = timer.get();
    	double currentDistance = rpm * currentTime / 60;
    	if (currentDistance < 72) {
    		elevatorMotor1.set(1);
    	}
    	else if (currentDistance >= 72) {
    		elevatorMotor1.set(0);
    	}
    }

    public void elevatorTarget(double target){
    	elevatorMotor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 1);
    	double currentAngle = elevatorMotor1.getActiveTrajectoryPosition();
    	//Find me error

	}
    
}

