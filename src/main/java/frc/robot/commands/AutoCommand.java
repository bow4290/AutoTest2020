package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSubsystem;

import java.util.Set;

public class AutoCommand extends CommandBase {

    private DriveTrainSubsystem driveTrainSubsystem;
    private final Set<Subsystem> subsystems;

    public AutoCommand(DriveTrainSubsystem driveTrainSubsystem) {
        this.driveTrainSubsystem = driveTrainSubsystem;
        this.subsystems = Set.of(driveTrainSubsystem);
    }

    @Override
    public void initialize() {
        driveTrainSubsystem.leftEncoder.reset();
        driveTrainSubsystem.rightEncoder.reset();
    }

    @Override
    public void execute() {
        while(driveTrainSubsystem.leftEncoder.getDistance() < 50/*inches*/ || driveTrainSubsystem.rightEncoder.getDistance() < 50/*inches*/)
        {
            driveTrainSubsystem.drive(0.5, 0.5);
        }
        driveTrainSubsystem.drive(0, 0);
    }

    @Override
    public boolean isFinished() {
        return true;
    }


    @Override
    public void end(boolean interrupted) {
    }

}
