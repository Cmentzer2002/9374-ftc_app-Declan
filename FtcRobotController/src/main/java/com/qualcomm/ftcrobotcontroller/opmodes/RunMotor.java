package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Declan Freeman-Gleason on 12/6/2015.
 */
public class RunMotor extends OpMode {
    DcMotor TestMotor;
    @Override
    public void init() {
        TestMotor = hardwareMap.dcMotor.get("TestMotor");
    }

    @Override
    public void loop() {
        TestMotor.setPower(gamepad1.right_stick_y);
    }
}
