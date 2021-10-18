package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class GetVisitController implements Initializable {
    public ChoiceBox<String> visits;
    public Label label;
    public static Visit v;
    public ImageView visitImage;
    public Button observe;
    public Button edit;
    Patient p = GetPatientId4Controller.patient;

    public void initialize(URL location, ResourceBundle resources) {
        File visit = new File("image\\visitBack.jpg");
        Image vImage = new Image(visit.toURI().toString(),visitImage.getFitWidth(),visitImage.getFitHeight(),false,false);
        visitImage.setImage(vImage);
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < p.getVisitList().size(); i++){
            list.add(p.getVisitList().get(i).getVisitDay());
        }
        ObservableList<String> observableList = FXCollections.observableList(list);
        if(list.size() > 0) {
            visits.setItems(observableList);
            visits.getSelectionModel().selectFirst();
        }
        else {
            label.setVisible(true);
            edit.setVisible(false);
            observe.setVisible(false);
        }
    }

    public void edit() {

        String name = visits.getValue();
        for (int i = 0; i < p.getVisitList().size(); i++) {
            if (name.equals(p.getVisitList().get(i).getVisitDay()))
                v = p.getVisitList().get(i);
        }
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("editVisit.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) visits.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

    }
        public void observe () {

            String name = visits.getValue();
            for (int i = 0; i < p.getVisitList().size(); i++) {
                if (name.equals(p.getVisitList().get(i).getVisitDay()))
                    v = p.getVisitList().get(i);
            }
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("observeVisit.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) label.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        public void back(){
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("getPatientId4.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) label.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    public void home(){
        if(LoginController.type){
            try{
                Pane pane = FXMLLoader.load(getClass().getResource("doctor.fxml"));
                Scene scene = new Scene(pane);
                Stage stage =(Stage) label.getScene().getWindow();
                stage.setScene(scene);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else{
            try{
                Pane pane = FXMLLoader.load(getClass().getResource("secretary.fxml"));
                Scene scene = new Scene(pane);
                Stage stage =(Stage) label.getScene().getWindow();
                stage.setScene(scene);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    }

