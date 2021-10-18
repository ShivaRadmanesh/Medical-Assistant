package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReportController implements Initializable {
    public Label totalPaymentLabel;
    public Label personalPaymentLabel;
    public TextField personalPaymentTextField;
    public Label warningLabel;
    public DatePicker datePicker;
    public Label patientNumberLabel;
    public ChoiceBox<String> ids;
    public TextField ageTextField;
    public Button observeButton;
    public Label numeric;
    public ImageView reportImage;
    public TextField insuranceTextField;
    public Label insuranceLabel;
    public TextField idTextField;
    public Label nameLabel;
    public Label notFoundLabel;
    public ChoiceBox<String> visitDayList;
    private ArrayList <String> list = new ArrayList<String>();
    public void initialize(URL location, ResourceBundle resources) {
        File report = new File("image\\reportBack.jpg");
        Image rImage = new Image(report.toURI().toString(), reportImage.getFitWidth(), reportImage.getFitHeight(), false, false);
        reportImage.setImage(rImage);
    }
    public void allPayment(){
        totalPaymentLabel.setText(Report.totalPayment());
        totalPaymentLabel.setVisible(true);
    }
    public void personalPayment(){
        String id = personalPaymentTextField.getText();
        Patient p = null;
        for(int i = 0; i < Main.patientList.size(); i++){
            if(id.equals(Main.patientList.get(i).getId())){
                p = Main.patientList.get(i);
                personalPaymentLabel.setText(Report.personalPayment(p));
                personalPaymentLabel.setVisible(true);
            }
        }
        if(p == null){
            warningLabel.setVisible(true);
        }
    }
    public void patientNumber(){
        LocalDate date = null;
        date = datePicker.getValue();

        String day = null;
        if(date != null) {
            day = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        if(day != null){
            patientNumberLabel.setText(String.valueOf(Report.patientNumber(day)));
            patientNumberLabel.setVisible(true);
        }
    }
    public void searchByAge(){
        int age = 0;
        if(!ageTextField.getText().trim().equals(""))
        {
            try {
                age = Integer.parseInt(ageTextField.getText());
            }catch (Exception ex){
                numeric.setVisible(true);
            }
        }
        if(age != 0){
            ArrayList<Patient> patients = Report.searchByAge(age);
            for(int i = 0; i < patients.size(); i++){
                list.add(Main.patientList.get(i).getId());
            }
            ObservableList<String> observableList = FXCollections.observableList(list);
            ids .setItems(observableList);
            ids.getSelectionModel().selectFirst();
            ids.setVisible(true);
            if (list.size() > 0)
                observeButton.setVisible(true);
        }
    }
    public void observe() {
        if (list.size() > 0) {
            String id = ids.getValue();
            Patient m = null;
            for (int i = 0; i < Main.patientList.size(); i++) {
                if (id.equals(Main.patientList.get(i).getId()))
                    m = Main.patientList.get(i);
            }
            GetPatientId2Controller.patient = m;
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("observePatient.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) ids.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public void insurance(){
        String insurance = null;
       if(!insuranceTextField.getText().trim().equals("")) {
           insurance = insuranceTextField.getText();
       }
       if(insurance != null && insurance != "null" ){
           insuranceLabel.setText(Report.searchByInsurance(insurance));
           insuranceLabel.setVisible(true);
       }
    }
    public void search(){
        Patient k = null;
        String id = null;
        if(!idTextField.getText().trim().equals(""))
            id = idTextField.getText();
        if(id != null){
            for(int i = 0; i < Main.patientList.size(); i++){
                if(id.equals(Main.patientList.get(i).getId()))
                    k = Main.patientList.get(i);
            }
            if(k == null)
                notFoundLabel.setVisible(true);
            if(k != null){
                ArrayList<String> arr = new ArrayList<String>();
                for(int i = 0; i < k.getVisitList().size(); i++){
                    arr.add(k.getVisitList().get(i).getVisitDay());
                }
                ObservableList<String> observableList = FXCollections.observableList(arr);
                visitDayList .setItems(observableList);
                visitDayList.getSelectionModel().selectFirst();
                visitDayList.setVisible(true);
                nameLabel.setText(k.getName());
                nameLabel.setVisible(true);
            }
        }
    }
    public void home(){
        if (LoginController.type) {
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("doctor.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) ids.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("secretary.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) ids.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
