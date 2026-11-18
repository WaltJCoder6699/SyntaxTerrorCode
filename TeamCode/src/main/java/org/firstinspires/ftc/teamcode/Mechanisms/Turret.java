package org.firstinspires.ftc.teamcode.Mechanisms;

import static com.qualcomm.hardware.limelightvision.LLResultTypes.*;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import java.util.List;
import java.util.ArrayList;

public class Turret {
    LimelightAprilTagDetection limelightAprilTagDetection = new LimelightAprilTagDetection();

    protected static final List<Number> sideOne = new ArrayList<>(List.of(38, 39, 40, 41));
        //List side one AprilTag IDs
    protected static final List<Number> sideTwo = new ArrayList<>(List.of(42, 43, 44, 45));

    //List side two AprilTag IDs
    public void turretAutoSpinToAprilTag(Limelight3A limelight, Telemetry telemetry, HardwareMap hardwareMap) {

        limelightAprilTagDetection.limelight(hardwareMap);
        //Implement the limelight code from our custom class

        LLResult result = limelight.getLatestResult();
        List<FiducialResult> fiducialResults = result.getFiducialResults();
        //Check for latest AprilTag results

        for (FiducialResult fr : fiducialResults) {
            if (!sideOne.contains(fr.getFiducialId())) {
            telemetry.addData("LLResult", "Is Working");
            telemetry.update();

            telemetry.addData("Fiducial", "ID: %d, Family: %s, X: %.2f, Y: %.2f", fr.getFiducialId(), fr.getFamily(), fr.getTargetXDegrees(), fr.getTargetYDegrees());
            }
        }
    }
}

//FTC AprilTag Values:
// Side One: 38, 39, 40, 41,
// Side Two: 42, 43, 44, 45