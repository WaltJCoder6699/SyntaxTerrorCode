package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.CameraName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

import java.util.List;

@TeleOp
public class Turret extends OpMode {
    private VisionPortal visionPortal;
    private AprilTagProcessor aprilTagProcessor;

    public void init() {}
    public void loop() {}

    public void initLimelight() {
        private Limelight3A limelight;
            limelight = hardwareMap.get(Limelight3A.class, "limelight3A");

        List<AprilTagDetection> currentDetections = aprilTagProcessor.getDetections();
        AprilTagProcessor = AprilTagProcessor.Builder.easy(limelight, aprilTagProcessor);
                limelight, aprilTagProcessor);



    }
}