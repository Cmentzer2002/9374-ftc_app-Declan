package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Declan Freeeman-Gleason on 11/21/2015.
 * A small change
 */

// What does this program do?
    // This program moves the motors at a constant speed for a set amount of time, 3502 milleseconds ( 3.502 seconds ) to be exact.

public class Autonomous_MoveWithTime extends OpMode {
    double startTime; // Variable that holds a value for the time
    Servo servo1;
    Servo servo2;
    Servo servo3;
    Servo servo4;
	Servo servo5;
    DcMotor MotorRight_F;
    DcMotor MotorLeft_F;
    DcMotor MotorRight_B;
    DcMotor MotorLeft_B;
    @Override
    public void init() {
        startTime = 0; // Set the start time to 0, this is just in case. If the program does what it is supposed to do then this won't matter.
        MotorRight_F = hardwareMap.dcMotor.get("RightMotorF");
        MotorLeft_F = hardwareMap.dcMotor.get("LeftMotorF");
        MotorRight_B = hardwareMap.dcMotor.get("RightMotorB");
        MotorLeft_B = hardwareMap.dcMotor.get("LeftMotorB");
        MotorRight_F.setDirection(DcMotor.Direction.REVERSE);
        MotorRight_B.setDirection(DcMotor.Direction.REVERSE);
        MotorLeft_F.setDirection (DcMotor.Direction.FORWARD);
        MotorLeft_B.setDirection (DcMotor.Direction.FORWARD);
        MotorLeft_F.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        MotorRight_F.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        MotorLeft_B.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        MotorRight_B.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
		servo1 = hardwareMap.servo.get("servo1");
		servo2 = hardwareMap.servo.get("servo2");
		servo3 = hardwareMap.servo.get("servo3");
		servo4 = hardwareMap.servo.get("servo4");
		servo5 = hardwareMap.servo.get("servo5");
		servo1.setPosition(1);
		servo2.setPosition(0);
		servo3.setPosition(0);
		servo4.setPosition(1);
		servo5.setPosition(1);
    }

    @Override
    public void start() { // This is run when the program starts
        startTime = System.currentTimeMillis(); // Set the start time to the current time
        telemetry.addData("Debug", System.currentTimeMillis() - startTime); // Send the time between setting the start time and now
        super.start(); // Start the loop
    }

    @Override
    public void loop() {
        if (System.currentTimeMillis() - startTime <= 3502) { // Has it been more than 3.502 seconds since the program started?
            // No, it has been less than 3.502 seconds since the program started.
            telemetry.addData("Debug", System.currentTimeMillis() - startTime); // Send how long it has been since the program started
            MotorLeft_F.setPower(0.25); // Set the power for the motors to 25% power
            MotorRight_F.setPower(0.25); // Set the power for the motors to 25% power
            MotorRight_B.setPower(0.25); // Set the power for the motors to 25% power
            MotorLeft_B.setPower(0.25); // Set the power for the motors to 25% power
        } else { // Has it been more than 3.502 seconds since the program started?
            // It has been more than 3.502 seconds since the program started, the robot should stop moving soon
            telemetry.addData ("Debug", "Done with program. Finished in " + (System.currentTimeMillis () - startTime) + " Milleseconds."); // Say that the program is done, and how long it took.
            MotorLeft_F.setPower(0); // Set the power for the motors to 0% power, the robot should stop now
            MotorRight_F.setPower(0); // Set the power for the motors to 0% power, the robot should stop now
            MotorRight_B.setPower(0); // Set the power for the motors to 0% power, the robot should stop now
            MotorLeft_B.setPower(0); // Set the power for the motors to 0% power, the robot should stop now
        }
    }
}
