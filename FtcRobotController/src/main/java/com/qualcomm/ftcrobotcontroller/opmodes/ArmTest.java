package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.robocol.Telemetry;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Declan Freeman-Gleason on 12/20/2015.
 */
public class ArmTest extends OpMode {
	double ArmPower;
	double ArmServo;
	DcMotor ArmMotor;
	Servo servo6;
	@Override
	public void init() {
		// True: Plow is on the backside of the robot, False: Plow is on the front.
		ArmPower = 0;
		ArmServo = 1;
		ArmMotor = hardwareMap.dcMotor.get("ArmMotor");
		servo6 = hardwareMap.servo.get("servo6");
		servo6.setPosition(ArmServo);
	}
	@Override
	public void loop () {
		if (gamepad2.x) {
			ArmServo += 0.1;
		} else if (gamepad2.b) {
			ArmServo -= 0.1;
		}
		if (gamepad2.dpad_up) {
			ArmPower = 0.2;
		} else if (gamepad2.dpad_down) {
			ArmPower = -0.2;
		} else {
			ArmPower = 0;
		}
		double ArmServoRealPos = servo6.getPosition();
		telemetry.addData ("Arm Servo Position", ArmServoRealPos);
		ArmPower = Range.clip (ArmPower, -1, 1);
		ArmServo = Range.clip(ArmServo, 0, 1);
		ArmMotor.setPower(ArmPower);
		servo6.setPosition(ArmServo);
	}
}
