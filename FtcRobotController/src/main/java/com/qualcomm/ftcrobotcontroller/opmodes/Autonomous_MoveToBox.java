package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Declan Freeman-Gleason on 11/18/2015.
 */
public class Autonomous_MoveToBox extends OpMode {
    DcMotor MotorRight_F;
    DcMotor MotorLeft_F;
    DcMotor MotorRight_B;
    DcMotor MotorLeft_B;
    final int PPM = 1120;

    @Override
    public void init() {
        MotorRight_F = hardwareMap.dcMotor.get("RightMotorF");
        MotorLeft_F = hardwareMap.dcMotor.get("LeftMotorF");
        MotorRight_B = hardwareMap.dcMotor.get("RightMotorB");
        MotorLeft_B = hardwareMap.dcMotor.get("LeftMotorB");
        MotorLeft_F.setDirection(DcMotor.Direction.REVERSE);
        MotorLeft_B.setDirection(DcMotor.Direction.REVERSE);
        MotorLeft_F.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        MotorRight_F.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        MotorLeft_B.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        MotorRight_B.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        MotorLeft_F.setTargetPosition(-6655);
        MotorLeft_B.setTargetPosition(6655);
        MotorRight_F.setTargetPosition(-6655);
        MotorRight_B.setTargetPosition(6655);
    }

    @Override
    public void loop() {
    telemetry.addData("PositionRF", MotorRight_F.getCurrentPosition());
        telemetry.addData("PositionLF", MotorLeft_F.getCurrentPosition());
        telemetry.addData("PositionRB", MotorRight_B.getCurrentPosition());
        telemetry.addData("PositionLB", MotorLeft_B.getCurrentPosition());
        telemetry.addData("PowerRF", MotorRight_F.getPower());
        telemetry.addData("PowerLF", MotorRight_F.getPower());
        telemetry.addData("PowerRB", MotorRight_F.getPower());
        telemetry.addData("PowerLB", MotorRight_F.getPower());
        MotorLeft_F.setPower(0.25);
        MotorRight_F.setPower(0.25);
        MotorRight_B.setPower(0.25);
        MotorLeft_B.setPower(0.25);
        if (Math.abs(MotorRight_F.getCurrentPosition()) >= 6655) {
            MotorRight_F.setPower(0);
        } else {
            MotorRight_F.setPower(.25);
        }
        if (Math.abs(MotorLeft_F.getCurrentPosition()) >= 6655) {
            MotorLeft_F.setPower(0);
        } else {
            MotorLeft_F.setPower(.25);
        }
        if (Math.abs(MotorRight_B.getCurrentPosition()) >= 6655) {
            MotorRight_F.setPower(0);
        } else {
            MotorRight_F.setPower(.25);
        }
        if (Math.abs(MotorLeft_B.getCurrentPosition()) >= 6655) {
            MotorLeft_F.setPower(0);
        } else {
            MotorLeft_F.setPower(.25);
        }
        // Check if we are where we want to be
//        if (Math.abs(MotorLeft_F.getCurrentPosition()) >= 6654.79868716 && Math.abs( MotorRight_F.getCurrentPosition() ) >= 6654.79868716 && Math.abs( MotorRight_F.getCurrentPosition() ) >= 6654.79868716 && ( MotorRight_B.getCurrentPosition()) >= 6654.79868716) {
//            MotorLeft_F.setPower(0);
//            MotorRight_F.setPower(0);
//            MotorLeft_B.setPower(0);
//            MotorRight_B.setPower(0);
//            telemetry.addData("PowerRF", MotorRight_F.getPower());
//            telemetry.addData("PowerLF", MotorRight_F.getPower());
//            telemetry.addData("PowerRB", MotorRight_F.getPower());
//            telemetry.addData("PowerLB", MotorRight_F.getPower());
//            telemetry.addData("Debug", "Autonomous in intended position");
//
//        }else {
//            // Set Motor Power
//            MotorRight_F.setPower(0.25);
//            MotorLeft_F.setPower(0.25);
//            MotorRight_B.setPower(0.25);
//            MotorLeft_B.setPower(0.25);
//            telemetry.addData("PowerRF", MotorRight_F.getPower());
//            telemetry.addData("PowerLF", MotorRight_F.getPower());
//            telemetry.addData("PowerRB", MotorRight_F.getPower());
//            telemetry.addData("PowerLB", MotorRight_F.getPower());
//        }
//        telemetry.addData("PowerRF", MotorRight_F.getPower());
//        telemetry.addData("PowerLF", MotorRight_F.getPower());
//        telemetry.addData("PowerRB", MotorRight_F.getPower());
//        telemetry.addData("PowerLB", MotorRight_F.getPower());
//    }
    }
}
