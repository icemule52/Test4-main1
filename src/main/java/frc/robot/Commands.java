package frc.robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class Commands extends Command {

    private DriveSubsystem _drive;
    private double startTime;
   

    public Commands(DriveSubsystem drive) {
        _drive = drive;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(drive);
    }
    // Called when the command is initially scheduled.
    @Override
    public void initialize(){
        startTime = Timer.getFPGATimestamp();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute(){
        _drive.drive(0.5, 0.0, 0.0, true);
    }
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        _drive.setX();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return (Timer.getFPGATimestamp()-startTime>=0.9);
    }

}