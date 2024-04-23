package aufgaben_swt2.aufgabe4;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

public class SmileyImageBinding extends ObjectBinding<Image> {

    private final TextField textField;

    public SmileyImageBinding(TextField textField) {
        this.textField = textField;
        bind(this.textField.textProperty());
    }


    @Override
    protected Image computeValue() {
        String eingabe = textField.getText().toLowerCase();
        if (eingabe.equals("happy")) {

            return new Image(getClass().getResourceAsStream("/Images/pexels-kaboompics-com-6347(2).jpg"));

        } else if (eingabe.equals("saddie")) {
           return new Image(getClass().getResourceAsStream("/Images/pexels-rebcenter-moscow-576494.jpg"));

        } else {
            return null;
        }

    }
}