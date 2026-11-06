package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MecanumDrive {

    // Imports Drivetrain Mechanisms Class for easy Drivetrain control
    Drivetrain drivetrain = new Drivetrain();

    // For driving forward/backward based on gamepad input
    public void drive(Gamepad gamepad, Telemetry telemetry) {
        double power = Math.max(Math.min(-gamepad.left_stick_y, 1.0), -1.0);
        drivetrain.setPowers(power, power, power, power);

        if(power < 0) {
            telemetry.addData("Driving", "Forward");
        }
        else {
            telemetry.addData("Driving","Backward");
        }
        telemetry.update();

    }
    // Strafes based upon gamepad input
    public void strafe(Gamepad gamepad, Telemetry telemetry) {
        double power = gamepad.left_stick_x;
        if(power < 0) {
            drivetrain.setPowers(power, -power, -power, power);

            telemetry.addData("Strafing", "left");
        }
        else {
           drivetrain.setPowers(-power, power, power, -power);

           telemetry.addData("Strafing", "Right");
        }
        telemetry.update();
    }
    // Turns based on gamepad input
    public void turnRight(Gamepad gamepad) {
        double power = -Math.abs(gamepad.right_stick_x);
        drivetrain.setPowers(power, power, -power, -power);
    }
    // Turns left when called and gamepad is used
    public void turnLeft(Gamepad gamepad) {
        double power = -Math.abs(gamepad.right_stick_x);
        drivetrain.setPowers(-power, -power, power, power);
    }
    // This is for one method for controlling the robot
    public void mecanumDrive(Gamepad gamepad) {
        // Create drive vars
        double drive;
        double strafe;
        double turn;

        // Assign drive vars
        drive = -gamepad.left_stick_y;
        strafe = gamepad.right_stick_x;
        turn = gamepad.left_stick_x;

        // Create power vars
        double leftFrontPower;
        double leftBackPower;
        double rightFrontPower;
        double rightBackPower;

        // Assign power vars with drive vars
        leftFrontPower = drive + strafe + turn;
        leftBackPower = drive - strafe + turn;
        rightFrontPower = drive - strafe - turn;
        rightBackPower = drive + strafe - turn;

        double powersCombined = Math.max(Math.abs(leftFrontPower), Math.abs(leftBackPower));
                powersCombined = Math.max(powersCombined, Math.abs(rightFrontPower));
                powersCombined = Math.max(powersCombined, Math.abs(rightBackPower));

        if(powersCombined > 1.0) {
           leftFrontPower /= powersCombined;
           leftBackPower /= powersCombined;
           rightFrontPower /= powersCombined;
           rightBackPower /= powersCombined;
        }

        // Send the finished motor powers to the actual hardware
        drivetrain.setPowers(leftFrontPower, leftBackPower, rightFrontPower, rightBackPower);
    }
    /*
    * Disclosure: the mathematics of this code was helped along with, by FTC Samples and AI
    * */
}
