package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "testbenchclear")
public class testbenchclear extends OpMode {

    public DcMotor motor;
    public Servo cutinitServo;
    double motorPower;
    double slowDown = 0.2;

    @Override
    public void init() {
        motor = hardwareMap.get(DcMotor.class, "Motor1");
        motorPower = 0.0;

        cutinitServo = hardwareMap.get(Servo.class, "servo0");

        telemetry.addData("Init Function", "Completed");
        telemetry.update();
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            telemetry.addData("What is being pressed","a");
            motor.setPower(gamepad1.left_stick_y * slowDown);
        } else {
            motor.setPower(gamepad1.left_stick_y);
        }

        if (gamepad1.b){
            motor.setPower(0.25);
            telemetry.addData("What is being pressed","b");
        } else {
            motor.setPower(0.0);
        }

        if (gamepad1.right_bumper) {
            cutinitServo.setPosition(1.0); // Spin forward
            telemetry.addData("CR Servo", "Spinning Forward");
        } else if (gamepad1.left_bumper) {
            cutinitServo.setPosition(0.0); // Spin backward
            telemetry.addData("CR Servo", "Spinning Backward");
        } else {
            cutinitServo.setPosition(0.5); // Stop
            telemetry.addData("CR Servo", "Stopped");
        }

        telemetry.addData("left stick y",gamepad1.left_stick_y * slowDown);
        telemetry.update();


    }
}
