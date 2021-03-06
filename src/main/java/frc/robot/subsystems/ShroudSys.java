/*----------------------------------------------------------------------------*/
/* Copyright (c) 2020 FRC Team 4639. All Rights Reserved.                     */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import command.SubsystemBase;

public class ShroudSys extends SubsystemBase {
	private final WPI_TalonSRX shroud;

	public ShroudSys() {
		this.shroud = new WPI_TalonSRX(Constants.SHROUD_CAN);
		shroud.configFactoryDefault();
		shroud.setNeutralMode(NeutralMode.Brake);
		shroud.setInverted(InvertType.InvertMotorOutput);
	}

	public void setShroud(double power) {
		shroud.set(power);
	}

	public double getDegrees() {
		return shroud.getSelectedSensorPosition();
	}

	@Override
	public void periodic() {
	}
}
