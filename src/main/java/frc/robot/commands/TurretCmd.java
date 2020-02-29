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
import frc.robot.subsystems.TurretSys;

public class TurretCmd extends CommandBase {
	private final OI oi;
	private final TurretSys turret;

	public TurretCmd(OI oi, TurretSys turret) {
		this.oi = oi;
		this.turret = turret;
		addRequirements(turret);
	}

	@Override
	public void initialize() {
		turret.setTurret(oi.getAxis(1, Constants.Axes.LEFT_STICK_X));
	}

	@Override
	public void end(boolean interrupted) {
		turret.setTurret(0);
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
