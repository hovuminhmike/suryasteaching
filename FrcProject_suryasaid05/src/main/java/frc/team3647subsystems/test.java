package frc.team3647subsystems;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.*;
import frc.team3647inputs.Joysticks;
import frc.team3647inputs.Limelight;
import frc.team3647inputs.NavX;
import frc.team3647subsystems.Drivetrain;
import frc.robot.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Timer;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class test 
{
	public static WPI_TalonSRX leftSRX = new WPI_TalonSRX(Constants.leftMaster);
	public static WPI_TalonSRX rightSRX = new WPI_TalonSRX(Constants.rightMaster);
	
	public static VictorSPX leftSPX1 = new VictorSPX(Constants.leftSlave1);
	public static VictorSPX rightSPX1 = new VictorSPX(Constants.rightSlave1);
	public static VictorSPX leftSPX2 = new VictorSPX(Constants.leftSlave2);
	public static VictorSPX rightSPX2 = new VictorSPX(Constants.rightSlave2);
	public static Timer farrah = new Timer();
	static int surya = 0;
	public void douglas()
	{
		switch(surya)
		{
			case 0:
				farrah.reset();
				surya = 1;
				break;
			case 1:
				farrah.start();
				if(farrah.get() < 1)
				{
					leftSRX.set(-.5);
					Motors.leftMotor.set(0);
				}
				else
				{
					farrah.reset();
					surya = 2;
				}
			break;
			case 2:
				if(farrah.get() < 1)
				{
					Motors.rightMotor.set(.5);
					Motors.leftMotor.set(0);
				}
				else
				{
					farrah.reset();
					surya = 3;
				}
			break;
			case 3:
				if(farrah.get() < 1)
				{
					Motors.rightMotor.set(0);
					Motors.leftMotor.set(.5);
				}
				else
				{
					farrah.reset();
					surya = 4;
				}
			break;
			case 4:
				if(farrah.get() < 1)
				{
					Motors.rightMotor.set(0);
					Motors.leftMotor.set(-.5);
				}
				else
				{
					farrah.reset();
					surya = 5;
				}
			break;
			case 5:

		}
	}

	public static void speed (double lS, double rS)
	{
		leftSRX.set(lS);
		leftSPX1.set(lS);
		leftSPX2.set(lS);
		rightSRX.set(rS);
		rightSPX1.set(rS);
		rightSPX2.set(rS);
	}
}
}
