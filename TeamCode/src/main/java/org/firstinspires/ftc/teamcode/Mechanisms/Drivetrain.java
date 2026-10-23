package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Arrays;


public class Drivetrain {
    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;

  
    
    public void motor_init(HardwareMap hardwareMap) {
        DcMotor[] motors = {leftFront, leftBack, rightFront, rightBack};

        motors[0] = hardwareMap.get(DcMotor.class
        for(DcMotor motors : motors) {
            motors.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            motors.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }

        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);


        for (DcMotor dcMotor : DcMotor()) {
            dcMotor[0] = hardwareMap.get(DcMotor.class, "leftFront");
        }
    }
}
