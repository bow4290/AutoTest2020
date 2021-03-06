/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public final class Constants
{
    // Robot characteristics
    private final double wheelDiameter = 7;

    // PWM Ports.
    public final int leftSparkChannel = 0;
    public final int rightSparkChannel = 1;

    // DIO Ports.
    public final int leftEncoderChannelA = 0;
    public final int leftEncoderChannelB = 1;
    public final int rightEncoderChannelA = 2;
    public final int rightEncoderChannelB = 3;

    // Encoder Stuff
    public final int leftEncoderAverageSamples = 5;
    public final double leftEncoderMinRate = 1;
    public final double leftEncoderPulseDistance = 1.0/8800 * Math.PI * wheelDiameter;
    public final int rightEncoderAverageSamples = 5;
    public final double rightEncoderMinRate = 1;
    public final double rightEncoderPulseDistance = 1.0/8800 * Math.PI * wheelDiameter;

    // Auto Command Inputs
    public final double inchesToDriveForDriveForDistanceCommand1 = 240;

    // USB Ports
    public final int leftJoystickPort = 1;
    public final int rightJoystickPort = 0;

    // PCM Inputs
    public final int gearShiftForwardChannel = 0;
    public final int gearShiftReverseChannel = 1;
    
    // Drive Straight Constants
    public final double autoSpeed = 0.75;
    public final double kP = 0.5;
    public final double setpoint = 0;
    
}
