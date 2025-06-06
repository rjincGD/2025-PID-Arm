// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static class ArmSubsystemConstants {
    public static final int armMotorID = 1;

    public static final int armP = 0;
    public static final int armI = 0;
    public static final int armD = 0;
    public static final int armF = 0;


    public static final double armDown = 0;
    public static final double armUp = 0.5;

    public static final double armMaxAngle = 0.5;
    public static final double armMinAngle = 0;
  }
}
