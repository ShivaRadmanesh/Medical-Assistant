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

public class DoctorController implements Initializable {
    public Button exitButton;
    public Button visitButton;
    public Button patientButton;
    public Button drugButton;
    public Button reportButton;
    public ImageView drugImage;
    public ImageView reportImage;
    public ImageView patientImage;
    public ImageView visitImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File drug = new File("image\\drug.jpg");
        Image dImage = new Image(drug.toURI().toString(),drugImage.getFitWidth(),drugImage.getFitHeight(),false,false);
        drugImage.setImage(dImage);

        File visit = new File("image\\visit.jpg");
        Image vImage = new Image(visit.toURI().toString(),visitImage.getFitWidth(),visitImage.getFitHeight(),false,false);
        visitImage.setImage(vImage);

        File report = new File("image\\report.jpg");
        Image rImage = new Image(report.toURI().toString(),reportImage.getFitWidth(),reportImage.getFitHeight(),false,false);
        reportImage.setImage(rImage);

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
     public void drug(){
         try{
             Pane pane = FXMLLoader.load(getClass().getResource("drug.fxml"));
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
     public void report(){
         try{
             Pane pane = FXMLLoader.load(getClass().getResource("report.fxml"));
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
}
