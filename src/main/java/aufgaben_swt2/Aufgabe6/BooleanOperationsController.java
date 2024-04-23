package aufgaben_swt2.Aufgabe6;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class BooleanOperationsController {

    // Instanzvariablen für die Checkboxen der Eingänge und Ausgänge
    @FXML
    private CheckBox e1;

    @FXML
    private CheckBox e2;

    @FXML
    private CheckBox and;

    @FXML
    private CheckBox or;

    @FXML
    private CheckBox not;

    // Methode, um die UND-Operation auszuführen
    @FXML
    private void performAndOperation() {
        and.setSelected(e1.isSelected() && e2.isSelected());
    }

    // Methode, um die ODER-Operation auszuführen
    @FXML
    private void performOrOperation() {
        or.setSelected(e1.isSelected() || e2.isSelected());
    }

    // Methode, um die NICHT-Operation auszuführen
    @FXML
    private void performNotOperation() {
        not.setSelected(!e1.isSelected()||!e2.isSelected());
    }
}
