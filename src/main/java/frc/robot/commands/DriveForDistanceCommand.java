package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSubsystem;

import java.util.Set;

public class DriveForDistanceCommand extends CommandBase {

    private final DriveTrainSubsystem driveTrainSubsystem;
    //private final Set<Subsystem> subsystems;
    private double inchesToDrive;

    public DriveForDistanceCommand(DriveTrainSubsystem driveTrainSubsystem, double inchesToDrive) {
        this.driveTrainSubsystem = driveTrainSubsystem;
        //this.subsystems = Set.of(driveTrainSubsystem);
        this.inchesToDrive = inchesToDrive;
    }

    @Override
    public void initialize() {
        driveTrainSubsystem.leftEncoder.reset();
        driveTrainSubsystem.rightEncoder.reset();
    }

    @Override
    public void execute() {
        while(driveTrainSubsystem.leftEncoder.getDistance() < inchesToDrive || driveTrainSubsystem.rightEncoder.getDistance() < inchesToDrive) {
            driveTrainSubsystem.drive(-0.4, -0.4);
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }


    @Override
    public void end(boolean interrupted) {
        driveTrainSubsystem.drive(0, 0);
        System.out.println("Done with auto command.");
    }
}