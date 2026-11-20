package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Turret {
    private HardwareMap hardwareMap;
    CRServo turret;

    /**
     * This controls the Turret.
     * @param turretPower set to the gamepad control you want to assign to the turret
     */
    public void turretManual(double turretPower) {
        turret = hardwareMap.get(CRServo.class, "turretServo");

        turret.setPower(turretPower);
    }
    public void setTurretPower(double turretPower) {
        turret = hardwareMap.get(CRServo.class, "turretServo");

        turret.setPower(turretPower);
    }
}

//FTC AprilTag Values:
// Side One: 38, 39, 40, 41,
// Side Two: 42, 43, 44, 45