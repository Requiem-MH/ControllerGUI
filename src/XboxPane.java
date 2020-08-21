import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.HashMap;

public class XboxPane extends GridPane {
    Pane xboxFullPane = new Pane();
    Pane xboxFrontPane = new Pane();
    HashMap<String, Color> colors = new HashMap<>();
    Color buttonColor;


    public XboxPane() {
        // setup colors HashMap
        colors.put("Default", Color.TRANSPARENT);
        colors.put("GREEN", Color.GREEN);
        colors.put("RED", Color.RED);
        colors.put("BLUE", Color.BLUE);
        colors.put("YELLOW", Color.YELLOW);
        colors.put("PURPLE", Color.MEDIUMPURPLE);
        colors.put("TEAL", Color.TEAL);
        colors.put("Joystick-Direction", Color.TEAL.deriveColor(10, 9, 100, .9));

        buttonColor = colors.get("TEAL");

        //Xbox front pic
        Image imaage1 = new Image("photos/XboxFront.png");
        ImageView xboxFront = new ImageView(imaage1);
        xboxFront.setFitHeight(750);
        xboxFront.setFitWidth(750);
        xboxFront.setPreserveRatio(true);
        xboxFrontPane.getChildren().add(xboxFront);
        add(xboxFrontPane, 1, 0);

        //Xbox full pic
        Image image2 = new Image("photos/XboxFull.png");
        ImageView xboxFull = new ImageView(image2);
        xboxFull.setFitHeight(750);
        xboxFull.setFitWidth(750);
        xboxFull.setPreserveRatio(true);
        xboxFullPane.getChildren().add(xboxFull);
        add(xboxFullPane, 1, 3);

        AddButtons();
        addRadioButtons();

    }

