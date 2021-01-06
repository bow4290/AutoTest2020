package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSubsystem;

import java.util.Set;

public class ManualDriveCommand extends CommandBase {

    private final DriveTrainSubsystem driveTrainSubsystem;


    public ManualDriveCommand(DriveTrainSubsystem driveTrainSubsystem) {
        this.driveTrainSubsystem = driveTrainSubsystem;
    }

    public void execute() {
        if(RobotContainer.joystickLeft.getTrigger() || RobotContainer.joystickRight.getTrigger())
        {
            driveTrainSubsystem.swapShiftSolenoidPosition();
        }
        driveTrainSubsystem.drive(RobotContainer.joystickLeft.getY(), RobotContainer.joystickRight.getY());
        //MAKE SURE TO USE CORRECT RANGE OF INPUT VALUES.
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
    }
}
