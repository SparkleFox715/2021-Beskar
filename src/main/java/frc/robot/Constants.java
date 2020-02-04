/*----------------------------------------------------------------------------*/
/* Copyright (c) 2020 FRC Team 4639. All Rights Reserved.                     */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
	public static final double MAX_COMMAND_VOLTAGE = 10;
	public static final double TRACK_WIDTH = 0.55982;
	public static final SimpleMotorFeedforward DRIVETRAIN_FEED_FORWARD = new SimpleMotorFeedforward(0.75, 0.11 * 39.37,
			0.0148 * 39.37);

	public static final double WHEEL_DIAMETER = 0.10795;

	public static final int FRONT_LEFT_DRIVE_CAN = 3;
	public static final int BACK_LEFT_DRIVE_CAN = 4;

	public static final int FRONT_RIGHT_DRIVE_CAN = 1;
	public static final int BACK_RIGHT_DRIVE_CAN = 2;

	public static final int RIGHT_DRIVE_CAN = 2;

	public static final double DEADZONE_VALUE = 0.01;
	public static final int NUMBER_OF_CONTROLLERS = 2;

	public enum Axes {
		LEFT_STICK_X(0), LEFT_STICK_Y(1), LEFT_TRIGGER(2), RIGHT_TRIGGER(3), RIGHT_STICK_X(4), RIGHT_STICK_Y(5);

		private final int value;

		Axes(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	public enum Buttons {
		A_BUTTON(0), B_BUTTON(1), X_BUTTON(2), Y_BUTTON(3), LEFT_BUMPER(4), RIGHT_BUMPER(5), BACK_BUTTON(
				6), START_BUTTON(7), LEFT_STICK(8), RIGHT_STICK(9);

		private final int value;

		private Buttons(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

	}
}
