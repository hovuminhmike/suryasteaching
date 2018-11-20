package frc.robot;

import edu.wpi.first.wpilibj.Encoder;

public class Encoders 
{		
	public static Encoder leftEncoder = new Encoder(0,1, false, Encoder.EncodingType.k4X);
	public static Encoder rightEncoder = new Encoder(4,5, false, Encoder.EncodingType.k4X);

	public double getRightEncoder()
	{
		return rightEncoder.get();
	}
  
	public double getLeftEncoder()
	{
		return -leftEncoder.get();
	}

	public static void resetEncoders()
	{
		rightEncoder.reset();
		leftEncoder.reset();
	}
}