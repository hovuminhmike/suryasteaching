package frc.robot;

public class Autonomous 
{
	String autoSelected = "middleAuto";
	static int surya = 0;
	
	public void runAuto(double lEnc, double rEnc)
	{
		if(autoSelected.equals("middleAuto"))
		{
			middleAuto(lEnc, rEnc);
		}
		else if(autoSelected.equals("rightAuto"))
		{
			rightAuto(lEnc, rEnc);
		}
		else if(autoSelected.equals("leftAuto"))
		{
			leftAuto(lEnc, rEnc);
		}
		else
		{
			Motors.leftMotor.set(0);
			Motors.rightMotor.set(0);
		}
	}
	
	public static void middleAuto(double lEnc, double rEnc)
	{
	String autoSelected = "middleAuto";
	double encoderDiff = (Math.abs(rEnc - lEnc));
	double speedDiff = (encoderDiff*0.3/60);
		switch(surya)
		{
			case 0:
				if(rEnc < 4000)
				{
					if(encoderDiff < 6)
					{
						Motors.rightMotor.set(-.7);
						Motors.leftMotor.set(.7);
					}
					else 
					{
						if(rEnc>lEnc)
						{
							Motors.rightMotor.set(-.7 + speedDiff);
							Motors.leftMotor.set(.7 + speedDiff);
						}
						else
						{
							Motors.rightMotor.set(-.7 - speedDiff);
							Motors.leftMotor.set(.7-speedDiff);
						}
					}
				}
			else
			{
				surya = 1;
			}
			break;
			case 1:
			Motors.rightMotor.set(0);
			Motors.leftMotor.set(0);
			Encoders.resetEncoders();
			break;
		}
	}
	
	public static void rightAuto(double lEnc, double rEnc)
	{
	String autoSelected = "middleAuto";
	double encoderDiff = (Math.abs(rEnc - lEnc));
	double speedDiff = (encoderDiff*0.3/60);
	double surio = 2/1;
	double encosurio = rEnc/lEnc;
	double surd = encosurio/surio;
	double sureft = Math.abs((0.7/encosurio));
	double suright = Math.abs((0.7*encosurio));
		switch(surya)
		{
			case 0:
				if(rEnc < 1000)
				{
					if(encoderDiff < 6)
					{
						Motors.rightMotor.set(-.7);
						Motors.leftMotor.set(.7);
					}
					else 
					{
						if(rEnc>lEnc)
						{
							Motors.rightMotor.set(-.7 + speedDiff);
							Motors.leftMotor.set(.7 + speedDiff);
						}
						else
						{
							Motors.rightMotor.set(-.7 - speedDiff);
							Motors.leftMotor.set(.7 - speedDiff);
						}
					}
				}
			else
			{
				surya = 1;
			}
			break;
			case 1:
				Motors.rightMotor.set(0);
				Motors.leftMotor.set(0);
				Encoders.resetEncoders();
				surya = 2;
				break;
			case 2:
				if(rEnc < 4000)
				{
					if(surd == 1)
					{
						Motors.rightMotor.set(-.7*surio);
						Motors.leftMotor.set(.7);
					}
					else
					{
						if(encosurio < 1)
						{
							Motors.rightMotor.set(-suright);
							Motors.leftMotor.set(sureft);
						}
						else
						{
							// if(surd < 1)
							// {
							// 	Motors.rightMotor.set(-.7*surio);
							// 	Motors.leftMotor.set(.7);
							// }
							// else
							// {
							// 	Motors.rightMotor.set(-.7*surio);
							// 	Motors.leftMotor.set(.7);
							// }
						}
					}
				}
				else
				{
					surya = 3;
				}
				break;
				case 3:
				Motors.rightMotor.set(0);
				Motors.leftMotor.set(0);
				Encoders.resetEncoders();
				break;
		}
	}

	public static void leftAuto(double lEnc, double rEnc)
	{
		String autoSelected = "middleAuto";
		double encoderDiff = (Math.abs(rEnc - lEnc));
		double speedDiff = (encoderDiff*0.3/60);
		double surio = 4/1;
		double encosurio = rEnc/lEnc;
		double surd = encosurio/surio;
		double sureft = Math.abs((0.7/encosurio));
		double suright = Math.abs((0.7*encosurio));
		switch(surya)
		{
			case 0:
				if(rEnc < 1000)
				{
					if(encoderDiff < 6)
					{
						Motors.rightMotor.set(-.7);
						Motors.leftMotor.set(.7);
					}
					else 
					{
						if(rEnc>lEnc)
						{
							Motors.rightMotor.set(-.7 + speedDiff);
							Motors.leftMotor.set(.7 + speedDiff);
						}
						else
						{
							Motors.rightMotor.set(-.7 - speedDiff);
							Motors.leftMotor.set(.7 - speedDiff);
						}
					}
				}
			else
			{
				surya = 1;
			}
			break;
			case 1:
				Motors.rightMotor.set(0);
				Motors.leftMotor.set(0);
				Encoders.resetEncoders();
				surya = 2;
				break;
			case 2:
			if(rEnc < 3000)
			{
				if(surd == 1)
				{
					Motors.rightMotor.set(-.7);
					Motors.leftMotor.set(.7*surio);
				}
				else
				{
					if(encosurio < 1)
					{
						Motors.rightMotor.set(-.7);
						Motors.leftMotor.set(.7*surio);
					}
					else 
					{
						Motors.rightMotor.set(-suright);
						Motors.leftMotor.set(sureft);
					}
				}
			}
			else
			{
 				surya = 3;
			}
			break;
			case 3:
			Motors.rightMotor.set(0);
			Motors.leftMotor.set(0);
			Encoders.resetEncoders();
			break;
		}
	}
}
