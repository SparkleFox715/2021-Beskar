/*----------------------------------------------------------------------------*/
/* Copyright (c) 2020 FRC Team 4639. All Rights Reserved.                     */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands;
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2020 FRC Team 4639. All Rights Reserved.                     */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.KickerSys;

public class KickerCmd extends CommandBase {
	private final KickerSys kicker;

	public KickerCmd(KickerSys kicker) {
		this.kicker = kicker;
		addRequirements(kicker);
	}

	@Override
	public void initialize() {
		kicker.setKicker(-0.3);
	}

	@Override
	public void end(boolean interrupted) {
		kicker.setKicker(0);
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
