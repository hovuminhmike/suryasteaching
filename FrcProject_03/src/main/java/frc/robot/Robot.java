package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot 
{	
	double leftJoySticky;
	Encoders encode;
	Joysticks stick;
	//This function is run whenever the robot starts. This function is used for any initialization of code
	@Override
	public void robotInit() 
	{
		stick = new Joysticks();
		encode = new Encoders();
	}

	 //This function runs once, right before autonomous period starts. 
	@Override
	public void autonomousInit() 
	{

	}

	//This is the function that is called during the autonomous period
	//This function runs periodically, meaning it acts as an infinite loop
	@Override
	public void autonomousPeriodic() 
	{
		
	}

	@Override
	public void teleopInit() 
	{
		encode.resetEncoders();
	}

	//This is the function that is called during the Tele-operated period
	//This function runs periodically, meaning it acts as an infinite loop
	@Override
	public void teleopPeriodic() 
	{
		stick.updateMainController();
		Motors.leftMotor.set(Joysticks.leftJoySticky);
		Motors.rightMotor.set(-Joysticks.leftJoySticky);

		
		double leftEncoderValue = encode.getLeftEncoder();
		double rightEncoderValue = encode.getRightEncoder();
		double encoderDifference, speedDifference;
		encoderDifference = (Math.abs(rightEncoderValue - leftEncoderValue));


		if(Joysticks.leftJoySticky > 0)
		{
			if(encoderDifference < 6)
			{
				Motors.rightMotor.set(-.7);
				Motors.leftMotor.set(.7);
			}
			else 
			{
				speedDifference = encoderDifference*0.3/60;
				if(rightEncoderValue>leftEncoderValue)
				{
					Motors.rightMotor.set(-.7 + speedDifference);
					Motors.leftMotor.set(.7 + speedDifference);
				}
				else
				{
					Motors.rightMotor.set(-.7 - speedDifference );
					Motors.leftMotor.set(.7-speedDifference);
				}
			}
		}
		else if(Joysticks.leftJoySticky < 0 )
		{
			if(encoderDifference < 6)
			{
				Motors.rightMotor.set(.7);
				Motors.leftMotor.set(-.7);
			}
			else 
			{
				speedDifference = encoderDifference*0.3/60;
				if(rightEncoderValue>leftEncoderValue)
				{
					Motors.rightMotor.set(.7 - speedDifference);
					Motors.leftMotor.set(-.7 - speedDifference);
				}
				else
				{
					Motors.rightMotor.set(.7 + speedDifference );
					Motors.leftMotor.set(-.7+speedDifference);
				}
			}
		}
		else
		{
			Motors.rightMotor.set(0);
			Motors.leftMotor.set(0);
		}
	}

	//This is the function that is called during the test
	//Test is an option available in the driver station and can be used to test specific pieces of code.
	//This function runs periodically, meaning it acts like an infinite loop
	@Override
	public void testPeriodic() 
	{
		
	}
}