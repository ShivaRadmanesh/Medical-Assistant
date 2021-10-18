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


public class SecretaryController implements Initializable {
    public Button patientButton;
    public Button visitButton;
    public Button exitButton;
    public ImageView patientImage;
    public ImageView visitImage;
    public ImageView backImage;
    public void initialize(URL location, ResourceBundle resources) {
        File back = new File("image\\back.jpg");
        Image bImage = new Image(back.toURI().toString(),backImage.getFitWidth(),backImage.getFitHeight(),false,false);
        backImage.setImage(bImage);

        File visit = new File("image\\visit.jpg");
        Image vImage = new Image(visit.toURI().toString(),visitImage.getFitWidth(),visitImage.getFitHeight(),false,false);
        visitImage.setImage(vImage);

        File patient = new File("image\\patient.jpg");
        Image pImage = new Image(patient.toURI().toString(),patientImage.getFitWidth(),patientImage.getFitHeight(),false,false);
        patientImage.setImage(pImage);
    }
    public void exit(){
        try{
            Pane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(pane);
            Stage stage =(Stage) exitButton.getScene().getWindow();
            stage.setScene(scene);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void patient(){
        try{
            Pane pane = FXMLLoader.load(getClass().getResource("patient.fxml"));
            Scene scene = new Scene(pane);
            Stage stage =(Stage) exitButton.getScene().getWindow();
            stage.setScene(scene);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void visit(){
        try{
            Pane pane = FXMLLoader.load(getClass().getResource("getPatientId4.fxml"));
            Scene scene = new Scene(pane);
            Stage stage =(Stage) exitButton.getScene().getWindow();
            stage.setScene(scene);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
