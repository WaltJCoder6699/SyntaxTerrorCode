package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Mechanisms.Drivetrain;
import org.firstinspires.ftc.teamcode.Mechanisms.MecanumDrive;

@TeleOp
public class TeamOpMode extends OpMode {
    //Creates new "runtime" class for OpMode time
    private ElapsedTime runtime = new ElapsedTime();

    //Call custom classes coded by the team
    Drivetrain drivetrain; //Controls drivetrain

    {
        drivetrain = new Drivetrain();
    }
    MecanumDrive mecanumDrive; //Controls the mecanumDrive specifically

    {
        mecanumDrive = new MecanumDrive();
    }

    Limelight


    @Override
    public void init() {

    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {
        /* ?Provide instant end to OpMode if gamepad 1 or 2 presses start - Still in Question?
         * if (gamepad1.start || gamepad2.start) {
         *  terminateOpModeNow();
         *}
         */
    }

    @Override
    public void stop() {
        //Park robot in parking space at end of OpMode
    }
}