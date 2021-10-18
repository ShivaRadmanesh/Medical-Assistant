package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ObserveDrugController implements Initializable{
    public Label nameLabel;
    public Label dozLabel;
    public Label adviceLabel;
    public Label numberLabel;
    public Label timeLabel;
    public Button homeButton;
    Drug d = ChooseDrugController.d;
    public void initialize(URL location, ResourceBundle resources) {
        nameLabel.setText(d.getName());
        dozLabel.setText(String.valueOf(d.getDoz()));
        numberLabel.setText(String.valueOf(d.getNumber()));
        timeLabel.setText(d.getTime());
        adviceLabel.setText(d.getAdvise());
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
    public void back(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("chooseDrug.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) homeButton.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
