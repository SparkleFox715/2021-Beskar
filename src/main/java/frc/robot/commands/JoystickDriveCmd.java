/*----------------------------------------------------------------------------*/
/* Copyright (c) 2020 FRC Team 4639. All Rights Reserved.                     */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.DrivetrainSys;

public class JoystickDriveCmd extends CommandBase {
	private final DrivetrainSys drivetrainSys;
	private final OI oi;

	public JoystickDriveCmd(DrivetrainSys drivetrainSys, OI oi) {
		this.drivetrainSys = drivetrainSys;
		addRequirements(drivetrainSys);
		this.oi = oi;
	}

	@Override
	public void execute() {
		drivetrainSys.driveArcade(
				-oi.getAxis(0, Constants.Axes.RIGHT_STICK_X),
				oi.getAxis(0, Constants.Axes.LEFT_STICK_Y));
	}

	@Override
	public void end(boolean interrupted) {
		drivetrainSys.stopDrive();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
