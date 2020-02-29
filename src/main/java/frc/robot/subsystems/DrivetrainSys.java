/*----------------------------------------------------------------------------*/
/* Copyright (c) 2020 FRC Team 4639. All Rights Reserved.                     */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

import com.kauailabs.navx.frc.AHRS;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DrivetrainSys extends SubsystemBase {
	private final WPI_VictorSPX frontLeft, frontRight, backLeft, backRight;
	private final AHRS navx;
	private final DifferentialDriveOdometry odometry;
	private final DifferentialDrive drive;

	public DrivetrainSys() {
		this.navx = new AHRS(Port.kMXP);

		this.frontLeft = new WPI_VictorSPX(Constants.FRONT_LEFT_DRIVE_CAN);
		frontLeft.configFactoryDefault();
		frontLeft.setNeutralMode(NeutralMode.Brake);

		this.frontRight = new WPI_VictorSPX(Constants.FRONT_RIGHT_DRIVE_CAN);
		frontRight.configFactoryDefault();
		frontRight.setNeutralMode(NeutralMode.Brake);

		this.backLeft = new WPI_VictorSPX(Constants.BACK_LEFT_DRIVE_CAN);
		backLeft.configFactoryDefault();
		backLeft.setNeutralMode(NeutralMode.Brake);

		this.backRight = new WPI_VictorSPX(Constants.BACK_RIGHT_DRIVE_CAN);
		backRight.configFactoryDefault();
		backRight.setNeutralMode(NeutralMode.Brake);

		this.odometry = new DifferentialDriveOdometry(Rotation2d.fromDegrees(getYaw()));

		this.drive = new DifferentialDrive(new SpeedControllerGroup(frontLeft, backLeft),
				new SpeedControllerGroup(frontRight, backRight));
		drive.setSafetyEnabled(false);
	}

	public Pose2d getCurrentPose() {
		return odometry.getPoseMeters();
	}

	public void driveArcade(double speed, double rotation) {
		drive.arcadeDrive(speed, rotation);
	}

	public void stop() {
		drive.stopMotor();
	}

	public double getYaw() {
		return -navx.getYaw();
	}

	@Override
	public void periodic() {
	}
}
