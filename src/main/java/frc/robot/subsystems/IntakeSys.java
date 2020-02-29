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

public class IntakeSys extends SubsystemBase {
	private final WPI_VictorSPX intakeWheel, intakePivot;

	public IntakeSys() {
		this.intakeWheel = new WPI_VictorSPX(Constants.INTAKE_WHEEL_CAN);
		intakeWheel.configFactoryDefault();
		intakeWheel.setNeutralMode(NeutralMode.Brake);

		this.intakePivot = new WPI_VictorSPX(Constants.INTAKE_PIVOT_CAN);
		intakePivot.configFactoryDefault();
		intakePivot.setNeutralMode(NeutralMode.Brake);
	}

	public void setIntake(double num) {
		intakeWheel.set(num);
	}

	@Override
	public void periodic() {
	}
}
