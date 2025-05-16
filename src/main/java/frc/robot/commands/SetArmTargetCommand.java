package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ArmSubsystem.ArmAngle;

public class SetArmTargetCommand extends Command{
    private final ArmSubsystem m_arm;
    private final ArmAngle m_armAngle;
    public SetArmTargetCommand(ArmSubsystem armSubsystem, ArmAngle angle){
        m_arm = armSubsystem;
        m_armAngle = angle;
    }

    @Override
    public void initialize() {
        m_arm.setArmTarget(m_armAngle);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
