package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Declan Freeman-Gleason on 12/12/2015.
 */

// IMPORTANT!!! THIS PROGRAM IS NONFUNCTIONAL AND IS ONLY PROVIDED AS A REFERENCE

public class Autonomous_MoveToRamp extends OpMode {
	double startTime;
	final static double CIRC = 18.8495559215; // This number is Pi * 6 Which is the diameter of the Wheels of the Circuit Breaker's Robot
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
	public void init () {
		startTime = 0;
		MotorRight_F = hardwareMap.dcMotor.get("RightMotorF");
		MotorLeft_F = hardwareMap.dcMotor.get("LeftMotorF");
		MotorRight_B = hardwareMap.dcMotor.get("RightMotorB");
		MotorLeft_B = hardwareMap.dcMotor.get("LeftMotorB");
		MotorRight_F.setDirection(DcMotor.Direction.REVERSE);
		MotorRight_B.setDirection(DcMotor.Direction.REVERSE);
		MotorLeft_F.setDirection (DcMotor.Direction.FORWARD);
		MotorLeft_B.setDirection (DcMotor.Direction.FORWARD);
		MotorLeft_F.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
		MotorRight_F.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
		MotorLeft_B.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
		MotorRight_B.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
		servo1 = hardwareMap.servo.get("servo1");
		servo2 = hardwareMap.servo.get("servo2");
		servo3 = hardwareMap.servo.get("servo3");
		servo4 = hardwareMap.servo.get("servo4");
		servo5 = hardwareMap.servo.get("servo5");
	}

	@Override
	public void start() {
		startTime = System.currentTimeMillis();
		telemetry.addData("Debug", System.currentTimeMillis() - startTime);
		while (System.currentTimeMillis() - startTime <= 10002){
			//Do Nothing
		}
		super.start();
	}

	@Override
	public void loop () {
		int TARGETROTATIONS = (int) Math.round ( CIRC * 112 );
		MotorRight_F.setPower (.25);
		MotorLeft_B.setPower (.25);
		MotorRight_B.setPower (.25);
		MotorLeft_F.setPower (.25);
		MotorRight_F.setTargetPosition (TARGETROTATIONS);
		MotorLeft_B.setTargetPosition (TARGETROTATIONS);
		MotorRight_B.setTargetPosition (TARGETROTATIONS);
		MotorLeft_F.setTargetPosition (TARGETROTATIONS);
	}
}
