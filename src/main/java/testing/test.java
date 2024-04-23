package testing;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class test extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 300, 250);

        // MenuBar erzeugen und zu Pane hinzufügen
        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        pane.setTop(menuBar);

        // Datei Menu ‐ neu, speichern, beenden
        Menu dateiMenu = new Menu("Datei");
        MenuItem neuMenuItem = new MenuItem("Neu");
        MenuItem speichernMenuItem = new MenuItem("Speichern");
        MenuItem beendenMenuItem = new MenuItem("Beenden");
        beendenMenuItem.setOnAction(actionEvent -> Platform.exit());
        // Ereignisbehandlung
        dateiMenu.getItems().addAll(neuMenuItem, speichernMenuItem,
                new SeparatorMenuItem(), beendenMenuItem);

        // CheckItem Menu
        Menu guisMenu = new Menu("GUIs");
        CheckMenuItem swingMenuItem = new CheckMenuItem("Swing");
        swingMenuItem.setSelected(true);
        guisMenu.getItems().add(swingMenuItem);
        CheckMenuItem javafxMenuItem = new CheckMenuItem("JavaFX");
        javafxMenuItem.setSelected(true);
        guisMenu.getItems().add(javafxMenuItem);

        // RadioItem Menu
        Menu programmierungMenu = new Menu("Programmierung");
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioMenuItem prozeduralRadioMenuItem
                = new RadioMenuItem("Prozedural");
        prozeduralRadioMenuItem.setToggleGroup(toggleGroup);
        RadioMenuItem objektorientiertRadioMenuItem
                = new RadioMenuItem("Objektorientiert");
        objektorientiertRadioMenuItem.setToggleGroup(toggleGroup);
        objektorientiertRadioMenuItem.setSelected(true);
        programmierungMenu.getItems().addAll(prozeduralRadioMenuItem,
                objektorientiertRadioMenuItem, new SeparatorMenuItem());

        // Untermenu erzeugen
        Menu tutorialMenu = new Menu("Tutorial");
        tutorialMenu.getItems().addAll(
                new CheckMenuItem("Java"),
                new CheckMenuItem("JavaFX"),
                new CheckMenuItem("Swing"));

        // Event-Handler für das Tutorial-Menu
        tutorialMenu.setOnAction(event -> {
            MenuItem menuItem = (MenuItem) event.getTarget();
            System.out.println("Tutorial-Element ausgewählt: " + menuItem.getText());
        });

        programmierungMenu.getItems().add(tutorialMenu);

        // Menus zur MenuBar hinzufügen
        menuBar.getMenus().addAll(dateiMenu, guisMenu, programmierungMenu);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Menü Beispiel");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

