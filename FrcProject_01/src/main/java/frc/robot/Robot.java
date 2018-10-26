package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot 
{
	static boolean press;
	Joysticks stick;
	//This function is run whenever the robot starts. This function is used for any initialization of code
	@Override
	public void robotInit() 
	{
		stick = new Joysticks();
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
		press = false;
	}

	//This is the function that is called during the Tele-operated period
	//This function runs periodically, meaning it acts as an infinite loop
	@Override
	public void teleopPeriodic() 
	{
		stick.updateMainController();
		if(press)
		{
			Motors.leftMotor.set(-.5);
			Motors.rightMotor.set(.5);
		}
		else
		{
			Motors.leftMotor.set(0.5);
			Motors.rightMotor.set(-0.5);
		}
		if(Joysticks.buttonA)
		{
			press=!press;
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
