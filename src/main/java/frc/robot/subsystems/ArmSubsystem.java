// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.ArmControllerCommand;

public class ArmSubsystem extends SubsystemBase {
  private SparkMax armMotor;

      //this is a offset value to move all setpoints up or down
      private double offset = 0;
      private static ArmSubsystem instance;
  
      /**
       * Returns the Scheduler instance.
       *
       * @return the instance
            * @throws Exception If our motors are not configured, fail creating instance
            */
      public static  ArmSubsystem getInstance() {
        if (instance == null) {
          instance = new ArmSubsystem();
        }
        return instance;
      }

    public double getArmAbsoluteEncoderValue(){
      return armMotor.getAbsoluteEncoder().getPosition();
    }
    private PIDController armPID;
    public PIDController getArmPID() {
        return armPID;
    }
  
  public ArmSubsystem() {
    armMotor = new SparkMax(Constants.ArmSubsystemConstants.armMotorID, MotorType.kBrushless);
    armPID = new PIDController(
      Constants.ArmSubsystemConstants.armP, 
      Constants.ArmSubsystemConstants.armI, 
      Constants.ArmSubsystemConstants.armD
  );
  armPID.enableContinuousInput(0, 2* Math.PI);
  setArmTarget(ArmAngle.DOWN);
  setDefaultCommand(new ArmControllerCommand(this));
  }

  public void setArmTarget(ArmAngle var){
    //sets the wrist's target angle using an encoder and a setpoint
    armPID.setSetpoint(var.armEncoderValue);
  }

    //creates positions for the wrist to be at
    public enum ArmAngle{
      DOWN(Constants.ArmSubsystemConstants.armDown), 
      UP(Constants.ArmSubsystemConstants.armUp);
      double armEncoderValue;
      ArmAngle(double val){
          this.armEncoderValue = val;
      }
      public double getEncoderValue(){
          return armEncoderValue;
      }
  }

  public void runArmMotor(double speed){
      //Check to see that if we are  above our max height and going up, we stop. If we are above and going down that is ok
      if(getArmAbsoluteEncoderValue() >= Constants.ArmSubsystemConstants.armMaxAngle && speed > 0){
          speed = 0;
      }
      if(getArmAbsoluteEncoderValue() <= Constants.ArmSubsystemConstants.armMinAngle && speed < 0){
          speed = 0;
      }
     
      armMotor.set(speed+Constants.ArmSubsystemConstants.armF * Math.sin(getArmAbsoluteEncoderValue()));
      double minAngle = Constants.ArmSubsystemConstants.armMinAngle;
      double maxAngle = Constants.ArmSubsystemConstants.armMaxAngle;
  }

  @Override
  public void periodic() {
  }
  public double armMotorSpeed(){
    return armMotor.get();
}

}
