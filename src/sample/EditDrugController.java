package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditDrugController implements Initializable {
    public TextField nameTextField;
    public TextField adviseTextField;
    public TextField dozTextField;
    public TextField numberTextField;
    public TextField timeTextField;
    public Label fillLabel;
    public Label numericLabel;
    Drug d = ChooseDrugController.d;
    public void initialize(URL location, ResourceBundle resources) {
       d = ChooseDrugController.d;
       nameTextField.setText(d.getName());
       adviseTextField.setText(d.getAdvise());
       dozTextField.setText(String.valueOf(d.getDoz()));
       numberTextField.setText(String.valueOf(d.getNumber()));
       timeTextField.setText(d.getTime());
    }

    public void home(){
        if (LoginController.type) {
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("doctor.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) fillLabel.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("secretary.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) fillLabel.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public void save(){
        boolean readyToSave = true;
        if (nameTextField.getText().trim().equals("") || adviseTextField.getText().trim().equals("")
                || dozTextField.getText().trim().equals("") || numberTextField.getText().trim().equals("") || timeTextField.getText().trim().equals("")) {
            readyToSave = false;
            fillLabel.setVisible(true);
        }
        String name = nameTextField.getText();
        String advise = adviseTextField.getText();
        String time = timeTextField.getText();
        int doz = 0;
        int number = 0;
        try {
            doz = Integer.parseInt(dozTextField.getText());
            number = Integer.parseInt(numberTextField.getText());
        } catch (Exception ex) {
            if (!dozTextField.getText().trim().equals("") || !numberTextField.getText().trim().equals("")) {
                numericLabel.setVisible(true);
            }
            readyToSave = false;
        }
        if(readyToSave) {
            if (!d.getName().equals(name)) {
                Save.rename("drug\\" + d.getName() + ".txt", "drug\\" + name + ".txt");
                Drug m = new Drug(name, advise, doz, number, time);
                Save.drug(m);
                for(int i = 0; i < Main.drugList.size(); i++){
                    if(d.equals(Main.drugList.get(i)))
                        Main.drugList.remove(i);
                }
                Main.drugList.add(m);
            }
            else{
                d.setAdvise(advise);
                d.setDoz(doz);
                d.setNumber(number);
                d.setTime(time);
                Save.drug(d);
            }
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("saved.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) fillLabel.getScene().getWindow();
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
            Stage stage = (Stage) fillLabel.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
