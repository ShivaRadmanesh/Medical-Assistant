package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ObserveVisitController implements Initializable {
    public Visit v = GetVisitController.v;
    public Drug d = v.getDrugList().get(0);
    public Label conditionLabel;
    public Label diagnosisLabel;
    public Label paymentLabel;
    public Label visitDayLabel;
    public Label drugNameLabel;
    public Label dozLabel;
    public Label adviseLabel;
    public Label numberLabel;
    public Label timeLabel;

    public void initialize(URL location, ResourceBundle resources) {
        conditionLabel.setText(v.getCondition());
        diagnosisLabel.setText(v.getDiagnosis());
        paymentLabel.setText(String.valueOf(v.getPayment()));
        visitDayLabel.setText(v.getVisitDay());
        drugNameLabel.setText(d.getName());
        dozLabel.setText(String.valueOf(d.getDoz()));
        numberLabel.setText(String.valueOf(d.getNumber()));
        adviseLabel.setText(d.getAdvise());
        timeLabel.setText(d.getTime());
    }
    public void home(){
        if(LoginController.type){
            try{
                Pane pane = FXMLLoader.load(getClass().getResource("doctor.fxml"));
                Scene scene = new Scene(pane);
                Stage stage =(Stage) timeLabel.getScene().getWindow();
                stage.setScene(scene);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else{
            try{
                Pane pane = FXMLLoader.load(getClass().getResource("secretary.fxml"));
                Scene scene = new Scene(pane);
                Stage stage =(Stage) timeLabel.getScene().getWindow();
                stage.setScene(scene);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    public void back(){
        try{
            Pane pane = FXMLLoader.load(getClass().getResource("getVisit.fxml"));
            Scene scene = new Scene(pane);
            Stage stage =(Stage) timeLabel.getScene().getWindow();
            stage.setScene(scene);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
