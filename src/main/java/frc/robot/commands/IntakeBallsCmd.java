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

import frc.robot.subsystems.HopperSys;
import frc.robot.subsystems.IntakeSys;

public class IntakeBallsCmd extends CommandBase {
	private final HopperSys hopper;
	private final IntakeSys intake;

	public IntakeBallsCmd(HopperSys hopper, IntakeSys intake) {
		this.hopper = hopper;
		this.intake = intake;
		addRequirements(hopper, intake);
	}

	@Override
	public void initialize() {
		hopper.setHopper(-0.2);
		intake.setIntake(0.5);
	}

	@Override
	public void end(boolean interrupted) {
		hopper.setHopper(0);
		intake.setIntake(0);
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
