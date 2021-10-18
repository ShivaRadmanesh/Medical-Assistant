package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class GetPatientIdController implements Initializable {
    public Button searchButton;
    public Label notFoundLabel;
    public TextField idTextField;
    public Button homeButton;
    public Button backButton;
    public ImageView patientImage;
    public static Patient patient;
    public void initialize(URL location, ResourceBundle resources) {
        File patient = new File("image\\patientBack.jpg");
        Image pImage = new Image(patient.toURI().toString(),patientImage.getFitWidth(),patientImage.getFitHeight(),false,false);
        patientImage.setImage(pImage);
    }
    public void home(){
        if(LoginController.type){
            try{
                Pane pane = FXMLLoader.load(getClass().getResource("doctor.fxml"));
                Scene scene = new Scene(pane);
                Stage stage =(Stage) homeButton.getScene().getWindow();
                stage.setScene(scene);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else{
            try{
                Pane pane = FXMLLoader.load(getClass().getResource("secretary.fxml"));
                Scene scene = new Scene(pane);
                Stage stage =(Stage) homeButton.getScene().getWindow();
                stage.setScene(scene);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public void search(){
        String id = idTextField.getText();
        Patient p;
        int i;
        for(i = 0; i < Main.patientList.size(); i++){
            if(id.equals(Main.patientList.get(i).getId())){
                p = Main.patientList.get(i);
                patient = p;
                try{
                    Pane pane = FXMLLoader.load(getClass().getResource("editPatient.fxml"));
                    Scene scene = new Scene(pane);
                    Stage stage =(Stage) searchButton.getScene().getWindow();
                    stage.setScene(scene);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        if(i >= Main.patientList.size()){
            notFoundLabel.setVisible(true);
        }
    }
    public void back(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("patient.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) homeButton.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
