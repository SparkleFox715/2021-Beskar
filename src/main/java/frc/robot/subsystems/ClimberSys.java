/*----------------------------------------------------------------------------*/
/* Copyright (c) 2020 FRC Team 4639. All Rights Reserved.                     */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class ClimberSys extends SubsystemBase {
	private final WPI_TalonSRX leftClimber, rightClimber;
	private final Solenoid leftPiston, rightPiston;

	public ClimberSys() {
		this.leftPiston = new Solenoid(Constants.LEFT_PISTON_ID);
		this.rightPiston = new Solenoid(Constants.RIGHT_PISTON_ID);

		this.leftClimber = new WPI_TalonSRX(Constants.LEFT_CIMBER_CAN);
		leftClimber.configFactoryDefault();
		leftClimber.setNeutralMode(NeutralMode.Brake);

		this.rightClimber = new WPI_TalonSRX(Constants.RIGHT_CLIMBER_CAN);
		rightClimber.configFactoryDefault();
		rightClimber.setNeutralMode(NeutralMode.Brake);
		rightClimber.setInverted(InvertType.OpposeMaster);
		rightClimber.follow(leftClimber);
	}

	public void setPistons(boolean extend) {
		leftPiston.set(extend);
		rightPiston.set(extend);
	}

	public void setClimber(double num) {
		leftClimber.set(num);
	}

	@Override
	public void periodic() {
	}
}
