package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "AprilTag Distance Stop", group = "Sensor")
public class TestLimelight extends LinearOpMode {

    private Limelight3A limelight;
    private DcMotor motor1;

    @Override
    public void runOpMode() {
        // Initialize hardware from the hardware map
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        motor1 = hardwareMap.get(DcMotor.class, "Motor1");

        // Start the limelight and set to your AprilTag pipeline index (e.g., pipeline 0)
        limelight.start();
        limelight.pipelineSwitch(0);

        telemetry.addData("Status", "Initialized. Press Play.");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            LLResult result = limelight.getLatestResult();

            if (result != null && result.isValid()) {
                // 'ta' is the target area as a percentage (0.0 to 100.0) of the image
                double targetArea = result.getTa();

                telemetry.addData("Target Area (ta)", targetArea + "%");

                // If target takes up less than 10%, drive forward
                if (targetArea < 10.0) {
                    motor1.setPower(0.3); // Adjust power as needed
                    telemetry.addData("Action", "Moving Forward (Too Far)");
                } else {
                    // If it is 10% or closer, stop the motor
                    motor1.setPower(0.0);
                    telemetry.addData("Action", "Stopped (In Range)");
                }
            } else {
                // If no AprilTag is visible at all, stop the motor
                motor1.setPower(0.0);
                telemetry.addData("Status", "No AprilTag visible");
            }

            telepped: telemetry.update();
        }

        limelight.stop();
    }
}