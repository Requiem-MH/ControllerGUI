import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.HashMap;

public class PS4Pane extends GridPane {
    Pane PS4FullPane = new Pane();
    Pane PS4FrontPane = new Pane();
    HashMap<String, Color> colors = new HashMap<>();
    Color buttonColor;

    public PS4Pane() {
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

        //PS4 front pic
        Image image1 = new Image("photos/PS4Front.png");
        ImageView ps4Front = new ImageView(image1);
        ps4Front.setFitWidth(750);
        ps4Front.setFitWidth(750);
        ps4Front.setPreserveRatio(true);
        PS4FrontPane.getChildren().add(ps4Front);
        add(PS4FrontPane, 1, 0);

        //PS4 full pic
        Image image2 = new Image("photos/PS4Full.png");
        ImageView ps4Full = new ImageView(image2);
        ps4Full.setFitHeight(750);
        ps4Full.setFitWidth(750);
        ps4Full.setPreserveRatio(true);
        PS4FullPane.getChildren().add(ps4Full);
        add(PS4FullPane, 1, 3);

        AddButtons();
        addRadioButtons();

        PS4FullPane.setOnMouseClicked(event -> {
            System.out.println("X: " + event.getX());
            System.out.println("Y: " + event.getY());
        });
    }

    private void AddButtons() {
        //x Button
        Circle aButton = new Circle(23, Color.TRANSPARENT);
        aButton.setCenterX(595);
        aButton.setCenterY(216);
        aButton.setOpacity(.4);
        Timeline aButtonTimeline = makeTimeline(aButton, Color.TRANSPARENT);
        aButton.addEventHandler(XboxEvent.A_BUTTON_EVENT, e -> {
            aButton.setFill(buttonColor);
            aButtonTimeline.playFromStart();
        });

        //Circle Button
        Circle bButton = new Circle(23, Color.TRANSPARENT);
        bButton.setCenterX(645);
        bButton.setCenterY(163);
        bButton.setOpacity(.4);
        Timeline bButtonTimeline = makeTimeline(bButton, Color.TRANSPARENT);
        bButton.addEventHandler(XboxEvent.B_BUTTON_EVENT, e -> {
            bButton.setFill(buttonColor);
            bButtonTimeline.playFromStart();
        });

        //Triangle Button
        Circle yButton = new Circle(23, Color.TRANSPARENT);
        yButton.setCenterX(592);
        yButton.setCenterY(113);
        yButton.setOpacity(.4);
        Timeline yButtonTimeline = makeTimeline(yButton, Color.TRANSPARENT);
        yButton.addEventHandler(XboxEvent.Y_BUTTON_EVENT, e -> {
            yButton.setFill(buttonColor);
            yButtonTimeline.playFromStart();
        });

        //Square Button
        Circle xButton = new Circle(23, Color.TRANSPARENT);
        xButton.setCenterX(542);
        xButton.setCenterY(166);
        xButton.setOpacity(.4);
        Timeline xButtonTimeline = makeTimeline(xButton, Color.TRANSPARENT);
        xButton.addEventHandler(XboxEvent.X_BUTTON_EVENT, e -> {
            xButton.setFill(buttonColor);
            xButtonTimeline.playFromStart();
        });

        //Dpad Up
        Path dPadUp = new Path(new MoveTo(163, 153),
                new LineTo(176, 140),
                new LineTo(176, 116),
                new LineTo(150, 116),
                new LineTo(149, 140),
                new ClosePath());
        dPadUp.setOpacity(.6);
        Timeline dUPTimeline = makeTimeline(dPadUp, Color.TRANSPARENT);
        dPadUp.addEventHandler(XboxEvent.DPAD_UP_BUTTON_EVENT, e -> {
            dPadUp.setFill(buttonColor);
            dUPTimeline.playFromStart();
        });

        //Dpad Down
        Path dPadDown = new Path(new MoveTo(163, 176),
                new LineTo(150, 187),
                new LineTo(148, 211),
                new LineTo(177, 211),
                new LineTo(175, 187),
                new ClosePath());
        dPadDown.setOpacity(.6);
        Timeline dDOWNTimeline = makeTimeline(dPadDown, Color.TRANSPARENT);
        dPadDown.addEventHandler(XboxEvent.DPAD_DOWN_BUTTON_EVENT, e -> {
            dPadDown.setFill(buttonColor);
            dDOWNTimeline.playFromStart();
        });

        //Dpad Right
        Path dPadRight = new Path(new MoveTo(173, 164),
                new LineTo(186, 152),
                new LineTo(210, 150),
                new LineTo(210, 178),
                new LineTo(186, 178),
                new ClosePath());
        dPadRight.setOpacity(.6);
        Timeline dRIGHTTimeline = makeTimeline(dPadRight, Color.TRANSPARENT);
        dPadRight.addEventHandler(XboxEvent.DPAD_RIGHT_BUTTON_EVENT, e -> {
            dPadRight.setFill(buttonColor);
            dRIGHTTimeline.playFromStart();
        });

        //Dpad Left
        Path dPadLeft = new Path(new MoveTo(152, 164),
                new LineTo(140, 152),
                new LineTo(116, 150),
                new LineTo(116, 178),
                new LineTo(140, 178),
                new ClosePath());
        dPadLeft.setOpacity(.6);
        Timeline dLEFTTimeline = makeTimeline(dPadLeft, Color.TRANSPARENT);
        dPadLeft.addEventHandler(XboxEvent.DPAD_LEFT_BUTTON_EVENT, e -> {
            dPadLeft.setFill(buttonColor);
            dLEFTTimeline.playFromStart();
        });

        Path startButton = new Path(new MoveTo(516, 82),
                new LineTo(511, 83),
                new LineTo(509, 90),
                new LineTo(509, 111),
                new LineTo(511, 115),
                new LineTo(516, 118),
                new LineTo(525, 115),
                new LineTo(528, 111),
                new LineTo(528, 90),
                new LineTo(523, 83),
                new ClosePath());
        startButton.setOpacity(.6);
        Timeline startTimeline = makeTimeline(startButton, Color.TRANSPARENT);
        startButton.addEventHandler(XboxEvent.START_BUTTON_EVENT, e -> {
            startButton.setFill(buttonColor);
            startTimeline.playFromStart();
        });

        Path selectButton = new Path(new MoveTo(237, 82),
                new LineTo(232, 83),
                new LineTo(230, 90),
                new LineTo(230, 111),
                new LineTo(232, 115),
                new LineTo(237, 118),
                new LineTo(246, 115),
                new LineTo(249, 111),
                new LineTo(249, 90),
                new LineTo(244, 83),
                new ClosePath());
        selectButton.setOpacity(.6);
        Timeline selectTimeline = makeTimeline(selectButton, Color.TRANSPARENT);
        selectButton.addEventHandler(XboxEvent.SELECT_BUTTON_EVENT, e ->  {
            selectButton.setFill(buttonColor);
            selectTimeline.playFromStart();
        });

        Path rightBumperFull = new Path(new MoveTo(632, 57),
                new LineTo(632, 47),
                new LineTo(613, 42),
                new LineTo(596, 40),
                new LineTo(578, 40),
                new LineTo(563, 42),
                new LineTo(539, 46),
                new LineTo(539, 56),
                new LineTo(549, 53),
                new LineTo(574, 52),
                new LineTo(600, 53),
                new LineTo(610, 52),
                new LineTo(625, 55),
                new ClosePath());
        rightBumperFull.setFill(Color.TRANSPARENT);
        rightBumperFull.setOpacity(.6);
        Timeline rbfTimeline = makeTimeline(rightBumperFull, Color.TRANSPARENT);

        Path rightBumper = new Path(new MoveTo(132, 135),
                new LineTo(146, 133),
                new LineTo(201, 133),
                new LineTo(222, 135),
                new LineTo(224, 124),
                new LineTo(219, 114),
                new LineTo(211, 107),
                new LineTo(198, 100),
                new LineTo(176, 99),
                new LineTo(153, 100),
                new LineTo(139, 107),
                new LineTo(131, 114),
                new LineTo(129, 124),
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

        Path leftBumperFull =  new Path(new MoveTo(218, 57),
                new LineTo(218, 47),
                new LineTo(199, 42),
                new LineTo(182, 40),
                new LineTo(164, 40),
                new LineTo(149, 42),
                new LineTo(125, 46),
                new LineTo(125, 56),
                new LineTo(135, 53),
                new LineTo(160, 52),
                new LineTo(186, 53),
                new LineTo(196, 52),
                new LineTo(211, 55),
                new ClosePath());
        leftBumperFull.setFill(Color.TRANSPARENT);
        leftBumperFull.setOpacity(.6);
        Timeline lbfTimeline = makeTimeline(leftBumperFull, Color.TRANSPARENT);

        Path leftBumper = new Path(new MoveTo(532, 135),
                new LineTo(546, 133),
                new LineTo(601, 133),
                new LineTo(622, 135),
                new LineTo(624, 124),
                new LineTo(619, 114),
                new LineTo(611, 107),
                new LineTo(598, 100),
                new LineTo(576, 99),
                new LineTo(553, 100),
                new LineTo(539, 109),
                new LineTo(532, 118),
                new LineTo(531, 124),
                new ClosePath());
        leftBumper.setOpacity(.6);
        Timeline lbTimeline = makeTimeline(leftBumper, Color.TRANSPARENT);
        leftBumper.addEventHandler(XboxEvent.LB_BUTTON_EVENT, e -> {
            leftBumperFull.setFill(buttonColor);
            leftBumper.setFill(buttonColor);
            lbfTimeline.playFromStart();
            lbTimeline.playFromStart();
        });

        Path rightTrigger = new Path(new MoveTo(135, 152),
                new LineTo(144, 181),
                new LineTo(152, 191),
                new LineTo(162, 197),
                new LineTo(172, 201),
                new LineTo(183, 200),
                new LineTo(193, 196),
                new LineTo(202, 190),
                new LineTo(206, 184),
                new LineTo(211, 172),
                new LineTo(217, 152),
                new LineTo(206, 150),
                new LineTo(192, 149),
                new LineTo(162, 149),
                new LineTo(147, 150),
                new ClosePath());
        rightTrigger.setFill(Color.TRANSPARENT);
        Timeline rtTimeline = makeTimeline(rightTrigger, Color.TRANSPARENT);
        rightTrigger.addEventHandler(XboxEvent.R_TRIGGER_EVENT, e -> {
            rightTrigger.setFill(buttonColor);
            rightTrigger.setOpacity(XboxEvent.rightTriggerMagnitude - .1);
            rtTimeline.playFromStart();
        });

        Path leftTrigger = new Path(new MoveTo(535, 152),
                new LineTo(544, 181),
                new LineTo(552, 191),
                new LineTo(562, 197),
                new LineTo(572, 201),
                new LineTo(583, 200),
                new LineTo(593, 196),
                new LineTo(602, 190),
                new LineTo(606, 184),
                new LineTo(611, 172),
                new LineTo(617, 152),
                new LineTo(606, 150),
                new LineTo(592, 149),
                new LineTo(562, 149),
                new LineTo(547, 150),
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
        rightTip.setCenterX(490);
        rightTip.setCenterY(255);
        rightTip.setOpacity(.8);

        Circle rightStick = new Circle(43, Color.TRANSPARENT);
        rightStick.setCenterX(490);
        rightStick.setCenterY(255);
        Timeline rStickClickTimeline = makeTimeline(rightStick, Color.TRANSPARENT);
        Timeline rStickTipTimeline = makeTimeline(rightTip, Color.TRANSPARENT);
        rightStick.addEventHandler(XboxEvent.RSTICK_BUTTON_EVENT, e -> {
            rightStick.setFill(buttonColor);
            rightStick.setOpacity(.6);
            rStickClickTimeline.playFromStart();
        });

        rightStick.addEventHandler(XboxEvent.R_JOYSTICK_EVENT, event -> {
            rightTip.setCenterX(490+54*XboxEvent.rightStickMagnitude*Math.cos(XboxEvent.rightStickAngle*(Math.PI/180)));
            rightTip.setCenterY(255+54*(-XboxEvent.rightStickMagnitude*Math.sin(XboxEvent.rightStickAngle*(Math.PI/180))));
            rightTip.setFill(colors.get("Joystick-Direction"));
            rStickTipTimeline.playFromStart();
        });

        //Left Stick
        Circle leftTip = new Circle(8, Color.TRANSPARENT);
        leftTip.setCenterX(267);
        leftTip.setCenterY(255);
        leftTip.setOpacity(.8);

        Circle leftStick = new Circle(43, Color.TRANSPARENT);
        leftStick.setCenterX(267);
        leftStick.setCenterY(255);
        Timeline lStickClickTimeline = makeTimeline(leftStick, Color.TRANSPARENT);
        Timeline lStickTipTimeline = makeTimeline(leftTip, Color.TRANSPARENT);
        leftStick.addEventHandler(XboxEvent.LSTICK_BUTTON_EVENT, e -> {
            leftStick.setFill(buttonColor);
            leftStick.setOpacity(.6);
            lStickClickTimeline.playFromStart();
        });

        leftStick.addEventHandler(XboxEvent.L_JOYSTICK_EVENT, event -> {
            leftTip.setCenterX(267+54*XboxEvent.leftStickMagnitude*Math.cos(XboxEvent.leftStickAngle*(Math.PI/180)));
            leftTip.setCenterY(255+54*(-XboxEvent.leftStickMagnitude*Math.sin(XboxEvent.leftStickAngle*(Math.PI/180))));
            leftTip.setFill(colors.get("Joystick-Direction"));
            lStickTipTimeline.playFromStart();
        });

        PS4FullPane.getChildren().addAll(aButton, bButton, yButton, xButton, rightStick, leftStick, dPadUp, dPadDown,
                dPadLeft, dPadRight, startButton, selectButton, rightTip, leftTip, leftBumperFull, rightBumperFull);
        PS4FrontPane.getChildren().addAll(rightBumper, leftBumper, rightTrigger, leftTrigger);
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

        Text title = new Text("     PS4 Controller Menu");
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

        Circle rsDeadZone = new Circle(47 * .1, Color.RED);
        rsDeadZone.setOpacity(.6);
        rsDeadZone.setCenterX(490);
        rsDeadZone.setCenterY(255);

        Circle lsDeadZone = new Circle(47 * .1, Color.RED);
        lsDeadZone.setOpacity(.6);
        lsDeadZone.setCenterX(267);
        lsDeadZone.setCenterY(255);

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

        PS4FullPane.getChildren().addAll(rsDeadZone, lsDeadZone);
        menu.getChildren().addAll(title, rbDefault, rbRed, rbBlue, rbGreen, rbYellow, rbPurple ,dzText, dzSlider, dzOff);
        add(menu, 2, 0);
    }

    private void changeColor(String color) { buttonColor = colors.get(color); }
}

