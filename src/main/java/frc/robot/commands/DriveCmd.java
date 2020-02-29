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

public class DriveCmd extends CommandBase {
	private final OI oi;
	private final DrivetrainSys drive;

	public DriveCmd(OI oi, DrivetrainSys drive) {
		this.oi = oi;
		this.drive = drive;
		addRequirements(drive);
	}

	@Override
	public void initialize() {
		drive.driveArcade(oi.getAxis(0, Constants.Axes.LEFT_STICK_Y) * 0.75,
				oi.getAxis(0, Constants.Axes.RIGHT_STICK_X) * 0.75);
	}

	@Override
	public void end(boolean interrupted) {
		drive.stop();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
