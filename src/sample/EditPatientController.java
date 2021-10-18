package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class EditPatientController implements Initializable {
    public RadioButton male;
    public RadioButton female;
    public TextField nameTextField;
    public TextField fatherNameTextField;
    public TextField ageTextField;
    public TextField idTextField;
    public TextField insuranceTextField;
    public TextField insuranceIdTextField;
    public DatePicker expDate;
    public Label saved;
    public Label numeric;
    public Label fill;
    public Button saveButton;
    public Button visitButton;
    public Button homeButton;
    public Button backButton;
    public Patient p = GetPatientIdController.patient;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup group = new ToggleGroup();
        male.setToggleGroup(group);
        male.setSelected(true);
        female.setToggleGroup(group);

        p = GetPatientIdController.patient;
        if(p.getGender().equals("زن"))
            female.setSelected(true);
        nameTextField.setText(p.getName());
        fatherNameTextField.setText(p.getFatherName());
        ageTextField.setText(String.valueOf(p.getAge()));
        idTextField.setText(p.getId());
        insuranceTextField.setText(p.getInsurance());
        insuranceIdTextField.setText(p.getInsuranceId());
    }
    public void home() {
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
    public void save(){
        boolean readyToSave = true;
        if(nameTextField.getText().trim().equals("") || fatherNameTextField.getText().trim().equals("")
                || idTextField.getText().trim().equals("") || ageTextField.getText().trim().equals("") ) {
            readyToSave = false;
            fill.setVisible(true);
        }
        String name = nameTextField.getText();
        String fatherName = fatherNameTextField.getText();
        int age =0;
        try {
            age = Integer.parseInt(ageTextField.getText());
        }catch(Exception ex){
            if(!ageTextField.getText().trim().equals("")) {
                numeric.setVisible(true);
            }
            readyToSave = false;
        }
        String id = idTextField.getText();
        String insurance = insuranceTextField.getText();
        String insuranceId = insuranceIdTextField.getText();
        LocalDate date = null;
        date = expDate.getValue();
        String exp = null;


        if(date != null) {
            exp = expDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }


        String gender = "مرد";
        if(female.isSelected()){
            gender ="زن";
        }
        if(readyToSave){
            if(!p.getId().equals(id)){
                Save.rename("patient\\" + p.getId() + ".txt", "patient\\" + id + ".txt");
                Save.rename("visit\\" + p.getId(),"visit\\" + id);
                Save.rename("visit\\" + p.getId() + "visit", "visit\\" + id + "visit");
                Patient m = new Patient(name, fatherName, age,id, gender ) ;
                if(exp != null)
                    m.setExp(exp);
                if(!insuranceTextField.getText().trim().equals(""))
                    m.setInsurance(insurance);
                if(!insuranceIdTextField.getText().trim().equals(""))
                    m.setInsuranceId(insuranceId);
                Save.patient(m);
                m.setVisits(p.getVisits());
                for(int i = 0; i < Main.patientList.size(); i++){
                    if(p.equals(Main.patientList.get(i)))
                        Main.patientList.remove(i);
                }
                Main.patientList.add(m);

            }
            else {
                p.setName(name);
                p.setFatherName(fatherName);
                p.setAge(age);
                p.setId(id);
                p.setGender(gender);
                if (exp != null)
                    p.setExp(exp);
                if (!insuranceTextField.getText().trim().equals(""))
                    p.setInsurance(insurance);
                if (!insuranceIdTextField.getText().trim().equals(""))
                    p.setInsuranceId(insuranceId);
                Save.patient(p);
            }
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("saved.fxml"));
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
            Pane pane = FXMLLoader.load(getClass().getResource("getPatientId.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) homeButton.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
