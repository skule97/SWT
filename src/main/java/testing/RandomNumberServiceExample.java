package testing;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberServiceExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Label zur Anzeige des Status des Service
        Label statusLabel = new Label("Status: Bereit");

        // Fortschrittsbalken zur Anzeige des Fortschritts der Aufgabe
        ProgressBar progressBar = new ProgressBar();
        progressBar.setPrefWidth(200);

        // Service zum Generieren zufälliger Zahlen
        Service<List<Integer>> randomNumberService = new Service<List<Integer>>() {
            @Override
            protected Task<List<Integer>> createTask() {
                return new Task<List<Integer>>() {
                    @Override
                    protected List<Integer> call() throws Exception {
                        // Initialisierung der Liste für die zufälligen Zahlen
                        List<Integer> randomNumbers = new ArrayList<>();
                        Random random = new Random();

                        // Simulieren der Erzeugung von zufälligen Zahlen
                        int totalNumbers = 100;
                        for (int i = 0; i < totalNumbers; i++) {
                            // Fügen Sie eine zufällige Zahl zwischen 1 und 100 hinzu
                            randomNumbers.add(random.nextInt(100) + 1);
                            // Aktualisieren des Fortschritts
                            updateProgress(i + 1, totalNumbers);
                            // Kurze Verzögerung, um die Simulation zu verlangsamen
                            Thread.sleep(1000);
                        }

                        return randomNumbers;
                    }
                };
            }
        };

        // Binden des Fortschrittsbalkens an den Fortschritt des Service
        progressBar.progressProperty().bind(randomNumberService.progressProperty());

        // Ereignisbehandler für die Beendigung der Aufgabe
        randomNumberService.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                // Status aktualisieren
                statusLabel.setText("Status: Abgeschlossen");
                // Ergebnis abrufen
                List<Integer> randomNumbers = randomNumberService.getValue();
                // Ausgabe der zufälligen Zahlen
                System.out.println("Zufällige Zahlen: " + randomNumbers);
            }
        });

        // Erstellen der Benutzeroberfläche
        VBox root = new VBox(10, statusLabel, progressBar);
        Scene scene = new Scene(root, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Random Number Service Example");
        primaryStage.show();

        // Starten des Service
        randomNumberService.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

