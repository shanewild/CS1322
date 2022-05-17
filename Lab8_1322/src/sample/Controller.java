package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    public TextField TF2;
    public TextField TF1;
    public Label myLabel;

    public void add(ActionEvent actionEvent) {
        int i=Integer.parseInt(TF1.getText());
        int j=Integer.parseInt(TF2.getText());
        int x=i+j;
        myLabel.setText(String.valueOf(x));
    }
}
