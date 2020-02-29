/*----------------------------------------------------------------------------*/
/* Copyright (c) 2020 FRC Team 4639. All Rights Reserved.                     */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class ShooterSys extends SubsystemBase {
	private final WPI_TalonSRX topShooter;
	private final WPI_VictorSPX bottomShooter;

	public ShooterSys() {
		this.topShooter = new WPI_TalonSRX(Constants.TOP_SHOOTER_CAN);
		topShooter.configFactoryDefault();
		topShooter.setNeutralMode(NeutralMode.Coast);

		this.bottomShooter = new WPI_VictorSPX(Constants.BOTTOM_SHOOTER_CAN);
		bottomShooter.configFactoryDefault();
		bottomShooter.setNeutralMode(NeutralMode.Coast);
		bottomShooter.follow(topShooter);
	}

	public void setShooter(double power) {
		topShooter.set(power);
	}

	@Override
	public void periodic() {
	}
}
