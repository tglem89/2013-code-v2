
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.TestVision;
import edu.wpi.first.wpilibj.templates.commands.ShootOn;
import edu.wpi.first.wpilibj.templates.commands.ShootOff;
import edu.wpi.first.wpilibj.templates.commands.GyroReset;
import edu.wpi.first.wpilibj.templates.commands.Turn;
import edu.wpi.first.wpilibj.templates.commands.JoystickDrive;
import edu.wpi.first.wpilibj.templates.commands.BackwardsJoystickDrive;
import edu.wpi.first.wpilibj.templates.commands.PIDYawTest;
import edu.wpi.first.wpilibj.templates.commands.Fire;
import edu.wpi.first.wpilibj.templates.commands.CloseLoopAngleDrive;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    
    Joystick driveyStick = new Joystick(3);
    Joystick leftStick = new Joystick(1);
    Joystick rightStick = new Joystick(2);
    
    Button aim = new JoystickButton(driveyStick, 2);
    
    public static int fastShootButtNum = 7;
    public static int medShootButtNum = 8;
    public static int slowShootButtNum = 9;
    public static int shootOffButtNum = 10;
    public static int gyroResetButtNum = 4;
    public static int turnButtNum = 3;
    public static int backwardsJoystickDriveButtNum = 8;
    public static int joystickDriveButtNum = 9;
    public static int fireButtNum = 1;
    public static int closeLoopDriveButtNum = 11;
    
    
    
    private final JoystickButton fastShootButt = new JoystickButton(driveyStick, fastShootButtNum); 
    private final JoystickButton medShootButt = new JoystickButton(driveyStick, medShootButtNum); 
    private final JoystickButton slowShootButt = new JoystickButton(driveyStick, slowShootButtNum); 
    private final JoystickButton shootOffButt = new JoystickButton(driveyStick, shootOffButtNum);
    private final JoystickButton gyroResetButt = new JoystickButton(driveyStick, gyroResetButtNum);
    private final JoystickButton turnButt = new JoystickButton(driveyStick, turnButtNum);
    private final JoystickButton backwardsJoystickDriveButt = new JoystickButton(rightStick, backwardsJoystickDriveButtNum);
    private final JoystickButton joystickDriveButt = new JoystickButton(rightStick, joystickDriveButtNum);
    private final JoystickButton fireButt = new JoystickButton(driveyStick, fireButtNum);
    private final JoystickButton closeLoopDriveButt = new JoystickButton(driveyStick, closeLoopDriveButtNum);
    
    
    //ShootOn fastShootOn = new ShootOn(1);
    //ShootOn medShootOn = new ShootOn(.75);
    //ShootOn slowShootOn = new ShootOn(.5);
    //ShootOff shootOff = new ShootOff();
    GyroReset gyroReset = new GyroReset();
    PIDYawTest turn = new PIDYawTest(90);
    JoystickDrive joystickDrive = new JoystickDrive();
    BackwardsJoystickDrive backwardsJoystickDrive = new BackwardsJoystickDrive();
    Fire fire = new Fire();
    CloseLoopAngleDrive closeLoopDrive = new CloseLoopAngleDrive(0);
	TestVision testVision = new TestVision();    

    public OI(){
        //fastShootButt.whenPressed(fastShootOn);
        //medShootButt.whenPressed(medShootOn);
        //slowShootButt.whenPressed(slowShootOn);
        //shootOffButt.whenPressed(shootOff);
        gyroResetButt.whenPressed(gyroReset);
        turnButt.whenPressed(turn);
        //backwardsJoystickDriveButt.whenPressed(backwardsJoystickDrive);
        joystickDriveButt.whenPressed(joystickDrive);
        fireButt.whenPressed(fire);
        closeLoopDriveButt.whenPressed(closeLoopDrive);
        
    }
    
    aim.whenPressed( testVision );
}
    //FIX THESE 
    //we dont want to twist and go forward!!!!!
    //they are all negative because PIMP is wired so that all of the motors run 
    //backward when they are supposed to run forwards
    //this is a PIMP thing
    //might need to change for 2013 robot
    public double getForwardSpeed(){
        return -driveyStick.getRawAxis(2);
    }
    
    public double getSideSpeed(){
        return -driveyStick.getRawAxis(1);
    }
    
    public double getTwistSpeed(){
        return -driveyStick.getRawAxis(3); 
    }

    public double getDriveyStickThrottle(){
        return driveyStick.getRawAxis(4);
    }
    
    public double getLeftStickThrottle()
    {
        return leftStick.getRawAxis(3);
    }
}

