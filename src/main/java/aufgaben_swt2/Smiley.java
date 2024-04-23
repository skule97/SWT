package aufgaben_swt2;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Smiley extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    ImageView imageView= new ImageView();; // Variable für das ImageView-Objekt

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Jonas");
        TextField textField = new TextField();
        Button clickButton = new Button("Ändern");

        // Initialisierung des ImageView-Objekts


        clickButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String eingabe = textField.getText().toLowerCase();
                if (eingabe.equals("happy")) {
                    // Laden des Bildes aus einer Ressource
                    Image image = new Image(getClass().getResourceAsStream("/Images/pexels-kaboompics-com-6347(2).jpg"));
                    imageView.setImage(image);
                } else if (eingabe.equals("saddie")) {
                    Image image = new Image(getClass().getResourceAsStream("/Images/pexels-rebcenter-moscow-576494.jpg"));
                    imageView.setImage(image);
                }
                else {
                    imageView.setImage(null);
                }
            }
        });

        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        hBox1.getChildren().addAll(label, textField);
        hBox2.getChildren().addAll(clickButton, imageView); // Hinzufügen des ImageView zu hBox2
        VBox vBox = new VBox(hBox1, hBox2);
        Scene scene = new Scene(vBox, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Smiley");
        primaryStage.show();
    }
}

