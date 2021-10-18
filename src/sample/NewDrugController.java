package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NewDrugController {
    public TextField nameTextField;
    public TextField adviseTextField;
    public TextField dozTextField;
    public TextField numberTextField;
    public TextField timeTextField;
    public Label fillLabel;
    public Label numericLabel;
    public void home(){
        if (LoginController.type) {
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("doctor.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) fillLabel.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("secretary.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) fillLabel.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public void save() {
        boolean readyToSave = true;
        if (nameTextField.getText().trim().equals("") || adviseTextField.getText().trim().equals("")
                || dozTextField.getText().trim().equals("") || numberTextField.getText().trim().equals("") || timeTextField.getText().trim().equals("")) {
            readyToSave = false;
            fillLabel.setVisible(true);
        }
        String name = nameTextField.getText();
        String advise = adviseTextField.getText();
        String time = timeTextField.getText();
        int doz = 0;
        int number = 0;
        try {
            doz = Integer.parseInt(dozTextField.getText());
            number = Integer.parseInt(numberTextField.getText());
        } catch (Exception ex) {
            if (!dozTextField.getText().trim().equals("") || !numberTextField.getText().trim().equals("")) {
                numericLabel.setVisible(true);
            }
            readyToSave = false;
        }
        if (readyToSave) {
            Drug d = new Drug(name, advise, doz, number, time);
            Save.drug(d);
            Main.drugList.add(d);
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("saved.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) fillLabel.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
    public void back(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("drug.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) fillLabel.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
