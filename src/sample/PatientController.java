package sample;


import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class PatientController implements Initializable{
    public Button homeButton;
    public ImageView patientImage;
    public void initialize(URL location, ResourceBundle resources) {
        File patient = new File("image\\patientBack.jpg");
        Image pImage = new Image(patient.toURI().toString(),patientImage.getFitWidth(),patientImage.getFitHeight(),false,false);
        patientImage.setImage(pImage);
    }
    public void home(){
        if (LoginController.type) {
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("doctor.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) homeButton.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("secretary.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) homeButton.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public void newPatient(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("newPatient.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) homeButton.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void observePatient(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("getPatientId2.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) homeButton.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void editPatient(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("getPatientId.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) homeButton.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
