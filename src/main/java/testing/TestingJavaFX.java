package testing;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TestingJavaFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Label clickLabel = new Label("0");
        Label textLabel = new Label("Anzahl Klicks: ");
        Button clickButton = new Button("Klick mich!");
        clickButton.setOnAction(new EventHandler() {
            @Override public void handle(Event event) {
                int counter = Integer.parseInt(clickLabel.getText());
                counter++;
                clickLabel.setText("" + counter);
            }
        });
        FlowPane pane = new FlowPane();
        pane.getChildren().addAll(clickButton, textLabel, clickLabel);
        Scene scene = new Scene(pane, 300, 50);
        primaryStage.setTitle("Klick‐Zähler");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
