/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DriveForDistanceCommand;
import frc.robot.commands.ManualDriveCommand;
import frc.robot.subsystems.DriveTrainSubsystem;

public class Robot extends TimedRobot
{
    private Command autonomousCommand;
    private Command teleopCommand;
    private RobotContainer robotContainer;
    private DriveTrainSubsystem driveTrainSubsystem;
    
    Constants constants = new Constants();

    @Override
    public void robotInit()
    {
        robotContainer = new RobotContainer();
        driveTrainSubsystem = new DriveTrainSubsystem(constants.leftSparkChannel, constants.rightSparkChannel);
        autonomousCommand = new DriveForDistanceCommand(driveTrainSubsystem, constants.inchesToDriveForDriveForDistanceCommand1);
        teleopCommand = new ManualDriveCommand(driveTrainSubsystem);
    }

    @Override
    public void robotPeriodic()
    {
        SmartDashboard.putNumber("Left Encoder Distance" , driveTrainSubsystem.leftEncoder.getDistance());
        SmartDashboard.putNumber("Right Encoder Distance" , driveTrainSubsystem.rightEncoder.getDistance());

        CommandScheduler.getInstance().run();
    }
  
    @Override
    public void disabledInit()
    {
    }

    @Override
    public void disabledPeriodic()
    {
    }

    @Override
    public void autonomousInit()
    {
        if (autonomousCommand != null)
        {
            autonomousCommand.schedule();
        }
    }

    @Override
    public void autonomousPeriodic()
    {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void teleopInit()
    {
        if (autonomousCommand != null)
        {
            autonomousCommand.cancel();
        }
    }

    @Override
    public void teleopPeriodic()
    {
        teleopCommand.schedule();
    }

    @Override
    public void testInit()
    {
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void testPeriodic()
    {
    }
}
