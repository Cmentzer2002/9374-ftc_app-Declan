package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.robocol.Telemetry;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Declan Freeman-Gleason, Christopher Mentzer, and Cory Houser on 11/4/2015.
 */
public class TeleOp extends OpMode {
    float startTime;
    double servo3Pos;
    double servo4Pos;
    double servo5Pos;
    boolean servoPos;
    boolean direction;
    boolean aDown;
    double ArmPower;
	double ArmServo;
    double CoryArmRight;
    double CoryArmLeft;
    Servo servo1;
    Servo servo2;
    Servo servo3;
    Servo servo4;
    Servo servo5;
	Servo servo6;
    Servo servo7;
    DcMotor MotorRight_F;
    DcMotor MotorLeft_F;
    DcMotor MotorRight_B;
    DcMotor MotorLeft_B;
    DcMotor ArmMotor;
    @Override
    public void init() {
        // True: Plow is on the backside of the robot, False: Plow is on the front.
        direction = true;
        aDown = false;
        startTime = 0;
        servoPos = true;
        servo3Pos = 1;
        servo4Pos = 1;
        servo5Pos = 1;
        ArmPower = 0;
        ArmServo = 0;
		CoryArmLeft = 0;
		CoryArmRight = 1;
        MotorRight_F = hardwareMap.dcMotor.get("RightMotorF");
        MotorLeft_F = hardwareMap.dcMotor.get("LeftMotorF");
        MotorRight_B = hardwareMap.dcMotor.get("RightMotorB");
        MotorLeft_B = hardwareMap.dcMotor.get("LeftMotorB");
//        ArmMotor = hardwareMap.dcMotor.get("ArmMotor");
        // True: Plow is on the backside of the robot, False: Plow is on the front.
        if (direction) {
            // Plow is on the backside
            MotorRight_F.setDirection(DcMotor.Direction.REVERSE);
            MotorRight_B.setDirection(DcMotor.Direction.REVERSE);
            MotorLeft_F.setDirection(DcMotor.Direction.FORWARD);
            MotorLeft_B.setDirection(DcMotor.Direction.FORWARD);
        } else if (!direction) {
            // Plow is on the front
            MotorRight_F.setDirection(DcMotor.Direction.FORWARD);
            MotorRight_B.setDirection(DcMotor.Direction.FORWARD);
            MotorLeft_F.setDirection(DcMotor.Direction.REVERSE);
            MotorLeft_B.setDirection(DcMotor.Direction.REVERSE);
        }
        MotorLeft_F.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        MotorRight_F.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        MotorLeft_B.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        MotorRight_B.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        servo1 = hardwareMap.servo.get("servo1");
        servo2 = hardwareMap.servo.get("servo2");
        servo3 = hardwareMap.servo.get("servo3");
        servo4 = hardwareMap.servo.get("servo4");
        servo5 = hardwareMap.servo.get("servo5");
		servo6 = hardwareMap.servo.get("servo6");
        servo7 = hardwareMap.servo.get("servo7");
        servo1.setPosition(1);
        servo2.setPosition(0);
        servo3.setPosition(0.8);
        servo4.setPosition(0.2);
        servo5.setPosition(1);
		servo6.setPosition(0);
		servo7.setPosition(1);
    }

