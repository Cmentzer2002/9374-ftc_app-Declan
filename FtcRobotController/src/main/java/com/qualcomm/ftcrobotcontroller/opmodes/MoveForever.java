package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Declan Freeeman-Gleason on 11/21/2015.
 * A small change
 */
public class MoveForever extends OpMode {
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
        MotorRight_F = hardwareMap.dcMotor.get("RightMotorF");
        MotorLeft_F = hardwareMap.dcMotor.get("LeftMotorF");
        MotorRight_B = hardwareMap.dcMotor.get("RightMotorB");
        MotorLeft_B = hardwareMap.dcMotor.get("LeftMotorB");
        MotorRight_F.setDirection(DcMotor.Direction.REVERSE);
        MotorRight_B.setDirection(DcMotor.Direction.REVERSE);
        MotorLeft_F.setDirection (DcMotor.Direction.FORWARD);
        MotorLeft_B.setDirection (DcMotor.Direction.FORWARD);
        MotorLeft_F.setChannelMode (DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        MotorRight_F.setChannelMode (DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
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
    public void loop() {
        MotorLeft_F.setPower(0.25);
        MotorRight_F.setPower(0.25);
        MotorRight_B.setPower(0.25);
        MotorLeft_B.setPower(0.25);
    }
}
