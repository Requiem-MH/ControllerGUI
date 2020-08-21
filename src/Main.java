import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class Main extends Application {
    ArrayList<EventType<XboxEvent>> inputList;

    @Override
    public void start(Stage primaryStage) {
        BorderPane bPane = new BorderPane();
        bPane.setStyle("-fx-background-image: url('photos/xboxBackground.jpg')");
        //Start Reading from Controller
        ControllerManagement manager = new ControllerManagement();

        //Check for Xbox Controller
        if (manager.controllers.getState(0).controllerType.equals("XInput Controller")) {
            XboxPane xboxController = new XboxPane();
            bPane.setCenter(xboxController);
        }
        //Check for PS4 Controller
        else if (manager.controllers.getState(0).controllerType.equals("PS4 Controller")) {
            PS4Pane ps4Controller = new PS4Pane();
            bPane.setCenter(ps4Controller);
        }

        buildScene(bPane, primaryStage);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds((double) 1/100), e -> {
            inputList = manager.getInput();
            for (EventType<XboxEvent> event : inputList) {
                fireEventToAllChildrenOfPane(bPane, new XboxEvent(event));
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void buildScene(Pane pane, Stage primaryStage) {
        Scene scene = new Scene(pane,1050, 850);
        primaryStage.setTitle("Controller GUI"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    private void fireEventToAllChildrenOfPane(Pane pane, Event event) {
        for (Node node: pane.getChildren()) {
            if (node instanceof Pane) {
                fireEventToAllChildrenOfPane((Pane) node, event);
            }
            else {
                node.fireEvent(event);
            }
        }
    }
}
