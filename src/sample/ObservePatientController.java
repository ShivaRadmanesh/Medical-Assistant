package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ObservePatientController implements Initializable{
    public Label nameLabel;
    public Label fatherNameLabel;
    public Label idLabel;
    public Label ageLabel;
    public Label genderLabel;
    public Label insuranceLabel;
    public Label insuranceIdLabel;
    public Label expLabel;
    Patient p = GetPatientId2Controller.patient;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameLabel.setText(p.getName());
        fatherNameLabel.setText(p.getFatherName());
        idLabel.setText(p.getId());
        ageLabel.setText(String.valueOf(p.getAge()));
        genderLabel.setText(p.getGender());
        insuranceLabel.setText(p.getInsurance());
        insuranceIdLabel.setText(p.getInsuranceId());
        expLabel.setText(p.getExp());
    }

    public void home(){
        if (LoginController.type) {
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("doctor.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) expLabel.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("secretary.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) expLabel.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public void back(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("getPatientId2.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) expLabel.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
