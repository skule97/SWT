module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.javafx to javafx.fxml;
    exports testing;
    exports aufgaben_swt2;
    exports aufgaben_swt2.aufgabe4;
    exports aufgaben_swt2.Aufgabe6;


}