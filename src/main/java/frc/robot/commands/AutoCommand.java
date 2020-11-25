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


    public void execute() {

    }

    @Override
    public boolean isFinished() {
        return true;
    }

    public void end(boolean interrupted) {
    }

}
