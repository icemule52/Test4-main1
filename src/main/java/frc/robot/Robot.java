// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.elevator;
import dev.doglog.DogLog;
import dev.doglog.DogLogOptions;
import frc.robot.subsystems.DriveSubsystem;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
private static final String kDefaultAuto = "Default";
private static final String kCustomAuto = "My Auto";
private String m_autoSelected;
private final SendableChooser<String> m_chooser = new SendableChooser<>();
private elevator elevator;
private XboxController m_Controller;
}


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  public Robot() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    elevator = new elevator();
    m_Controller = new XboxController(0);
    SmartDashboard.putData("Auto choices", m_chooser);
    DogLog.setOptions(new DogLogOptions().withCaptureDs(true));
    DogLog.setPdh(new PowerDistribution());
  
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {}


  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    SmartDashboard.putNumber("Position", elevator.getHeight());
    if(m_Controller.getXButtonPressed() == true) {                // L1 
      elevator.setPosition(-0.01); //Max Height
    }
    else if (m_Controller.getXButtonReleased() == true) {
      elevator.setPosition(-0.01);
    }
    else{
    elevator.setPosition(0);
    }

    if(m_Controller.getYButtonPressed() == true) {                // L2
    elevator.setPosition(-0.01); //Max Height
    }
    else if (m_Controller.getYButtonReleased() == true) {
    elevator.setPosition(-0.01);
    }
    else{
  elevator.setPosition(0);
  }

  if(m_Controller.getBButtonPressed() == true) {                // L3
    elevator.setPosition(-0.01); //Max Height
    }
    else if (m_Controller.getBButtonReleased() == true) {
    elevator.setPosition(-0.01);
    }
    else{
  elevator.setPosition(0);
  }

  if(m_Controller.getAButtonPressed() == true) {                // Algea Pickup
    elevator.setPosition(-0.01); //Max Height
    }
    else if (m_Controller.getAButtonReleased() == true) {
    elevator.setPosition(-0.01);
    }
    else{
  elevator.setPosition(0);
  }
}
  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}