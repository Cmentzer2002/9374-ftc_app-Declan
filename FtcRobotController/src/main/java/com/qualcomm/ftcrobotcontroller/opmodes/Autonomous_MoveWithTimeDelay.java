package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Declan Freeeman-Gleason on 11/21/2015.
 */
public class Autonomous_MoveWithTimeDelay extends OpMode {
    double startTime;
    Servo servo1;
    Servo servo2;
    Servo servo3;
    Servo servo4;
    DcMotor MotorRight_F;
    DcMotor MotorLeft_F;
    DcMotor MotorRight_B;
    DcMotor MotorLeft_B;
    @Override
    public void init() {
        startTime = 0;
        MotorRight_F = hardwareMap.dcMotor.get("RightMotorF");
        MotorLeft_F = hardwareMap.dcMotor.get("LeftMotorF");
        MotorRight_B = hardwareMap.dcMotor.get("RightMotorB");
        MotorLeft_B = hardwareMap.dcMotor.get("LeftMotorB");
        MotorRight_F.setDirection(DcMotor.Direction.REVERSE);
        MotorRight_B.setDirection(DcMotor.Direction.REVERSE);
        MotorLeft_F.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        MotorRight_F.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        MotorLeft_B.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        MotorRight_B.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        servo1 = hardwareMap.servo.get("servo1");
        servo2 = hardwareMap.servo.get("servo2");
        servo3 = hardwareMap.servo.get("servo3");
        servo4 = hardwareMap.servo.get("servo4");
        servo1.setPosition(0);
        servo2.setPosition(1);
        servo3.setPosition(0);
        servo4.setPosition(1);

    }

    @Override
    public void start() {
        startTime = System.currentTimeMillis();
        telemetry.addData("Debug", System.currentTimeMillis() - startTime);
        while (System.currentTimeMillis() - startTime <= 5002){
            //Do Nothing
        }
        super.start();
    }

    @Override
    public void loop() {
        if (System.currentTimeMillis() - startTime <= 8002) {
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
