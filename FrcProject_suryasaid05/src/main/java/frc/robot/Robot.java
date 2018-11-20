package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;


public class Robot extends IterativeRobot 
{	
	Joysticks stick;
  Encoders enc;
	//This function is run whenever the robot starts. This function is used for any initialization of code
	@Override
	public void robotInit() 
	{
	enc = new Encoders();
	stick = new Joysticks();
	}

	 //This function runs once, right before autonomous period starts. 
	@Override
	public void autonomousInit() 
	{
    Encoders.resetEncoders();
	}

	//This is the function that is called during the autonomous period
	//This function runs periodically, meaning it acts as an infinite loop
	@Override
	public void autonomousPeriodic() 
	{
		double lEnc = enc.getLeftEncoder();
		double rEnc = enc.getRightEncoder();
		Autonomous.rightAuto(lEnc, rEnc);
	}

	@Override
	public void teleopInit() 
	{
		
	}

	//This is the function that is called during the Tele-operated period
	//This function runs periodically, meaning it acts as an infinite loop
	@Override
	public void teleopPeriodic() 
	{
		stick.updateMainController();
		double angle = getDegrees();
		double mag = getMagnitude();
		System.out.println(angle);
		
		if(angle == 0)
		{
			Motors.rightMotor.set(mag);
			Motors.leftMotor.set(mag);
		}
		else if(angle == 90)
		{
			Motors.rightMotor.set(-mag);
			Motors.leftMotor.set(mag);
		}
		else if(angle == 180)
		{
			Motors.rightMotor.set(-mag);
			Motors.leftMotor.set(-mag);
		}
		else if(angle == 270)
		{
			Motors.rightMotor.set(mag);
			Motors.leftMotor.set(-mag);
		}
		else if(angle == 45)
		{
			Motors.rightMotor.set(0);
			Motors.leftMotor.set(mag);
		}
		else if(angle == 135)
		{
			Motors.rightMotor.set(-mag);
			Motors.leftMotor.set(0);
		}
		else if(angle == 225)
		{
			Motors.rightMotor.set(mag);
			Motors.leftMotor.set(0);
		}
		else if(angle == 315)
		{
			Motors.rightMotor.set(0);
			Motors.leftMotor.set(-mag);
		}
		else if(angle > 0 && angle < 45)
		{
			Motors.rightMotor.set(-mag * Math.sin(Math.toRadians(angle)));
			Motors.leftMotor.set(mag * Math.cos(Math.toRadians(angle)));
		}
		else if(angle > 45 && angle < 90)
		{
			Motors.rightMotor.set(-mag * Math.cos(Math.toRadians(angle)));
			Motors.leftMotor.set(mag * Math.sin(Math.toRadians(angle)));
		}
		else if(angle > 90 && angle < 135)
		{
			Motors.rightMotor.set(-mag * Math.cos(Math.toRadians(angle-90)));
			Motors.leftMotor.set(mag * Math.sin(Math.toRadians(angle-90)));
		}
		else if(angle > 135 && angle < 180)
		{
			Motors.rightMotor.set(-mag * Math.sin(Math.toRadians(angle-90)));
			Motors.leftMotor.set(mag * Math.cos(Math.toRadians(angle-90)));
		}
		else if(angle > 180 && angle < 225)
		{
			Motors.rightMotor.set(mag * Math.cos(Math.toRadians(angle-180)));
			Motors.leftMotor.set(-mag * Math.sin(Math.toRadians(angle-180)));
		}
		else if(angle > 225 && angle < 270)
		{
			Motors.rightMotor.set(mag * Math.sin(Math.toRadians(angle-180)));
			Motors.leftMotor.set(-mag * Math.cos(Math.toRadians(angle-180)));
		}
		else if(angle > 270 && angle < 315)
		{
			Motors.rightMotor.set(mag * Math.sin(Math.toRadians(angle-270)));
			Motors.leftMotor.set(-mag * Math.cos(Math.toRadians(angle-270)));
		}
		else if(angle > 315 && angle < 359)
		{
			Motors.rightMotor.set(mag * Math.cos(Math.toRadians(angle-270)));
			Motors.leftMotor.set(-mag * Math.sin(Math.toRadians(angle-270)));
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

	public static double getDegrees()
	{
		if(Joysticks.rightJoySticky > 0  && Joysticks.rightJoyStickx > 0) //1st quadrant
		{
			return ( 270 +Math.toDegrees(Math.atan(Joysticks.rightJoyStickx/Joysticks.rightJoySticky)));
		}
		if(Joysticks.rightJoySticky > 0  && Joysticks.rightJoyStickx < 0)
		{
			return 180- Math.toDegrees(Math.atan(Joysticks.rightJoySticky/Joysticks.rightJoyStickx));
		}
		if(Joysticks.rightJoySticky < 0  && Joysticks.rightJoyStickx < 0)
		{
			return 180- Math.toDegrees(Math.atan(Joysticks.rightJoySticky/Joysticks.rightJoyStickx));
		}
		if(Joysticks.rightJoySticky < 0  && Joysticks.rightJoyStickx > 0)
		{
			return -Math.toDegrees(Math.atan(Joysticks.rightJoySticky/Joysticks.rightJoyStickx));
		}
		if(Joysticks.rightJoySticky == 0  && Joysticks.rightJoyStickx < 0)
		{
			return 180;
		}
		if(Joysticks.rightJoySticky == 0  && Joysticks.rightJoyStickx < 0)
		{
			return 0;
		}
		if(Joysticks.rightJoySticky > 0  && Joysticks.rightJoyStickx == 0)
		{
			return 270;
		}
		if(Joysticks.rightJoySticky < 0  && Joysticks.rightJoyStickx == 0)
		{
			return 90;
		}
		else
		{
			return 0;
		}
	}

		//This function returns the magnitude of the vector of the right Joystick
		public static double getMagnitude()
		{
			return Math.sqrt(Math.pow(Joysticks.rightJoySticky, 2) + Math.pow(Joysticks.rightJoyStickx, 2));
		}
		
		public void testFunctions()
		{
			double magnitude, angle;
			magnitude =  getMagnitude();
			angle = getDegrees();
			
			System.out.println("Magnitude: " + magnitude + "; " + "Angle: " + angle + ";");
		}
}