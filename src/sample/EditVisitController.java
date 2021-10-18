package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.MissingFormatArgumentException;
import java.util.ResourceBundle;


public class EditVisitController implements Initializable {
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
    public Label visitDayLabel;
    public Patient p = GetPatientId4Controller.patient;
    public Visit v = GetVisitController.v;
    public Drug d = v.getDrugList().get(0);

    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> list = new ArrayList<String>();
        int chosenDrug = 0;
        for(int i = 0; i < Main.drugList.size(); i++){
            list.add(Main.drugList.get(i).getName());
            if(Main.drugList.get(i).getName().equals(d.getName()))
                chosenDrug = i;
        }
        ObservableList<String> observableList = FXCollections.observableList(list);
        drugs .setItems(observableList);
        drugs.getSelectionModel().select(chosenDrug);
        paymentTextField.setText(String.valueOf(v.getPayment()));
        conditionTextField.setText(v.getCondition());
        diagnosisTextField.setText(v.getDiagnosis());
        adviseTextField.setText(d.getAdvise());
        dozTextField.setText(String.valueOf(d.getDoz()));
        numberTextField.setText(String.valueOf(d.getNumber()));
        timeTextField.setText(d.getTime());
        visitDayLabel.setText(v.getVisitDay());
    }
    public void save(){
        boolean readyToSave = true;
        if(paymentTextField.getText().trim().equals("") || conditionTextField.getText().trim().equals("")
                || diagnosisTextField.getText().trim().equals("")) {
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
        Drug m = null;
//        for(int i = 0; i < Main.drugList.size(); i++){
//            if(drugName.equals(Main.drugList.get(i).getName()))
//                m = copy(Main.drugList.get(i));
//        }
        if(readyToSave) {
            if (!v.getVisitDay().equals(vDay) && vDay != null) {
               if(!d.getName().equals(drugName)){
                    Save.rename("visit\\" + p.getId() + "visit\\" + v.getVisitDay()+"\\" + d.getName() + ".txt",
                            "visit\\" + p.getId() + "visit\\" + v.getVisitDay()+"\\" + drugName + ".txt");
                    for(int i = 0; i < Main.drugList.size(); i++) {
                        if (drugName.equals(Main.drugList.get(i).getName()))
                            m = copy(Main.drugList.get(i));
                    }
                    if (!dozTextField.getText().trim().equals(""))
                        m.setDoz(doz);
                    if (!adviseTextField.getText().trim().equals(""))
                        m.setAdvise(advice);
                    if (!numberTextField.getText().trim().equals(""))
                        m.setNumber(number);
//                    if (!timeTextField.getText().trim().equals(""))
                        d.setTime(time);
                    v.getDrugList().remove(d);
                    v.addDrug(m);
                    Save.visit(v, p);
                   Save.rename("visit\\" + p.getId() + "\\" + v.getVisitDay() + ".txt", "visit\\" + p.getId() + "\\" + vDay + ".txt");
                   Save.rename("visit\\" + p.getId() + "visit\\" + v.getVisitDay(), "visit\\" + p.getId() + "visit\\" + vDay);

                   Visit n = new Visit(payment, vDay, diagnosis, condition);
                    double difference = payment - v.getPayment();
                    n.addDrug(m);
                    Main.visitList.remove(v);
                    Main.visitList.add(n);
                    p.getVisitList().remove(v);
                    p.addVisit(n);
                    p.addVisitCost(difference);
                    Save.visit(n, p);

                }
                else{
                   Save.rename("visit\\" + p.getId() + "\\" + v.getVisitDay() + ".txt", "visit\\" + p.getId() + "\\" + vDay + ".txt");
                   Save.rename("visit\\" + p.getId() + "visit\\" + v.getVisitDay(), "visit\\" + p.getId() + "visit\\" + vDay);

                   if (!dozTextField.getText().trim().equals(""))
                        d.setDoz(doz);
                    if (!adviseTextField.getText().trim().equals(""))
                        d.setAdvise(advice);
                    if (!numberTextField.getText().trim().equals(""))
                        d.setNumber(number);
                    if (!timeTextField.getText().trim().equals(""))
                        d.setTime(time);
                    Visit n = new Visit(payment, vDay, diagnosis, condition);
                    double difference = payment - v.getPayment();
                    n.addDrug(d);
                    Main.visitList.remove(v);
                    Main.visitList.add(n);
                    p.getVisitList().remove(v);
                    p.addVisit(n);
                    p.addVisitCost(difference);
                    Save.visit(n, p);
                }

            } else {
                if(!d.getName().equals(drugName)){
                    v.setDiagnosis(diagnosis);
                    v.setCondition(condition);
                    v.setPayment(payment);
                    Save.rename("visit\\" + p.getId() + "visit\\" + v.getVisitDay()+"\\" + d.getName() + ".txt",
                            "visit\\" + p.getId() + "visit\\" + v.getVisitDay()+"\\" + drugName + ".txt");
                    for(int i = 0; i < Main.drugList.size(); i++) {
                        if (drugName.equals(Main.drugList.get(i).getName()))
                            m = copy(Main.drugList.get(i));
                    }
                        if (!dozTextField.getText().trim().equals(""))
                            m.setDoz(doz);
                        if (!adviseTextField.getText().trim().equals(""))
                            m.setAdvise(advice);
                        if (!numberTextField.getText().trim().equals(""))
                            m.setNumber(number);
//                        if (!timeTextField.getText().trim().equals(""))
                            d.setTime(time);
                        v.getDrugList().remove(d);
                        v.addDrug(m);
                        Save.visit(v, p);

                }else {
                    v.setDiagnosis(diagnosis);
                    v.setCondition(condition);
                    v.setPayment(payment);
                    if (!dozTextField.getText().trim().equals(""))
                        d.setDoz(doz);
                    if (!adviseTextField.getText().trim().equals(""))
                        d.setAdvise(advice);
                    if (!numberTextField.getText().trim().equals(""))
                        d.setNumber(number);
                    if (!timeTextField.getText().trim().equals(""))
                        d.setTime(time);

                    Save.visit(v, p);
                }

            }
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
    public void back(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("getVisit.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) fill.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
