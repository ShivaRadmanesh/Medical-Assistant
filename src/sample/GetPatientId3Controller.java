package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GetPatientId3Controller {
    public Button searchButton;
    public Label notFoundLabel;
    public TextField idTextField;
    public Button homeButton;
    public Button backButton;
    public static Patient patient;
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
}
