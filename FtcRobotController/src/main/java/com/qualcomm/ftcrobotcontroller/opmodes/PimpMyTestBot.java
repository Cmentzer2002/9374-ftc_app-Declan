package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Declan Freeman-Gleason on 2/24/2016.
 */
public class PimpMyTestBot extends OpMode {
	DcMotor mLeft;
	DcMotor mRight;
	DcMotor mTapeIn;
	DcMotor mTapeOut;
	@Override
	public void init () {
		mLeft = hardwareMap.dcMotor.get("mLeft");
		mRight = hardwareMap.dcMotor.get("mRight");
		mTapeIn = hardwareMap.dcMotor.get("mTapeIn");
		mTapeOut = hardwareMap.dcMotor.get("mTapeIn");
	}

	@Override
	public void loop () {
		if(gamepad2.a){
			mTapeIn.setPower(0.25);
		} else if (gamepad2.x){
			mTapeOut.setPower (0.25);
		} else {
			mTapeIn.setPower(0);
			mTapeOut.setPower(0);
		}
		mLeft.setPower(gamepad1.left_stick_y);
		mRight.setPower(gamepad1.right_stick_y);
	}
}