    @Override
    public void loop() {
        float rightMotor_F = 0;
        float rightMotor_B = 0;
        float leftMotor_F = 0;
        float leftMotor_B = 0;
        double leftTrigger = 0;
        double rightTrigger = 0;
        ArmPower = 0;
        if (gamepad1.a && !aDown) {
            aDown = true;
        } else if (!gamepad1.a && aDown) {
            if (direction) {
                direction = false;
            } else {
                direction = true;
            }
            aDown = false;
        }
        // True: Plow is on the backside of the robot, False: Plow is on the front.
        if (direction) {
            // Plow is on the backside
            MotorRight_F.setDirection(DcMotor.Direction.REVERSE);
            MotorRight_B.setDirection(DcMotor.Direction.REVERSE);
            MotorLeft_F.setDirection(DcMotor.Direction.FORWARD);
            MotorLeft_B.setDirection(DcMotor.Direction.FORWARD);
            leftMotor_F = gamepad1.right_stick_y;
            leftMotor_B = gamepad1.right_stick_y;
            rightMotor_F = gamepad1.left_stick_y;
            rightMotor_B = gamepad1.left_stick_y;
        } else if (!direction) {
            // Plow is on the front
            MotorRight_F.setDirection(DcMotor.Direction.FORWARD);
            MotorRight_B.setDirection(DcMotor.Direction.FORWARD);
            MotorLeft_F.setDirection(DcMotor.Direction.REVERSE);
            MotorLeft_B.setDirection(DcMotor.Direction.REVERSE);
            leftMotor_F = gamepad1.left_stick_y;
            leftMotor_B = gamepad1.left_stick_y;
            rightMotor_F = gamepad1.right_stick_y;
            rightMotor_B = gamepad1.right_stick_y;
        }
        telemetry.addData("Stick / Motor Values Before Modification", leftMotor_F);
        if (!gamepad1.left_bumper) {
            leftMotor_F = leftMotor_F / 3;
            leftMotor_B = leftMotor_B / 3;
        }
        if (!gamepad1.right_bumper) {
            rightMotor_F = rightMotor_F / 3;
            rightMotor_B = rightMotor_B / 3;
        }
        if(gamepad2.x){
			CoryArmLeft += 0.1;
        } else if (gamepad2.b) {
            CoryArmLeft -= 0.1;
        }
		if(gamepad2.y){
			CoryArmRight += 0.1;
		} else if (gamepad2.a){
			CoryArmRight -= 0.1;
		}
        telemetry.addData("Stick / Motor Values After Modification", leftMotor_F);
//        telemetry.addData("Motor Values", "Motor Left Front: " + MotorLeft_F + ", Motor Left Back: " + MotorLeft_B + ", Motor Right Front: " + MotorRight_F + ", Motor Right Back: " + MotorRight_B);
        MotorRight_F.setPower(rightMotor_F);
        MotorRight_B.setPower(rightMotor_B);
        MotorLeft_F.setPower(leftMotor_F);
        MotorLeft_B.setPower(leftMotor_B);



        leftTrigger = gamepad2.left_trigger;
        servo2.setPosition(leftTrigger);

        if (gamepad2.right_trigger > 0.5) {
            rightTrigger = 0;
        } else if (gamepad2.right_trigger < 0.5) {
            rightTrigger = 1;
        } else if (gamepad2.right_trigger == 0.5) {
            rightTrigger = 0.5;
        } else {
            rightTrigger = 1;
        }
        
        servo1.setPosition(rightTrigger);
//        if (gamepad2.a) {
//            if (startTime == 0) {
//                startTime = System.currentTimeMillis();
//                servo4.setPosition(0);
//                servo3.setPosition(1);
//            } else {
//                if (System.currentTimeMillis() - startTime > 1000){
//                    servo4.setPosition(1);
//                    servo3.setPosition(0);
//                    startTime = 0;
//                }
//            }
//}

//        if (gamepad2.a) {
//            servo4.setPosition(1);
//            servo3.setPosition(0);
//        }
//        if (gamepad2.b) {
//            servo4.setPosition(0);
//            servo3.setPosition(1);
//        }

        if (gamepad2.left_stick_y >= 0.2) {
            servo3Pos += 0.1;
            servo4Pos -= 0.1;
        } else if (gamepad2.left_stick_y <= -0.2) {
            servo3Pos -= 0.1;
            servo4Pos += 0.1;
        }
        if (gamepad2.right_stick_y >= 0.2) {
            servo5Pos += 0.1;
        } else if (gamepad2.right_stick_y <= -0.2) {
            servo5Pos -= 0.1;
        }

		if (gamepad2.dpad_up) {
			ArmPower = 0.2;
		} else if (gamepad2.dpad_down) {
			ArmPower = -0.2;
		}
        rightMotor_F = Range.clip(rightMotor_F, -1, 1);
        rightMotor_B = Range.clip(rightMotor_B, -1, 1);
        leftMotor_F = Range.clip(leftMotor_F, -1, 1);
        leftMotor_B = Range.clip(leftMotor_B, -1, 1);
        leftTrigger = Range.clip(leftTrigger, 0, 1);
        rightTrigger = Range.clip(rightTrigger, 0, 1);
        ArmPower = Range.clip(ArmPower, -1, 1);
        ArmServo = Range.clip(ArmServo, 0, 1);
        servo3Pos = Range.clip(servo3Pos, 0, 0.8);
        servo4Pos = Range.clip(servo4Pos, 0.2, 1);
        servo5Pos = Range.clip(servo5Pos, 0, 1);
		CoryArmLeft = Range.clip(CoryArmLeft, 0, 1);
		CoryArmRight = Range.clip(CoryArmRight, 1, 0);
        servo3.setPosition(servo3Pos);
        servo4.setPosition(servo4Pos);
//        ArmMotor.setPower(ArmPower);
		servo5.setPosition (servo5Pos);
        servo6.setPosition(CoryArmLeft);
        servo7.setPosition(CoryArmRight);
		//        if (gamepad2.a) {
//            if (servoPos) {
//                servo4.setPosition(Range.clip(servo4.getPosition() - 0.2, 0, 0.8));
//                servo3.setPosition(Range.clip(servo3.getPosition() + 0.2, 0, 1));
//                if (servo4.getPosition() + servo3.getPosition() >= 1) {
//                    servoPos = false;
//                }
//            } else {
//                servo4.setPosition(Range.clip(servo4.getPosition() + 0.2, 0, 0.8));
//                servo3.setPosition(Range.clip(servo3.getPosition() - 0.2, 0, 0.8));
//                if (servo4.getPosition() + servo3.getPosition() >= 1) {
//                    servoPos = true;
//                }
//            }
//        }
    }
}