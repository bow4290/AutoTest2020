package frc.robot.subsystems;



import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.VictorSPXDriveCommand;
public class DriveTrainSubsystem extends SubsystemBase{

    private final VictorSPX leftVictorSPX1;
    private final VictorSPX leftVictorSPX2;
    private final VictorSPX leftVictorSPX3;
    private final VictorSPX rightVictorSPX1;
    private final VictorSPX rightVictorSPX2;
    private final VictorSPX rightVictorSPX3;

    public DriveTrainSubsystem (int leftVictorSPX1Channel, int leftVictorSPX2Channel, int leftVictorSPX3Channel, int rightVictorSPX1Channel, int rightVictorSPX2Channel, int rightVictorSPX3Channel){

        leftVictorSPX1 = new VictorSPX(leftVictorSPX1Channel);
        leftVictorSPX2 = new VictorSPX(leftVictorSPX2Channel);
        leftVictorSPX3 = new VictorSPX(leftVictorSPX3Channel);
        rightVictorSPX1 = new VictorSPX(rightVictorSPX1Channel);
        rightVictorSPX2 = new VictorSPX(rightVictorSPX2Channel);
        rightVictorSPX3 = new VictorSPX(rightVictorSPX3Channel);

        setDefaultCommand(new VictorSPXDriveCommand());

    }

    public void drive(double leftspeed, double rightspeed) {
        if (Math.abs(leftspeed) < 0.05) {
            leftspeed = 0;
        }

        if (Math.abs(rightspeed) < 0.05) {
            rightspeed = 0;
        }

        leftVictorSPX1.setInverted(true);
        leftVictorSPX2.setInverted(true);
        leftVictorSPX3.setInverted(true);
        rightVictorSPX1.setInverted(true);
        rightVictorSPX2.setInverted(true);
        rightVictorSPX3.setInverted(true);

        leftVictorSPX1.set(VictorSPXControlMode.PercentOutput, leftspeed);
        leftVictorSPX2.set(VictorSPXControlMode.PercentOutput, leftspeed);
        leftVictorSPX3.set(VictorSPXControlMode.PercentOutput, leftspeed);
        rightVictorSPX1.set(VictorSPXControlMode.PercentOutput, rightspeed);
        rightVictorSPX2.set(VictorSPXControlMode.PercentOutput, rightspeed);
        rightVictorSPX3.set(VictorSPXControlMode.PercentOutput, rightspeed);
    }

}