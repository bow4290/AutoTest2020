/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.XboxController;

public class RobotContainer
{
    Constants constants = new Constants();

    public static Joystick joystickLeft;
    public static Joystick joystickRight;

    public RobotContainer()
    {
        joystickLeft = new Joystick(constants.leftJoystickPort);
        joystickRight = new Joystick(constants.rightJoystickPort);

        configureButtonBindings();
    }

    private void configureButtonBindings()
    {

    }
}
