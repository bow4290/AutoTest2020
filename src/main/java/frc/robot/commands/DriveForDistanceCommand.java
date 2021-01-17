package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.Constants;

public class DriveForDistanceCommand extends CommandBase {

    Constants constants = new Constants();

    private final DriveTrainSubsystem driveTrainSubsystem;
    private double inchesToDrive;
    private double straightnessError;
    private double straightnessCorrection;
    private double correctedLeftMotorSpeed;
    private double correctedRightMotorSpeed;

    public DriveForDistanceCommand(DriveTrainSubsystem driveTrainSubsystem, double inchesToDrive) {
        this.driveTrainSubsystem = driveTrainSubsystem;
        this.inchesToDrive = inchesToDrive;
    }

    @Override
    public void initialize() {
        driveTrainSubsystem.leftEncoder.reset();
        driveTrainSubsystem.rightEncoder.reset();
    }

    @Override
    public void execute() {
        straightnessError = driveTrainSubsystem.leftEncoder.getDistance() - driveTrainSubsystem.rightEncoder.getDistance();
        straightnessCorrection = constants.kP*(straightnessError - constants.setpoint);
        correctedLeftMotorSpeed = constants.autoSpeed + straightnessCorrection;
        correctedRightMotorSpeed = constants.autoSpeed - straightnessCorrection;

        if (correctedLeftMotorSpeed > constants.autoSpeed){
            correctedLeftMotorSpeed = constants.autoSpeed;
        }
        if (correctedLeftMotorSpeed < -constants.autoSpeed){
            correctedLeftMotorSpeed = -constants.autoSpeed;
        }
        if (correctedRightMotorSpeed > constants.autoSpeed){
            correctedRightMotorSpeed = constants.autoSpeed;
        }
        if (correctedRightMotorSpeed < -constants.autoSpeed){
            correctedRightMotorSpeed = -constants.autoSpeed;
        }

        driveTrainSubsystem.drive(-correctedLeftMotorSpeed, -correctedRightMotorSpeed);
    }

    @Override
    public boolean isFinished() {
        return (driveTrainSubsystem.leftEncoder.getDistance() > inchesToDrive || driveTrainSubsystem.rightEncoder.getDistance() > inchesToDrive);
    }


    @Override
    public void end(boolean interrupted) {
        driveTrainSubsystem.drive(0, 0);
        System.out.println("Done with auto command.");
    }
}
