package org.firstinspires.ftc.teamcode;


public class Constants {

    public static final class DriveConstants {
        public static final double speed = 1.0;
    }



    public static final class AutoConstants {

        public static final double[][] path_frontLeft_2p = {
            {6, 0, 0.6}, // 0
            {0, 4.6, 0.6},
            {5, 0, 0.6}, // 2 arm up and wrist
            {0, 2, 0.35}, // 3 claw place
            {0, -2, 0.3},// 4 everything down
            {-11, 0, 0.6}, // 5 everything down
            {0, 4, 0.6},
            {0, 0, 0} // 7
        };
        public static final double[][] path_frontRight_2p = {
            {-6, 0, 0.6}, // 0
            {0, 4.1, 0.6},
            {-5, 0, 0.6}, // 2 arm up and wrist
            {0, 2, 0.35}, // 3 claw place
            {0, -2, 0.3},// 4 everything down
            {11, 0, 0.6}, // 5 everything down
            {0, 4, 0.6},
            {0, 0, 0} // 7
        };
        public static final double[][] path_backLeft_2p = {
            {5.5, 0, 0.6}, // 0
            {0, 9, 0.6},
            {5, 0, 0.6}, // 2 arm up and wrist
            {0, 2, 0.35}, // 3 claw place
            {0, -2, 0.3},// 4 everything down
            {-11, 0, 0.6}, // 5 everything down
            {0, 4, 0.6},
            {0, 0, 0} // 7
        };
        public static final double[][] path_backRight_2p = {
            {-6, 0, 0.6}, // 0
            {0, 8, 0.6},
            {-5, 0, 0.6}, // 2 arm up and wrist
            {0, 2, 0.35}, // 3 claw place
            {0, -2, 0.3},// 4 everything down
            {11, 0, 0.6}, // 5 everything down
            {0, 4, 0.6},
            {0, 0, 0} // 7
        };
        public static final double[][] path_frontLeft_2p_backstageClose = {
            {6, 0, 0.6}, // 0
            {0, 4.6, 0.6},
            {5, 0, 0.6}, // 2 arm up and wrist
            {0, 2, 0.35}, // 3 claw place
            {0, -2, 0.3},// 4 everything down
            {-5.5, 0, 0.6}, // 5 everything down
            {0, 4, 0.6},
            {0, 0, 0} // 7
        };
        public static final double[][] path_backLeft_2p_backstageClose = {
            {5.5, 0, 0.6}, // 0
            {0, 9, 0.6},
            {5, 0, 0.6}, // 2 arm up and wrist
            {0, 2, 0.35}, // 3 claw place
            {0, -2, 0.3},// 4 everything down
            {-5.5, 0, 0.6}, // 5 everything down
            {0, 4, 0.6},
            {0, 0, 0} // 7
        };
        public static final double[][] path_backRight_2p_backstageClose = {
            {-6, 0, 0.6}, // 0
            {0, 8, 0.6},
            {-5, 0, 0.6}, // 2 arm up and wrist
            {0, 2, 0.35}, // 3 claw place
            {0, -2, 0.3},// 4 everything down
            {5.5, 0, 0.6}, // 5 everything down
            {0, 4, 0.6},
            {2, 0, 0.3},
            {0, 0, 0} // 7
        };

         public static final String[][] actions_frontLeft_2p = {
            {"claw_clamp", "wrist_store"},
            {},
            {"arm_frontLow", "wrist_frontLow"},
            {"claw_open"},
            {"arm_store", "wrist_store", "claw_clamp"}
        };
        public static final String[][] actions_frontRight_2p = {
            {"claw_clamp", "wrist_store"},
            {},
            {"arm_frontLow", "wrist_frontLow"},
            {"claw_open"},
            {"arm_store", "wrist_store", "claw_clamp"}
        };
        public static final String[][] actions_backLeft_2p = {
            {"claw_clamp", "wrist_store"},
            {},
            {"arm_frontLow", "wrist_frontLow"},
            {"claw_open"},
            {"arm_store", "wrist_store", "claw_clamp"}
        };
        public static final String[][] actions_backRight_2p = {
            {"claw_clamp", "wrist_store"},
            {},
            {"arm_frontLow", "wrist_frontLow"},
            {"claw_open"},
            {"arm_store", "wrist_store", "claw_clamp"}
        };


        public static final double[][] currentPath = path_backLeft_2p_backstageClose;
        public static final String[][] currentActions = actions_backLeft_2p;

        public static final int tolerance = 40;
        public static final double stepsPerRotation = 537.7;
    }

    

    public static final class CameraConstants {
        public static final int camera_width = 320;
        public static final int camera_height = 240;
    }
}