    private void AddButtons() {
        //A Button
        Circle aButton = new Circle(24, Color.TRANSPARENT);
        aButton.setCenterX(576);
        aButton.setCenterY(214);
        aButton.setOpacity(.4);
        Timeline aButtonTimeline = makeTimeline(aButton, Color.TRANSPARENT);
        aButton.addEventHandler(XboxEvent.A_BUTTON_EVENT, e -> {
            aButton.setFill(buttonColor);
            aButtonTimeline.playFromStart();
        });

        //B Button
        Circle bButton = new Circle(24, Color.TRANSPARENT);
        bButton.setCenterX(628);
        bButton.setCenterY(158);
        bButton.setOpacity(.4);
        Timeline bButtonTimeline = makeTimeline(bButton, Color.TRANSPARENT);
        bButton.addEventHandler(XboxEvent.B_BUTTON_EVENT, e -> {
            bButton.setFill(buttonColor);
            bButtonTimeline.playFromStart();
        });

        //Y Button
        Circle yButton = new Circle(24, Color.TRANSPARENT);
        yButton.setCenterX(576);
        yButton.setCenterY(104);
        yButton.setOpacity(.4);
        Timeline yButtonTimeline = makeTimeline(yButton, Color.TRANSPARENT);
        yButton.addEventHandler(XboxEvent.Y_BUTTON_EVENT, e -> {
            yButton.setFill(buttonColor);
            yButtonTimeline.playFromStart();
        });

        //X Button
        Circle xButton = new Circle(24, Color.TRANSPARENT);
        xButton.setCenterX(523);
        xButton.setCenterY(158);
        xButton.setOpacity(.4);
        Timeline xButtonTimeline = makeTimeline(xButton, Color.TRANSPARENT);
        xButton.addEventHandler(XboxEvent.X_BUTTON_EVENT, e -> {
            xButton.setFill(buttonColor);
            xButtonTimeline.playFromStart();
        });

        //Dpad Up
        Rectangle dPadUp = new Rectangle(32, 33, Color.TRANSPARENT);
        dPadUp.setX(266);
        dPadUp.setY(238);
        dPadUp.setOpacity(.6);
        Timeline dUPTimeline = makeTimeline(dPadUp, Color.TRANSPARENT);
        dPadUp.addEventHandler(XboxEvent.DPAD_UP_BUTTON_EVENT, e -> {
            dPadUp.setFill(buttonColor);
            dUPTimeline.playFromStart();
        });

        //Dpad Down
        Rectangle dPadDown = new Rectangle(32, 33, Color.TRANSPARENT);
        dPadDown.setX(266);
        dPadDown.setY(305);
        dPadDown.setOpacity(.6);
        Timeline dDOWNTimeline = makeTimeline(dPadDown, Color.TRANSPARENT);
        dPadDown.addEventHandler(XboxEvent.DPAD_DOWN_BUTTON_EVENT, e -> {
            dPadDown.setFill(buttonColor);
            dDOWNTimeline.playFromStart();
        });

        //Dpad Right
        Rectangle dPadRight = new Rectangle(32, 33, Color.TRANSPARENT);
        dPadRight.setX(300);
        dPadRight.setY(271);
        dPadRight.setOpacity(.6);
        Timeline dRIGHTTimeline = makeTimeline(dPadRight, Color.TRANSPARENT);
        dPadRight.addEventHandler(XboxEvent.DPAD_RIGHT_BUTTON_EVENT, e -> {
            dPadRight.setFill(buttonColor);
            dRIGHTTimeline.playFromStart();
        });

        //Dpad Left
        Rectangle dPadLeft = new Rectangle(32, 33, Color.TRANSPARENT);
        dPadLeft.setX(231);
        dPadLeft.setY(271);
        dPadLeft.setOpacity(.6);
        Timeline dLEFTTimeline = makeTimeline(dPadLeft, Color.TRANSPARENT);
        dPadLeft.addEventHandler(XboxEvent.DPAD_LEFT_BUTTON_EVENT, e -> {
            dPadLeft.setFill(buttonColor);
            dLEFTTimeline.playFromStart();
        });


        Ellipse startButton = new Ellipse();
        startButton.setCenterX(426);
        startButton.setCenterY(166);
        startButton.setRadiusX(18);
        startButton.setRadiusY(14);
        startButton.setFill(Color.TRANSPARENT);
        startButton.setOpacity(.6);
        Timeline startTimeline = makeTimeline(startButton, Color.TRANSPARENT);
        startButton.addEventHandler(XboxEvent.START_BUTTON_EVENT, e -> {
            startButton.setFill(buttonColor);
            startTimeline.playFromStart();
        });

        Ellipse selectButton = new Ellipse();
        selectButton.setCenterX(320);
        selectButton.setCenterY(166);
        selectButton.setRadiusX(18);
        selectButton.setRadiusY(14);
        selectButton.setFill(Color.TRANSPARENT);
        selectButton.setOpacity(.6);
        Timeline selectTimeline = makeTimeline(selectButton, Color.TRANSPARENT);
        selectButton.addEventHandler(XboxEvent.SELECT_BUTTON_EVENT, e ->  {
            selectButton.setFill(buttonColor);
            selectTimeline.playFromStart();
        });

        Path rightBumperFull = new Path(new MoveTo(476, 86),
                new LineTo(468, 45),
                new LineTo(504, 21),
                new LineTo(558, 28),
                new LineTo(590, 35),
                new LineTo(625, 54),
                new LineTo(624, 74),
                new LineTo(560, 57),
                new LineTo(506, 47),
                new ClosePath());
        rightBumperFull.setFill(Color.TRANSPARENT);
        rightBumperFull.setOpacity(.6);
        Timeline rbfTimeline = makeTimeline(rightBumperFull, Color.TRANSPARENT);

        Path rightBumper = new Path(new MoveTo(145, 134),
                new LineTo(210, 134),
                new LineTo(213, 124),
                new LineTo(253, 121),
                new LineTo(256, 92),
                new LineTo(170, 96),
                new LineTo(158, 101),
                new LineTo(151, 112),
                new ClosePath());
        rightBumper.setFill(Color.TRANSPARENT);
        rightBumper.setOpacity(.6);
        Timeline rbTimeline = makeTimeline(rightBumper, Color.TRANSPARENT);
        rightBumper.addEventHandler(XboxEvent.RB_BUTTON_EVENT, e -> {
            rightBumperFull.setFill(buttonColor);
            rightBumper.setFill(buttonColor);
            rbfTimeline.playFromStart();
            rbTimeline.playFromStart();
        });

        Path leftBumperFull = new Path(new MoveTo(122, 75),
                new LineTo(122, 53),
                new LineTo(140, 42),
                new LineTo(179, 31),
                new LineTo(226, 23),
                new LineTo(244, 21),
                new LineTo(281, 45),
                new LineTo(272, 89),
                new LineTo(240, 47),
                new LineTo(180, 58),
                new ClosePath());
        leftBumperFull.setFill(Color.TRANSPARENT);
        leftBumperFull.setOpacity(.6);
        Timeline lbfTimeline = makeTimeline(leftBumperFull, Color.TRANSPARENT);

        Path leftBumper = new Path(new MoveTo(607, 134),
                new LineTo(542, 134),
                new LineTo(540, 125),
                new LineTo(500, 121),
                new LineTo(497, 92),
                new LineTo(581, 96),
                new LineTo(592, 101),
                new LineTo(601, 112),
                new ClosePath());
        leftBumper.setFill(Color.TRANSPARENT);
        leftBumper.setOpacity(.6);
        Timeline lbTimeline = makeTimeline(leftBumper, Color.TRANSPARENT);
        leftBumper.addEventHandler(XboxEvent.LB_BUTTON_EVENT, e -> {
            leftBumperFull.setFill(buttonColor);
            leftBumper.setFill(buttonColor);
            lbfTimeline.playFromStart();
            lbTimeline.playFromStart();
        });

        Path rightTrigger = new Path(new MoveTo(149, 139),
                new LineTo(233, 139),
                new LineTo(235, 166),
                new LineTo(232, 196),
                new LineTo(228, 211),
                new LineTo(224, 223),
                new LineTo(216, 236),
                new LineTo(204, 243),
                new LineTo(184, 242),
                new LineTo(175, 238),
                new LineTo(168, 228),
                new LineTo(156, 202),
                new LineTo(149, 169),
                new ClosePath());
        rightTrigger.setFill(Color.TRANSPARENT);
        Timeline rtTimeline = makeTimeline(rightTrigger, Color.TRANSPARENT);
        rightTrigger.addEventHandler(XboxEvent.R_TRIGGER_EVENT, e -> {
            rightTrigger.setFill(buttonColor);
            rightTrigger.setOpacity(XboxEvent.rightTriggerMagnitude - .1);
            rtTimeline.playFromStart();
        });

        Path leftTrigger = new Path(new MoveTo(603, 139),
                new LineTo(518, 139),
                new LineTo(519, 166),
                new LineTo(522, 196),
                new LineTo(526, 211),
                new LineTo(528, 223),
                new LineTo(536, 236),
                new LineTo(549, 243),
                new LineTo(571, 242),
                new LineTo(576, 238),
                new LineTo(587, 228),
                new LineTo(597, 202),
                new LineTo(604, 169),
                new ClosePath());
        leftTrigger.setFill(Color.TRANSPARENT);
        Timeline ltTimeline = makeTimeline(leftTrigger, Color.TRANSPARENT);
        leftTrigger.addEventHandler(XboxEvent.L_TRIGGER_EVENT, e -> {
            leftTrigger.setFill(buttonColor);
            leftTrigger.setOpacity(XboxEvent.leftTriggerMagnitude - .1);
            ltTimeline.playFromStart();
        });

        //Right Stick
        Circle rightTip = new Circle(8, Color.TRANSPARENT);
        rightTip.setCenterX(465);
        rightTip.setCenterY(277);
        rightTip.setOpacity(.8);

        Circle rightStick = new Circle(47, Color.TRANSPARENT);
        rightStick.setCenterX(465);
        rightStick.setCenterY(277);
        Timeline rStickClickTimeline = makeTimeline(rightStick, Color.TRANSPARENT);
        Timeline rStickTipTimeline = makeTimeline(rightTip, Color.TRANSPARENT);
        rightStick.addEventHandler(XboxEvent.RSTICK_BUTTON_EVENT, e -> {
            rightStick.setFill(buttonColor);
            rightStick.setOpacity(.6);
            rStickClickTimeline.playFromStart();
        });

        rightStick.addEventHandler(XboxEvent.R_JOYSTICK_EVENT, event -> {
            rightTip.setCenterX(465+56*XboxEvent.rightStickMagnitude*Math.cos(XboxEvent.rightStickAngle*(Math.PI/180)));
            rightTip.setCenterY(277+56*(-XboxEvent.rightStickMagnitude*Math.sin(XboxEvent.rightStickAngle*(Math.PI/180))));
            rightTip.setFill(colors.get("Joystick-Direction"));
            rStickTipTimeline.playFromStart();
        });

        //Left Stick
        Circle leftTip = new Circle(8, Color.TRANSPARENT);
        leftTip.setCenterX(191);
        leftTip.setCenterY(167);
        leftTip.setOpacity(.8);

        Circle leftStick = new Circle(49, Color.TRANSPARENT);
        leftStick.setCenterX(191);
        leftStick.setCenterY(167);
        Timeline lStickClickTimeline = makeTimeline(leftStick, Color.TRANSPARENT);
        Timeline lStickTipTimeline = makeTimeline(leftTip, Color.TRANSPARENT);
        leftStick.addEventHandler(XboxEvent.LSTICK_BUTTON_EVENT, e -> {
            leftStick.setFill(buttonColor);
            leftStick.setOpacity(.6);
            lStickClickTimeline.playFromStart();
        });

        leftStick.addEventHandler(XboxEvent.L_JOYSTICK_EVENT, event -> {
            leftTip.setCenterX(191+59*XboxEvent.leftStickMagnitude*Math.cos(XboxEvent.leftStickAngle*(Math.PI/180)));
            leftTip.setCenterY(167+59*(-XboxEvent.leftStickMagnitude*Math.sin(XboxEvent.leftStickAngle*(Math.PI/180))));
            leftTip.setFill(colors.get("Joystick-Direction"));
            lStickTipTimeline.playFromStart();
        });

        xboxFullPane.getChildren().addAll(aButton, bButton, yButton, xButton, rightStick, leftStick, dPadUp, dPadDown,
                dPadLeft, dPadRight, startButton, selectButton, rightTip, leftTip, leftBumperFull, rightBumperFull);

        xboxFrontPane.getChildren().addAll(rightBumper, leftBumper, rightTrigger, leftTrigger);
    }

