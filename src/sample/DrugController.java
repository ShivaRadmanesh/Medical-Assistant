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

public class DrugController implements Initializable {
    public Button homeButton;
    public ImageView drugImage;
    public void initialize(URL location, ResourceBundle resources) {

        File drug = new File("image\\drugBack.jpg");
        Image dImage = new Image(drug.toURI().toString(),drugImage.getFitWidth(),drugImage.getFitHeight(),false,false);
        drugImage.setImage(dImage);


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

   public void newDrug(){
       try{
           Pane pane = FXMLLoader.load(getClass().getResource("newDrug.fxml"));
           Scene scene = new Scene(pane);
           Stage stage =(Stage) homeButton.getScene().getWindow();
           stage.setScene(scene);
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
   public void eoDrug(){
       try{
           Pane pane = FXMLLoader.load(getClass().getResource("chooseDrug.fxml"));
           Scene scene = new Scene(pane);
           Stage stage =(Stage) homeButton.getScene().getWindow();
           stage.setScene(scene);
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }

}
