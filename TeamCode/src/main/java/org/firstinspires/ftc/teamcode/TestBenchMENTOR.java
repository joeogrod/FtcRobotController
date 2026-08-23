package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.testbenchmechMENTOR;

/* NO BUTTON ASSIGNMENT
@TeleOp ()

public class TestBenchMENTOR extends OpMode {

    testbenchmechMENTOR bench = new testbenchmechMENTOR();



    double motorPower;

    @Override
    public void init () {
        bench.init(hardwareMap);

    }


    @Override
    public void loop () {
        bench.setMotorSpeed(0.5);

    }



}*/

//BUTTON ASSIGNMENT
@TeleOp ()
public class TestBenchMENTOR extends OpMode {

    testbenchmechMENTOR bench = new testbenchmechMENTOR();



    double motorPower;

    @Override
    public void init () {
        bench.init(hardwareMap);

    }


    @Override
    public void loop () {
        //motor1 speed
        double motorSpeed = gamepad1.left_stick_y;

        bench.setMotorSpeed(motorSpeed);
        //servo0 claw open/close
        if (gamepad1.a) {
            bench.setServo0Pos(1.0);
        }
        else {
            bench.setServo0Pos(0);}
    }



}



