package pferderennen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PferdeFX extends Application  {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {

        Button clickButton=new Button("Start");
        Image pferd1= new Image(getClass().getResourceAsStream("/Images/pexels-helena-lopes-1996333.jpg"));
        Image pferd2= new Image(getClass().getResourceAsStream("/Images/pexels-helena-lopes-1996333.jpg"));
        ImageView imageView1=new ImageView();
        ImageView imageView2=new ImageView();
        imageView1.setImage(pferd1);
        imageView2.setImage(pferd2);
        HBox hBox1= new HBox(imageView1);
        HBox hBox2= new HBox(imageView2);
        VBox vBox=new VBox(hBox1,hBox2,clickButton);

        Scene scene=new Scene(vBox,500,500);
        primaryStage.setScene(scene);
        primaryStage.show();






    }
}
