package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumDrive {
    Drivetrain drivetrain = new Drivetrain();
    public void drive(Gamepad gamepad) {
        double power = Math.max(Math.min(gamepad.left_stick_y, 1.0), -1.0);
        drivetrain.setPowers(power, power, power, power);
    }
    public void strafeLeft(Gamepad gamepad) {
        double power = gamepad.left_stick_x;
        drivetrain.setPowers(-power, power, power, -power);
    }
    public void strafeRight(Gamepad gamepad) {
        double power = gamepad.left_stick_x;
    }
    public void turnRight(Gamepad gamepad) {
        double power = gamepad.right_stick_x;
        drivetrain.setPowers(power, power, -power, -power);
    }
    public void turnLeft(Gamepad gamepad) {
        double power = -Math.abs(gamepad.right_stick_x);
        drivetrain.setPowers(-power, -power, power, power);
    }
}
