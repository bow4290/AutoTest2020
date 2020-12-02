/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 * <p>
 * It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{
    //PWM Ports.
    public final int leftVictorSPX1Channel = 1;
    public final int leftVictorSPX2Channel = 2;
    public final int leftVictorSPX3Channel = 3;
    public final int rightVictorSPX1Channel = 4;
    public final int rightVictorSPX2Channel = 5;
    public final int rightVictorSPX3Channel = 6;

    //DIO Ports.
    public final int leftEncoderChannelA = 0;
    public final int leftEncoderChannelB = 1;
    public final int rightEncoderChannelA = 2;
    public final int rightEncoderChannelB = 3;

    public final int leftEncoderAverageSamples = 5;
    public final double leftEncoderMinRate = 1;
    public final double leftEncoderPulseDistance = 1/360 * 2 * Math.PI * 1.5;
    public final int rightEncoderAverageSamples = 5;
    public final double rightEncoderMinRate = 1;
    public final double rightEncoderPulseDistance = 1/360 * 2 * Math.PI * 1.5;

    //Auto Command Inputs.
    public final double inchesToDriveForDriveForDistanceCommand1 = 50;


}