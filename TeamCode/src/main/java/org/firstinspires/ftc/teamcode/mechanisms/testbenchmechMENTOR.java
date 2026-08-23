package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class testbenchmechMENTOR {
    //NO BUTTON ASSIGNED
    //private member variable, name based on usage, be as descriptive as you need
    private DcMotor motor1;
    private Servo servo0;
    private Servo servo1;

    //initialization statement to pull object into OpMode Class
    public void init (HardwareMap hwMap) {

        //DCMotor Code, deviceName exact name in Config/Driver Station
        motor1 = hwMap.get(DcMotor.class, "motor1");
        //set motor mode, should use Run Using Encoder
        motor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //Servo0 Code, deviceName exact name in Config/Driver Station
        servo0 = hwMap.get(Servo.class, "servo0");

        //Servo1 Code, deviceName exact name in Config/Driver Station
        servo1 = hwMap.get(Servo.class, "servo1");
    }

    //set up setter method because op mode is separate from mech folder, this sets up how to control motor power, which is defined in the TestBenchClass
    public void setMotorSpeed(double speed) {
            motor1.setPower(speed);
    }
    //set up setter method because op mode is separate from mech folder, this sets up how to control the servo, which is defined in the TestBenchClass
    public void setServo0Pos(double angle) {
        servo0.setPosition(angle);
    }
    public void setServo1Pos(double angle) {
        servo1.setPosition(angle);
    }
}
