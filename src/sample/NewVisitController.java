package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class NewVisitController implements Initializable{
    public TextField paymentTextField;
    public TextField conditionTextField;
    public TextField diagnosisTextField;
    public DatePicker visitDay;
    public ComboBox<String> drugs;
    public Label fill;
    public Label numeric;
    public Label numeric2;
    public TextField adviseTextField;
    public TextField dozTextField;
    public TextField numberTextField;
    public TextField timeTextField;
    public Patient p = GetPatientId4Controller.patient;

    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < Main.drugList.size(); i++){
            list.add(Main.drugList.get(i).getName());
        }
        ObservableList<String> observableList = FXCollections.observableList(list);
        drugs .setItems(observableList);
        drugs.getSelectionModel().selectFirst();
    }
    public void save(){
        boolean readyToSave = true;
        if(paymentTextField.getText().trim().equals("") || conditionTextField.getText().trim().equals("")
                || diagnosisTextField.getText().trim().equals("") || visitDay.getValue() == null ) {
            readyToSave = false;
            fill.setVisible(true);
        }
        String advice = adviseTextField.getText();
        String time = timeTextField.getText();
        String condition = conditionTextField.getText();
        String diagnosis = diagnosisTextField.getText();
        double payment = 0;
        int doz = 0;
        int number = 0;
        try {
            payment = Double.parseDouble(paymentTextField.getText());

        }catch(Exception ex){
            if(!paymentTextField.getText().trim().equals("")) {
                numeric.setVisible(true);
                readyToSave = false;
            }
        }

            if(!dozTextField.getText().trim().equals("")) {
                try {
                    doz = Integer.parseInt(dozTextField.getText());
                } catch (Exception ex) {
                    numeric2.setVisible(true);
                    readyToSave = false;
                }
            }
        if(!numberTextField.getText().trim().equals(""))
        {
            try {
                number = Integer.parseInt(numberTextField.getText());
            }catch (Exception ex){
                numeric2.setVisible(true);
                readyToSave = false;
            }
        }
        LocalDate date = null;
        date = visitDay.getValue();

        String vDay = null;
        if(date != null) {
            vDay = visitDay.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        String drugName = drugs.getValue();
        Drug d = null;
        for(int i = 0; i < Main.drugList.size(); i++){
            if(drugName.equals(Main.drugList.get(i).getName()))
                d = copy(Main.drugList.get(i));
        }

        if(readyToSave){
            Visit v = new Visit(payment, vDay, diagnosis, condition);
            if(doz != 0) {
                d.setDoz(doz);
            }
            if(number != 0)
                d.setNumber(number);
            if(!adviseTextField.getText().trim().equals(""))
                d.setAdvise(advice);
            if(!timeTextField.getText().trim().equals(""))
                d.setTime(time);
            p.addVisitCost(v.getPayment());
            Save.patient(p);
            v.addDrug(d);
            p.addVisit(v);
            p.addVisitCost(v);
            Main.visitList.add(v);
            Save.visit(v, p);
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("saved.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) fill.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    private Drug copy(Drug first){
        Drug copy = new Drug(first.getName(),first.getAdvise(),first.getDoz(),first.getNumber(),first.getTime());
        return copy;
    }
    public void back(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("getPatientId4.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) fill.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void home(){
        if (LoginController.type) {
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("doctor.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) fill.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("secretary.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) fill.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
