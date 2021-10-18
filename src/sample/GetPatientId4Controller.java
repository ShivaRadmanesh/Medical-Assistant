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

public class GetPatientId4Controller implements Initializable{public Button searchButton;
    public Label notFoundLabel;
    public TextField idTextField;
    public Button homeButton;
    public Button backButton;
    public static Patient patient;
    public ImageView visitImage;
    public void initialize(URL location, ResourceBundle resources) {

        File visit = new File("image\\visitBack.jpg");
        Image vImage = new Image(visit.toURI().toString(),visitImage.getFitWidth(),visitImage.getFitHeight(),false,false);
        visitImage.setImage(vImage);


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

    public void newVisit(){
        String id = idTextField.getText();
        Patient p;
        int i;
        for(i = 0; i < Main.patientList.size(); i++){
            if(id.equals(Main.patientList.get(i).getId())){
                p = Main.patientList.get(i);
                patient = p;
                try{
                    Pane pane = FXMLLoader.load(getClass().getResource("newVisit.fxml"));
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
    public void eoVisit(){
        String id = idTextField.getText();
        Patient p;
        int i;
        for(i = 0; i < Main.patientList.size(); i++){
            if(id.equals(Main.patientList.get(i).getId())){
                p = Main.patientList.get(i);
                patient = p;
                try{
                    Pane pane = FXMLLoader.load(getClass().getResource("getVisit.fxml"));
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
}
