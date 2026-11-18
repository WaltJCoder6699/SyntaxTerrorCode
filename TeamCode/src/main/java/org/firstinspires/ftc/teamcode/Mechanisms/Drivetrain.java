package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * This is the class controlling the base motors to organize them into a coherent drivetrain
 *
 * Use it like this:
 * @code Drivetrain drivetrain = new Drivetrain();
 */
public class Drivetrain {

    //Declare our motors
    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;

    //Assign the hardware, set essential motor settings

    /**
     * This is used in OpMode or a drivetrain class to initialize motors in the drivetrain
     *
     * The correct usage is
     * @code drivetrain.drivetrainInit();
     */
    public void drivetrainInit(HardwareMap hardwareMap) {
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        DcMotor[] allMotors = new DcMotor[]{leftFront, leftBack, rightFront, rightBack};

        for(DcMotor motor : allMotors) {
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }

        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    //Method for setting motor powers

    /**
     * This is to set the powers of each individual motor in the drivetrain.
     * Note that it assumes that you have a four-motor drivetrain
     *
     * @param lf set to left front motor power
     * @param lb set to left back motor power
     * @param rf set to right front motor power
     * @param rb set to right back motor power
     */
    public void setPowers(double lf, double lb, double rf, double rb) {
        leftFront.setPower(lf);
        leftBack.setPower(lb);
        rightFront.setPower(rf);
        rightBack.setPower(rb);
    }
}
