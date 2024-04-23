package aufgaben_swt2.Aufgabe6;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.CheckListView;

public class Main extends Application {
    public static void main (String[]args){launch(args);    }

    @Override
    public void start (Stage s) throws Exception{
        //input
        CheckBox e1= new CheckBox("Eingang1");
        CheckBox e2=new CheckBox("Eingang2");
        //output
        CheckBox and=new CheckBox("UND");
        CheckBox or= new CheckBox("ODER");
        CheckBox notEinang1=new CheckBox("NICHT Eingang 1");
        CheckBox notEingang2=new CheckBox("NICHT Eingang 2");
        and.setDisable(true);
        or.setDisable(true);
        notEinang1.setDisable(true);
        notEingang2.setDisable(true);

        and.selectedProperty().bind(Bindings.and(e1.selectedProperty(), e2.selectedProperty()));
        or.selectedProperty().bind(Bindings.or(e1.selectedProperty(), e2.selectedProperty()));
        notEinang1.selectedProperty().bind(e1.selectedProperty().not());
        notEingang2.selectedProperty().bind(e2.selectedProperty().not());

        VBox root= new VBox(10);
        root.getChildren().addAll(e1,e2,and,or,notEinang1, notEingang2);

        Scene scene=new Scene(root,200,200);
        s.setScene(scene);
        s.setTitle("BooleanOperations");
        s.show();

    }
}
