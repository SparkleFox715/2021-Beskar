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
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class TurretSys extends SubsystemBase {
	private final WPI_VictorSPX turret;

	public TurretSys() {
		this.turret = new WPI_VictorSPX(Constants.TURRET_CAN);
		turret.configFactoryDefault();
		turret.setNeutralMode(NeutralMode.Brake);
	}

	public void setTurret(double power) {
		turret.set(power);
	}

	@Override
	public void periodic() {
	}
}
