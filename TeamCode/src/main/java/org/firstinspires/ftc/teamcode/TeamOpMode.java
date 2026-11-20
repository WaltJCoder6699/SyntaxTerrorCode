package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.LLStatus;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.teamcode.Mechanisms.Drivetrain;
import org.firstinspires.ftc.teamcode.Mechanisms.Intake;
import org.firstinspires.ftc.teamcode.Mechanisms.MecanumDrive;
import org.firstinspires.ftc.teamcode.Mechanisms.Turret;

import java.util.ArrayList;
import java.util.List;

@TeleOp
public class TeamOpMode extends OpMode {
    //Creates new "runtime" class for OpMode time
    private final ElapsedTime runtime = new ElapsedTime();
    private final Limelight3A limelight = hardwareMap.get(Limelight3A.class, "limelight");
    protected static final List<Integer> sideOne = new ArrayList<>(List.of(38, 39, 40, 41));
    //List side one AprilTag IDs
    protected static final List<Integer> sideTwo = new ArrayList<>(List.of(42, 43, 44, 45));
    //List side one AprilTag IDs

    /**
     * Hardware Class Implementations
     */
    Drivetrain drivetrain; //Controls drivetrain

    {
        this.drivetrain = new Drivetrain();
    }

    MecanumDrive mecanumDrive; //Controls the mecanumDrive specifically

    {
        this.mecanumDrive = new MecanumDrive();
    }

    Intake intake; //Controls t

    {
        this.intake = new Intake();
    }

    Turret turret;

    {
        this.turret = new Turret();
    }


    @Override
    public void init() {
        drivetrain.drivetrainInit(hardwareMap); //Bring in the Drivetrain functionality to the OpMode

        /*
        This is for setting up the Limelight;
            1) Shorten the Transmission Interval so that the camera feed updates within 11 milliseconds
            2) Default Image processing pipeline
            3) Starts polling for data.  If you neglect to call start(), getLatestResult() will return null
            4) Tells telemetry to update the Driver Hub with current results

         */
        telemetry.setMsTransmissionInterval(11);

        limelight.pipelineSwitch(0);

        /*
         * Starts polling for data.  If you neglect to call start(), getLatestResult() will return null.
         */
        limelight.start();

        telemetry.addData(">", "Robot Ready.  Press Play.");
        telemetry.update();

        getLimelightStatus();
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
        mecanumDrive.mecanumDrive(-gamepad1.left_stick_y, gamepad1.right_stick_x, gamepad1.left_stick_x);
    }

    public void getLimelightStatus () {
        LLStatus status = limelight.getStatus();
        telemetry.addData("Name", "%s",
                status.getName());
        telemetry.addData("LL", "Temp: %.1fC, CPU: %.1f%%, FPS: %d",
                status.getTemp(), status.getCpu(), (int) status.getFps());
        telemetry.addData("Pipeline", "Index: %d, Type: %s",
                status.getPipelineIndex(), status.getPipelineType());
        //Post to Telemetry the current stats of Limelight Hardware
        limelight.getStatus();
        telemetry.addData("Name", "%s",
                status.getName());
        telemetry.addData("LL", "Temp: %.1fC, CPU: %.1f%%, FPS: %d",
                status.getTemp(), status.getCpu(), (int) status.getFps());
        telemetry.addData("Pipeline", "Index: %d, Type: %s",
                status.getPipelineIndex(), status.getPipelineType());
    }

    public void getLatestAprilTagResult() {
        LLResult result = limelight.getLatestResult();
        List<LLResultTypes.FiducialResult> fiducialResults = result.getFiducialResults();

        for (LLResultTypes.FiducialResult fr : fiducialResults) {
            telemetry.addData("Fiducial", "ID: %d, Family: %s, X: %.2f, Y: %.2f",
                    fr.getFiducialId(),      //Get the specific ID of the AprilTag
                    fr.getFamily(),          //Get the specific family that the AprilTag belongs in?
                    fr.getTargetXDegrees(),  //Get the Degrees X (Horizontal) from the AprilTag
                    fr.getTargetYDegrees()); //Get the Degrees Y (Vertical) from the AprilTag
        }
    }
    public void autoTurret() {
        LLResult result = limelight.getLatestResult();
        List<LLResultTypes.FiducialResult> fiducialResults = result.getFiducialResults();

        if(limelight.isRunning()) {

            for (LLResultTypes.FiducialResult fr : fiducialResults) {
//                Telemetry for the AprilTags
                telemetry.addData("Fiducial", "ID: %d, Family: %s, X: %.2f, Y: %.2f",
                        fr.getFiducialId(),      //Get the specific ID of the AprilTag
                        fr.getFamily(),          //Get the specific family that the AprilTag belongs in?
                        fr.getTargetXDegrees(),  //Get the Degrees X (Horizontal) from the AprilTag
                        fr.getTargetYDegrees()); //Get the Degrees Y (Vertical) from the AprilTag
                telemetry.update();

                int DetectedAprilTag = fr.getFiducialId();

                if( (sideOne.contains(DetectedAprilTag)) || (sideTwo.contains(DetectedAprilTag)) ) {

                } else {
                    break; }
            }

        }


    }













    public void getLatestResult () {
        LLResult result = limelight.getLatestResult();
        if (result.isValid()) {
            // Access general information
            Pose3D Botpose = result.getBotpose();
            double captureLatency = result.getCaptureLatency();
            double targetingLatency = result.getTargetingLatency();
            double parseLatency = result.getParseLatency();
            telemetry.addData("LL Latency", captureLatency + targetingLatency);
            telemetry.addData("Parse Latency", parseLatency);
            telemetry.addData("PythonOutput", java.util.Arrays.toString(result.getPythonOutput()));

            telemetry.addData("tx", result.getTx());
            telemetry.addData("txnc", result.getTxNC());
            telemetry.addData("ty", result.getTy());
            telemetry.addData("tync", result.getTyNC());

            telemetry.addData("Botpose", Botpose.toString());

            // Access fiducial results
            List<LLResultTypes.FiducialResult> fiducialResults = result.getFiducialResults();
            for (LLResultTypes.FiducialResult fr : fiducialResults) {
                telemetry.addData("Fiducial", "ID: %d, Family: %s, X: %.2f, Y: %.2f", fr.getFiducialId(), fr.getFamily(), fr.getTargetXDegrees(), fr.getTargetYDegrees());
            }

            telemetry.update();
        }
    }
}
//FTC AprilTag Values:
// Side One: 38, 39, 40, 41,
// Side Two: 42, 43, 44, 45