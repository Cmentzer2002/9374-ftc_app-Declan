package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by Declan Freeman-Gleason on 1/16/2016.
 */

// What does this program do?
	// This program is intended to move on to the ramp or "mountain" it works mostly like the other time based autonomous programs with a delay, it just has a longer delay ( 10.002 seconds to be exact ). After the delay the program runs for 3502 milleseconds ( 3.502 seconds ).

public class Autonomous_WheelOnRamp extends OpMode {
	double startTime; // Variable that holds a value for the time
	DcMotor MotorRight_F;
	DcMotor MotorLeft_F;
	DcMotor MotorRight_B;
	DcMotor MotorLeft_B;
	@Override
	public void init() {
		startTime = 0;
		MotorRight_F = hardwareMap.dcMotor.get ("RightMotorF");
		MotorLeft_F = hardwareMap.dcMotor.get ("LeftMotorF");
		MotorRight_B = hardwareMap.dcMotor.get ("RightMotorB");
		MotorLeft_B = hardwareMap.dcMotor.get ("LeftMotorB");
		// Plow is on the backside
		MotorRight_F.setDirection (DcMotor.Direction.REVERSE);
		MotorRight_B.setDirection (DcMotor.Direction.REVERSE);
		MotorLeft_F.setDirection (DcMotor.Direction.FORWARD);
		MotorLeft_B.setDirection (DcMotor.Direction.FORWARD);
		MotorLeft_F.setChannelMode (DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
		MotorRight_F.setChannelMode (DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
		MotorLeft_B.setChannelMode (DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
		MotorRight_B.setChannelMode (DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
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
	public void loop() {
		if (System.currentTimeMillis() - startTime <= 13502) {
			telemetry.addData("Debug", System.currentTimeMillis() - startTime);
			MotorLeft_F.setPower(0.25);
			MotorRight_F.setPower(0.25);
			MotorRight_B.setPower(0.25);
			MotorLeft_B.setPower(0.25);
		} else {
			telemetry.addData("Debug", "Done with program.");
			MotorLeft_F.setPower(0);
			MotorRight_F.setPower(0);
			MotorRight_B.setPower(0);
			MotorLeft_B.setPower(0);
		}
	}
}
