package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

import java.util.concurrent.TimeUnit;
import org.firstinspires.ftc.teamcode.ToggleButton;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.USBCamera;

import org.openftc.easyopencv.OpenCvWebcam;
import org.openftc.easyopencv.OpenCvCameraFactory;


@TeleOp(name="Mechanum", group="Iterative Opmode")
public class Robot extends OpMode {
        
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

    private IMU imu;
    private YawPitchRollAngles gyro;
    // private OpenCvWebcam webcam;

    private Drivetrain mecanum;
    // private USBCamera camera;
    


    @Override
    public void init() {
        
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        
        imu = createIMU();
        // int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        // webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        
        imu.resetYaw();

        // Subsystems
        mecanum = new Drivetrain(frontLeft, frontRight, backLeft, backRight);
        // camera = new USBCamera(webcam);
    }



    public void updateData() {
        telemetry.update();
    }
    
    public IMU createIMU() {
        return hardwareMap.get(IMU.class, "imu");
    }
    


    @Override
    public void loop() {
        // IMU
        gyro = imu.getRobotYawPitchRollAngles();

        // Sticks
        double translateX = gamepad1.left_stick_x;
        double translateY = gamepad1.left_stick_y * -1;
        double rotate = gamepad1.right_stick_x * 0.5;

        // Buttons and Triggers
        boolean leftBumper = gamepad1.left_bumper; // Toggle Left Claw
        boolean rightBumper = gamepad1.right_bumper; // Toggle Right Claw
        boolean leftTrigger = gamepad1.left_trigger > 0.5; // Hold to grab
        boolean rightTrigger = gamepad1.right_trigger > 0.5; // Toggle to place

        boolean a = gamepad1.a;
        boolean b = gamepad1.b;
        boolean x = gamepad1.x;
        boolean y = gamepad1.y;
        
        // Telemetry
        telemetry.addData("IMU state", String.valueOf(gyro.getYaw(AngleUnit.DEGREES)));
        // telemetry.addData("Detected X", String.valueOf(camera.getBestDetectedPosition()[0]));
        // telemetry.addData("Detected Y", String.valueOf(camera.getBestDetectedPosition()[1]));


        // Loops
        updateData();
        mecanum.runMecanum(translateX, translateY, rotate, gyro.getYaw(AngleUnit.RADIANS));

        func_resetIMU(b);

        updateAll();
    }



    public void updateAll() {}
    
    
    
    public void func_resetIMU(boolean input) {
        if (input) {
            new Thread(() -> {
                try {
                    imu.close();
                    Thread.sleep(100);
                    imu = createIMU();
                    Thread.sleep(100);
                    imu.resetYaw();
                    Thread.sleep(100);
                } catch (Exception e) {}
            }).start();
        }
    }

}