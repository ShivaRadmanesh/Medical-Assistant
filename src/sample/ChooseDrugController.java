package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChooseDrugController implements Initializable {
    public ChoiceBox <String>drugs;
    public Label label;
    public static Drug d;
    public ImageView drugImage;

    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < Main.drugList.size(); i++){
            list.add(Main.drugList.get(i).getName());
        }
        ObservableList<String> observableList = FXCollections.observableList(list);
        drugs .setItems(observableList);
        drugs.getSelectionModel().selectFirst();
        File drug = new File("image\\drugBack.jpg");
        Image dImage = new Image(drug.toURI().toString(),drugImage.getFitWidth(),drugImage.getFitHeight(),false,false);
        drugImage.setImage(dImage);

    }

    public void edit(){

            String name = drugs.getValue();
            for(int i = 0; i < Main.drugList.size(); i++){
                if(name.equals(Main.drugList.get(i).getName()))
                    d = Main.drugList.get(i);
            }
            try{
                Pane pane = FXMLLoader.load(getClass().getResource("editDrug.fxml"));
                Scene scene = new Scene(pane);
                Stage stage =(Stage) drugImage.getScene().getWindow();
                stage.setScene(scene);
            }catch(Exception ex){
                ex.printStackTrace();
            }

    }
    public void observe(){

            String name = drugs.getValue();
            for(int i = 0; i < Main.drugList.size(); i++){
                if(name.equals(Main.drugList.get(i).getName()))
                    d = Main.drugList.get(i);
            }
            try{
                Pane pane = FXMLLoader.load(getClass().getResource("observeDrug.fxml"));
                Scene scene = new Scene(pane);
                Stage stage =(Stage) drugImage.getScene().getWindow();
                stage.setScene(scene);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    public void back(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("drug.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) drugImage.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
