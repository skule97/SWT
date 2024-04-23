package testing;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WorkProgressExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Erstellen einer ProgressBar zur Anzeige des Fortschritts
        ProgressBar progressBar = new ProgressBar();
        progressBar.setPrefWidth(200);

        // Erstellen eines Service zur Simulation einer asynchronen Aufgabe
        Service<Void> taskService = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws InterruptedException {
                        final int maxIterations = 10;
                        for (int i = 0; i < maxIterations; i++) {
                            // Simuliere die Durchführung von Arbeit
                            Thread.sleep(1000);
                            // Aktualisieren des Fortschritts
                            updateProgress(i + 1, maxIterations);
                        }
                        return null;
                    }
                };
            }
        };

        // Verbinden der ProgressBar mit dem Fortschritt des Tasks
        DoubleProperty progressProperty = new SimpleDoubleProperty();
        progressProperty.bind(taskService.progressProperty());
        progressBar.progressProperty().bind(progressProperty.divide(10.0)); // Wertebereich: [0, 1]

        // Starten des Service
        taskService.start();

        // Erstellen der Szene und Anzeige
        VBox root = new VBox(progressBar);
        Scene scene = new Scene(root, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Work Progress Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

