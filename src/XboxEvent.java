import javafx.event.Event;
import javafx.event.EventType;

public class XboxEvent extends Event {
    public XboxEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

    public static double leftStickX = 0.0;
    public static double leftStickY = 0.0;
    public static double leftStickAngle = 0.0;
    public static double leftStickMagnitude = 0.0;

    public static double rightStickX = 0.0;
    public static double rightStickY = 0.0;
    public static double rightStickAngle = 0.0;
    public static double rightStickMagnitude = 0.0;

    public static double leftTriggerMagnitude = 0.0;
    public static double rightTriggerMagnitude = 0.0;

    // Event Types
    public static final EventType<XboxEvent> BUTTON_EVENT = new EventType<>(Event.ANY, "BUTTON_EVENT");
    public static final EventType<XboxEvent> JOYSTICK_EVENT = new EventType<>(Event.ANY, "JOYSTICK_EVENT");
    public static final EventType<XboxEvent> TRIGGER_EVENT = new EventType<>(Event.ANY, "TRIGGER_EVENT");
    public static final EventType<XboxEvent> NULL_EVENT = new EventType<>(Event.ANY, "NULL_EVENT");

    //Button Events
    public static final EventType<XboxEvent> A_BUTTON_EVENT = new EventType<>(BUTTON_EVENT, "A_BUTTON_EVENT");
    public static final EventType<XboxEvent> B_BUTTON_EVENT = new EventType<>(BUTTON_EVENT, "B_BUTTON_EVENT");
    public static final EventType<XboxEvent> X_BUTTON_EVENT = new EventType<>(BUTTON_EVENT, "X_BUTTON_EVENT");
    public static final EventType<XboxEvent> Y_BUTTON_EVENT = new EventType<>(BUTTON_EVENT, "Y_BUTTON_EVENT");
    public static final EventType<XboxEvent> RB_BUTTON_EVENT = new EventType<>(BUTTON_EVENT, "RB_BUTTON_EVENT");
    public static final EventType<XboxEvent> LB_BUTTON_EVENT = new EventType<>(BUTTON_EVENT, "LB_BUTTON_EVENT");
    public static final EventType<XboxEvent> LSTICK_BUTTON_EVENT = new EventType<>(BUTTON_EVENT, "LSTICK_BUTTON_EVENT"); // Event for left stick button press
    public static final EventType<XboxEvent> RSTICK_BUTTON_EVENT = new EventType<>(BUTTON_EVENT, "RSTICK_BUTTON_EVENT"); // Event for right stick button press
    public static final EventType<XboxEvent> SELECT_BUTTON_EVENT = new EventType<>(BUTTON_EVENT, "SELECT_BUTTON_EVENT");
    public static final EventType<XboxEvent> START_BUTTON_EVENT = new EventType<>(BUTTON_EVENT, "START_BUTTON_EVENT");
    public static final EventType<XboxEvent> DPAD_UP_BUTTON_EVENT = new EventType<>(BUTTON_EVENT, "DPAD_UP_BUTTON_EVENT");
    public static final EventType<XboxEvent> DPAD_DOWN_BUTTON_EVENT = new EventType<>(BUTTON_EVENT, "DPAD_DOWN_BUTTON_EVENT");
    public static final EventType<XboxEvent> DPAD_LEFT_BUTTON_EVENT = new EventType<>(BUTTON_EVENT, "DPAD_LEFT_BUTTON_EVENT");
    public static final EventType<XboxEvent> DPAD_RIGHT_BUTTON_EVENT = new EventType<>(BUTTON_EVENT, "DPAD_RIGHT_BUTTON_EVENT");

    //JoyStick Events
    public static final EventType<XboxEvent> L_JOYSTICK_EVENT = new EventType<>(JOYSTICK_EVENT, "L_JOYSTICK_EVENT");
    public static final EventType<XboxEvent> R_JOYSTICK_EVENT = new EventType<>(JOYSTICK_EVENT, "R_JOYSTICK_EVENT");

    //Trigger Events
    public static final EventType<XboxEvent> L_TRIGGER_EVENT = new EventType<>(TRIGGER_EVENT, "L_TRIGGER_EVENT");
    public static final EventType<XboxEvent> R_TRIGGER_EVENT = new EventType<>(TRIGGER_EVENT, "R_TRIGGER_EVENT");

}
