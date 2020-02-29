/*----------------------------------------------------------------------------*/
/* Copyright (c) 2020 FRC Team 4639. All Rights Reserved.                     */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import static frc.robot.Constants.Buttons;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;

import frc.robot.commands.DriveCmd;
import frc.robot.commands.IntakeBallsCmd;
import frc.robot.commands.KickerCmd;
import frc.robot.commands.PushBallsCmd;
import frc.robot.commands.SpoolShooterCmd;
import frc.robot.commands.TurretCmd;
import frc.robot.subsystems.ClimberSys;
import frc.robot.subsystems.DrivetrainSys;
import frc.robot.subsystems.HopperSys;
import frc.robot.subsystems.IntakeSys;
import frc.robot.subsystems.KickerSys;
import frc.robot.subsystems.ShooterSys;
import frc.robot.subsystems.TurretSys;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
	private final ClimberSys m_climber;
	private final DrivetrainSys m_drive;
	private final IntakeSys m_intake;
	private final HopperSys m_hopper;
	private final ShooterSys m_shooter;
	private final KickerSys m_kicker;
	private final TurretSys m_turret;

	private final OI m_oi;
	private final Compressor m_compressor;

	/**
	 * The container for the robot. Contains subsystems, OI devices, and commands.
	 */
	public RobotContainer() {
		m_compressor = new Compressor();
		m_compressor.setClosedLoopControl(true);

		m_oi = new OI();

		m_climber = new ClimberSys();
		m_climber.setDefaultCommand(
				new RunCommand(() -> m_climber.setClimber(m_oi.getAxis(1, Constants.Axes.RIGHT_STICK_X)), m_climber)
						.andThen(() -> m_climber.setClimber(0), m_climber));

		m_drive = new DrivetrainSys();
		m_drive.setDefaultCommand(new DriveCmd(m_oi, m_drive));

		m_intake = new IntakeSys();
		m_hopper = new HopperSys();
		m_shooter = new ShooterSys();
		m_kicker = new KickerSys();
		m_turret = new TurretSys();
		m_turret.setDefaultCommand(new TurretCmd(m_oi, m_turret));

		configureButtonBindings();
	}

	/**
	 * Use this method to define your button->command mappings. Buttons can be
	 * created by instantiating a {@link GenericHID} or one of its subclasses
	 * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
	 * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
	 */
	private void configureButtonBindings() {
		// Extend the climber pistons
		m_oi.getButton(1, Buttons.Y_BUTTON).whileHeld(new InstantCommand(() -> m_climber.setPistons(true), m_climber));
		m_oi.getButton(1, Buttons.B_BUTTON).whileHeld(new InstantCommand(() -> m_climber.setPistons(false), m_climber));

		// Intake stuff
		m_oi.getButton(1, Buttons.X_BUTTON).whileHeld(new IntakeBallsCmd(m_hopper, m_intake));

		// Move kicker wheel back to clear ball and then spool the shooter
		m_oi.getButton(1, Buttons.A_BUTTON)
				.whileHeld(new KickerCmd(m_kicker).withTimeout(0.2).andThen(new SpoolShooterCmd(m_shooter, m_kicker)));

		// Use the kicker to push the balls in
		m_oi.getButton(0, Buttons.X_BUTTON).whileHeld(new PushBallsCmd(m_hopper, m_intake));
	}

	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	public Command getAutonomousCommand() {
		return new InstantCommand();
	}
}
