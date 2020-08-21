import com.studiohartman.jamepad.ControllerManager;
import com.studiohartman.jamepad.ControllerState;
import javafx.event.EventType;

import java.util.ArrayList;

/**
 * Buttons: (Not Pressed) false - true (Pressed)
 *          (A, B, X, Y, Bumpers, Dpad, Start, Select, Guide, Control Stick Pushed)
 *
 * Trigger Values: (Not Pressed) 0 - 1 (Fully pressed).
 *
 * For Control Stick Values, its centered value will vary as not all controllers
 * have sticks that sit exactly in the middle. To prevent misreadings, a final
 * DEADZONE is implemented at .1.
 *
 * Control Sticks act as a coordinate plane.
 * Control Sticks X/Y Values: (Not Pressed) ( ~ 0, ~ 0)
 *                 (Fully Pressed) ( ~ -1/1, ~ -1/1)
 *                 When Testing, it was noticed that the control stick can read slight over 1.0.
 *                 This Values represents the control sticks' coordinate position on plane
 *
 * Control Sticks Magnitude: (Not Pressed) 0 - 1 (Fully Pressed)
 *                          This Value represents how are the control stick is pushed.
 *                          Will always be positive no matter what direction it is pushed in.
 *
 *
 * Control Sticks Angle: Rotating Clockwise (0, 180) - (-180, 0)
 *                       This Value represents the angle the control stick is at on the plane.
 *                       However, instead of reading from (0, 360), it reads (0, 180) then converts
 *                       to (-180, 0)
 */

public class ControllerManagement {
    ControllerManager controllers;
    static double DEADZONE = .1;

    ControllerManagement() {
            controllers = new ControllerManager();
            controllers.initSDLGamepad();
    }

    public ArrayList<EventType<XboxEvent>> getInput() {
        ArrayList<EventType<XboxEvent>> list = new ArrayList<>();
        //If no controller is present, It will terminate the program

        try {
            controllers.update();
            ControllerState currState = controllers.getState(0);

            if (!currState.isConnected) {
                terminate();
            }
            if (currState.a) {
                list.add(XboxEvent.A_BUTTON_EVENT);
            }
            if (currState.b) {
                list.add(XboxEvent.B_BUTTON_EVENT);
            }
            if (currState.x) {
                list.add(XboxEvent.X_BUTTON_EVENT);
            }
            if (currState.y) {
                list.add(XboxEvent.Y_BUTTON_EVENT);
            }
            if (currState.dpadUp) {
                list.add(XboxEvent.DPAD_UP_BUTTON_EVENT);
            }
            if (currState.dpadDown) {
                list.add(XboxEvent.DPAD_DOWN_BUTTON_EVENT);
            }
            if (currState.dpadLeft) {
                list.add(XboxEvent.DPAD_LEFT_BUTTON_EVENT);
            }
            if (currState.dpadRight) {
                list.add(XboxEvent.DPAD_RIGHT_BUTTON_EVENT);
            }
            if (currState.rightStickClick) {
                list.add(XboxEvent.RSTICK_BUTTON_EVENT);
            }
            if (currState.leftStickClick) {
                list.add(XboxEvent.LSTICK_BUTTON_EVENT);
            }
            if (currState.start) {
                list.add(XboxEvent.START_BUTTON_EVENT);
            }
            if (currState.back) {
                list.add(XboxEvent.SELECT_BUTTON_EVENT);
            }
            if (currState.rb) {
                list.add(XboxEvent.RB_BUTTON_EVENT);
            }
            if (currState.lb) {
                list.add(XboxEvent.LB_BUTTON_EVENT);
            }

            if (currState.leftTrigger > 0) {
                XboxEvent.leftTriggerMagnitude = currState.leftTrigger;
                list.add(XboxEvent.L_TRIGGER_EVENT);
            }

            if (currState.rightTrigger > 0) {
                XboxEvent.rightTriggerMagnitude = currState.rightTrigger;
                list.add(XboxEvent.R_TRIGGER_EVENT);
            }

            //Left Stick
            if (currState.leftStickMagnitude > DEADZONE) {
                if (currState.leftStickAngle < 0) {
                    XboxEvent.leftStickAngle = 360 + currState.leftStickAngle;
                } else {
                    XboxEvent.leftStickAngle = currState.leftStickAngle;
                }
                XboxEvent.leftStickX = currState.leftStickX;
                XboxEvent.leftStickY = currState.leftStickY;
                if (currState.leftStickMagnitude > 1) {
                    XboxEvent.leftTriggerMagnitude = 1;
                } else {
                    XboxEvent.leftStickMagnitude = currState.leftStickMagnitude;
                }
                list.add(XboxEvent.L_JOYSTICK_EVENT);
            }

            //Right Stick
            if (currState.rightStickMagnitude > DEADZONE) {
                if (currState.rightStickAngle < 0) {
                    XboxEvent.rightStickAngle = 360 + currState.rightStickAngle;
                } else {
                    XboxEvent.rightStickAngle = currState.rightStickAngle;
                }
                XboxEvent.rightStickX = currState.rightStickX;
                XboxEvent.rightStickY = currState.rightStickY;
                if (currState.rightStickMagnitude > 1) {
                    XboxEvent.rightStickMagnitude = 1;
                } else {
                    XboxEvent.rightStickMagnitude = currState.rightStickMagnitude;
                }
                list.add(XboxEvent.R_JOYSTICK_EVENT);
            }
        } catch (Exception a) {
            System.out.println("No Controller");
            System.exit(0);
        }

        return list;
    }

    private void terminate() {
        controllers.quitSDLGamepad();
    }
}

