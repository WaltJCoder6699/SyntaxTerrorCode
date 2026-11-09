package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.CameraName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

import java.util.List;

@TeleOp
public class Turret extends OpMode {
    private
    private VisionPortal visionPortal;
    private AprilTagProcessor aprilTagProcessor;

    @Override
    public void init() {

    }
    @Override
    public void init_loop() {
        initLimelight();
    }
    @Override
    public void start() {

    }
    @Override
    public void loop() {}

    public void initLimelight() {
        //Call Limelight3A Hardware
        Limelight3A limelight = hardwareMap.get(Limelight3A.class, "limelight");

        /*
         * Sets the telemetry transmission interval so that Telemetry updates way faster
         * (changes to 11 ms vs. default 250ms)
         * This is so that the DS can read Telemetry far faster
         */
        telemetry.setMsTransmissionInterval(11);

        limelight.pipelineSwitch(0);

        /*
         * Starts polling for data.  If you neglect to call start(), getLatestResult() will return null.
         */
        limelight.start();

        telemetry.addData(">", "Robot Ready.  Press Play.");
        telemetry.update();
    }
}