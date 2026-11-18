package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {
    DcMotor intakeMotor;



    public void intakeInit(HardwareMap hardwareMap, Telemetry telemetry) {
        //Assign hardware
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");

        //Set motor settings to preferred settings
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Give us a confirmation of initialization
        telemetry.addData("Intake", "Initialized");
        telemetry.update();
    }

    /**
     * This is to run the intake manually via Gamepad left trigger
     * @param gamepad set to gamepad
     * @param telemetry set to telemetry
     */
    public void runIntake(Gamepad gamepad, Telemetry telemetry) {

        //Make the intake have activation inputs from the gamepad
        double im = gamepad.left_trigger;
        intakeMotor.setPower(im);

        //Show intake motor power
        telemetry.setMsTransmissionInterval(11);
        telemetry.addData("IntakeMotor", "intakeMotor");
        telemetry.update();
    }
}