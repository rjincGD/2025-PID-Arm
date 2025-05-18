package frc.robot;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.ArmSubsystem;


public class ShuffleBoard extends SubsystemBase {
  public ArmSubsystem m_ArmSubsystem = ArmSubsystem.getInstance();

  public ShuffleBoard() {

  }

  @Override
  public void periodic() {
    SmartDashboard.putData(ArmSubsystem.getInstance());
  }
}
