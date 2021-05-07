package com.peoplepowerco.virtuoso.interfaces;

public interface IPPRobotDefines {
    int MAX_ROBOT_MOVEMENT_FACTOR           = 7;

    interface PPRobotType {
        int ROBOT_DISCONNECTED  = 0;
        int ROBOT_GALILEO       = 1;
        int ROBOT_KUBI          = 2;
        int ROBOT_ROMO          = 3;
        int ROBOT_GALILEOBT     = 4;
        int ROBOT_P360          = 5;
        int ROBOT_UNKNOWN       = 6;
    }

    interface PPRobotCommand {
        int MOVE_ALL    = 0;
        int MOVE_RIGHT  = 10;
        int MOVE_LEFT   = 20;
        int MOVE_UP     = 30;
        int MOVE_DOWN   = 40;
    }

    interface PPRobotCommandBitmask {
        int ROBOT_COMMAND_BITMASK_MOVE_RIGHT    = 0x1;
        int ROBOT_COMMAND_BITMASK_MOVE_LEFT     = 0x2;
        int ROBOT_COMMAND_BITMASK_MOVE_DOWN     = 0x3;
        int ROBOT_COMMAND_BITMASK_MOVE_UP       = 0x4;
    }

    interface P360HorizontalMotorStatus {
        int P360_HORIZONTAL_MOTOR_UNDEFINED                 = -1;
        int P360_HORIZONTAL_MOTOR_STOPPED                   = 0x0000;
        int P360_HORIZONTAL_MOTOR_ROTATING_CLOCKWISE        = 0x0001;
        int P360_HORIZONTAL_MOTOR_ROTATING_COUNTERCLOCKWISE = 0x0002;
        int P360_HORIZONTAL_MOTOR_CALIBRATING               = 0x0008;
    }

    interface P360VerticalMotorStatus {
        int P360_VERTICAL_MOTOR_UNDEFINED   = -1;
        int P360_VERTICAL_MOTOR_STOPPED     = 0x0000;
        int P360_VERTICAL_MOTOR_UPWARD      = 0x0001;
        int P360_VERTICAL_MOTOR_DOWNWARD    = 0x0002;
        int P360_VERTICAL_MOTOR_CALIBRATING = 0x0008;
    }

    interface P360Command {
        int P360_COMMAND_CLOCKWISE              = 0x63;
        int P360_COMMAND_CLOCKWISE_BIG          = 0x43;
        int P360_COMMAND_COUNTERCLOCKWISE       = 0x72;
        int P360_COMMAND_COUNTERCLOCKWISE_BIG   = 0x52;
        int P360_COMMAND_STOP_HORIZONTAL        = 0x68;
        int P360_COMMAND_UPWARD                 = 0x75;
        int P360_COMMAND_UPWARD_BIG             = 0x55;
        int P360_COMMAND_DOWNWARD               = 0x64;
        int P360_COMMAND_DOWNWARD_BIG           = 0x44;
        int P360_COMMAND_STOP_VERTICAL          = 0x76;
        int P360_COMMAND_CONTINUOUS_STEP        = 0x30;
        int P360_COMMAND_CONTINUOUS_INC         = 0x01;
        int P360_COMMAND_CALIBRATE              = 0x78;
        int P360_COMMAND_REBOOT_MOTOR           = 0x7A;
        int P360_COMMAND_RESET_COMMAND_QUEUE    = 0x71;
    }

    interface P360InitializationState {
        int P360_INITIALIZATION_STATE_CALIBRATE = -1;
        int P360_INITIALIZATION_STATE_READY     = 0;
        int P360_INITIALIZATION_STATE_RECENTER  = 1;
        int P360_INITIALIZATION_STATE_BOW_DOWN  = 2;
        int P360_INITIALIZATION_STATE_BOW_UP    = 3;
    }

    interface PPRobotConfigurationStatus {
        int ROBOT_CONFIGURATION_STATUS_READY                = 0;
        int ROBOT_CONFIGURATION_STATUS_CONFIGURE_VANTAGE    = 1;
    }
}
