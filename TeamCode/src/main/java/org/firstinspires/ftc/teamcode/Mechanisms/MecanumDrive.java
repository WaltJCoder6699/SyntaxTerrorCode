package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * This is the class for running a Mecanum Drive robot
 * Implement it at the start of your class like so:
 * @code MecanumDrive mecanumDrive = new MecanumDrive();
 */

public class MecanumDrive {

    // Imports Drivetrain Mechanisms Class for easy Drivetrain control
    Drivetrain drivetrain = new Drivetrain();

    /**
     * This is for allowing the robot to simply drive back and forward with Gamepad Left Stick Y
     * @param gamepad set to gamepad
     * @param telemetry set to telemetry
     */
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

    /**
     * This is for strafing left or right, using the left joystick X axis
     * @param gamepad set to gamepad
     * @param telemetry set to telemetry
     */
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

    /**
     * This is for turning right
     * @param gamepad set to gamepad
     * @param telemetry set to telemetry
     */
    public void turnRight(Gamepad gamepad, Telemetry telemetry) {
        double power = -Math.abs(gamepad.right_stick_x);
        drivetrain.setPowers(power, power, -power, -power);
    }
    // Turns left when called and gamepad is used

    /**
     * This is for turing left
     * @param gamepad set to gamepad
     * @param telemetry set to telemetry
     */
    public void turnLeft(Gamepad gamepad, Telemetry telemetry) {
        double power = -Math.abs(gamepad.right_stick_x);
        drivetrain.setPowers(-power, -power, power, power);
    }

    /**
     * Instantiate this as a method to give control for a mecanum drive robot
     */
    public void mecanumDrive(double drive, double strafe, double turn) {

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
}