    Timeline makeTimeline(Shape shape, Color endCol) {
        Timeline tl = new Timeline();
        tl.getKeyFrames().add(new KeyFrame(Duration.seconds((double) 1/20), e -> shape.setFill(endCol)));
        return tl;
    }

    //Buttons on the right of the GUI that control the colors of the buttons when activated as well as adding in a deadzone slider,

    public void addRadioButtons() {
        VBox menu = new VBox();
        ToggleGroup group = new ToggleGroup();

        Text title = new Text("     Xbox Controller Menu");
        title.setFont(Font.font ("Verdana", 20));
        title.setFill(Color.WHITE);

        RadioButton rbDefault = new RadioButton("Teal");
        rbDefault.setStyle("-fx-text-fill: white;");
        rbDefault.setToggleGroup(group);
        rbDefault.setOnAction( event -> {
            if (rbDefault.isSelected()) {
                changeColor("TEAL");
            }
        });

        RadioButton rbRed = new RadioButton("Red");
        rbRed.setStyle("-fx-text-fill: white;");
        rbRed.setToggleGroup(group);
        rbRed.setOnAction( event -> {
            if (rbRed.isSelected()) {
                changeColor("RED");
            }
        });

        RadioButton rbBlue = new RadioButton("Blue");
        rbBlue.setStyle("-fx-text-fill: white;");
        rbBlue.setToggleGroup(group);
        rbBlue.setOnAction( event -> {
            if (rbBlue.isSelected()) {
                changeColor("BLUE");
            }
        });

        RadioButton rbGreen = new RadioButton("Green");
        rbGreen.setStyle("-fx-text-fill: white;");
        rbGreen.setToggleGroup(group);
        rbGreen.setOnAction( event -> {
            if (rbGreen.isSelected()) {
                changeColor("GREEN");
            }
        });

        RadioButton rbYellow = new RadioButton("Yellow");
        rbYellow.setStyle("-fx-text-fill: white;");
        rbYellow.setToggleGroup(group);
        rbYellow.setOnAction( event -> {
            if (rbYellow.isSelected()) {
                changeColor("YELLOW");
            }
        });

        RadioButton rbPurple = new RadioButton("Purple");
        rbPurple.setStyle("-fx-text-fill: white;");
        rbPurple.setToggleGroup(group);
        rbPurple.setOnAction( event -> {
            if (rbPurple.isSelected()) {
                changeColor("PURPLE");
            }
        });

        Text dzText = new Text("Dead Zone");
        dzText.setFill(Color.WHITE);

        Circle rsDeadZone = new Circle(47 * .1, Color.WHITE);
        rsDeadZone.setOpacity(.6);
        rsDeadZone.setCenterX(465);
        rsDeadZone.setCenterY(277);

        Circle lsDeadZone = new Circle(47 * .1, Color.WHITE);
        lsDeadZone.setOpacity(.6);
        lsDeadZone.setCenterX(191);
        lsDeadZone.setCenterY(167);

        Slider dzSlider = new Slider();
        dzSlider.setMin(0);
        dzSlider.setMax(1);
        dzSlider.setValue(.1);
        dzSlider.setShowTickMarks(true);
        dzSlider.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    ControllerManagement.DEADZONE = (double) newValue;
                    rsDeadZone.setRadius(ControllerManagement.DEADZONE * 47);
                    lsDeadZone.setRadius(ControllerManagement.DEADZONE * 47);
                });

        CheckBox dzOff = new CheckBox("Dead Zone Off");
        dzOff.setStyle("-fx-text-fill: white;");
        dzOff.setSelected(false);
        dzOff.setOnAction( event -> {
            if(dzOff.isSelected()){
                rsDeadZone.setOpacity(0);
                lsDeadZone.setOpacity(0);
                dzSlider.setValue(.1);
            }
            else{
                rsDeadZone.setOpacity(.6);
                lsDeadZone.setOpacity(.6);
            }
        });

        xboxFullPane.getChildren().addAll(rsDeadZone, lsDeadZone);

        menu.getChildren().addAll(title, rbDefault, rbRed, rbBlue, rbGreen, rbYellow, rbPurple ,dzText, dzSlider, dzOff);
        add(menu, 2, 0);
    }

    private void changeColor(String color) { buttonColor = colors.get(color); }
}
