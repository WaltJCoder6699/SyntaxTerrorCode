package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {
    DcMotor intakeMotor;
    double intakeMotorPower;


    public void runIntake(HardwareMap hardwareMap, Telemetry telemetry, Gamepad gamepad) {
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");

        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Intake", "Initialized");

        intakeMotorPower = gamepad.left_trigger;
        intakeMotor.setPower(intakeMotorPower);

        telemetry.addData("IntakeMotor", "intakeMotor");
        telemetry.update();
    }
}