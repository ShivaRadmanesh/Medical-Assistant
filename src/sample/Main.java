package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.*;

import java.util.Date;

public class Main extends Application {
    public static ArrayList<Patient> patientList = new ArrayList<Patient>();
    public static ArrayList<Drug> drugList = new ArrayList<Drug>();
    public static ArrayList<Visit> visitList = new ArrayList<Visit>();
    public static ArrayList<User> userList = new ArrayList<User>();

    @Override
    public void start(Stage primaryStage) {
        userList = New.user();
        drugList = New.drug();
        patientList = New.patient();
        setVisitList();
       try {
            Pane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch(Exception ex){
           ex.printStackTrace();
         }

//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
//            primaryStage.setScene(new Scene(root));
//            primaryStage.show();
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
    }


    public static void main(String[] args) {
        launch(args);

//       Drug d = new Drug("floride", "little", 2, 3, "هر دو ساعت");
//        Patient p = new Patient("شیوا رادمنش" , "عباس" ,19, "0924955155", "زن", 5000);
//        Patient q = new Patient("شایا رادمنش" , "عباس" ,19, "0926951947", "زن", 5000);
//
//        Visit v = new Visit(5000, "2.2.2018", "میگرن" ,  "سر درد");
//        v.addDrug(d);
//        p.addVisit(v);
//        System.out.println(v);
//
//        Drug b = new Drug("zink", "little", 2, 3, "هر 5 ساعت");
//        v.addDrug(b);
//        User u = new User("user1", "pass1", false);
//        Save.user(u);
//
//        Save.drug(d);
//
//        Save.drug(b);
//        Save.patient(p);
//        Save.patient(q);
//        Save.visit(v, q);
//        Save.visit(v, p);
//      //  patientList = New.patient();
        ArrayList<Patient> pArr = Report.searchByAge(19);
        int index = 0;
        while(index < pArr.size()){
            System.out.println(pArr.get(index));
            index ++;
        }
        System.out.println(Report.patientNumber("2018-07-01"));


//        drugList = New.drug();
//        index = 0;
//        while(index < drugList.size()){
//            System.out.println(drugList.get(index));
//            index ++;
//        }
//
//        System.out.println(v.getDrugs());
       // Save.rename("test", "newfolder");
//        visitList = New.visit("0924955155");
//        index = 0;
//        while(index < visitList.size()){
//            System.out.println(visitList.get(index));
//            index ++;
//        }
//        System.out.println(visitList.get(0).getCondition());
//        System.out.println(visitList.get(0).getDiagnosis());
//        System.out.println(visitList.get(0).getVisitDay());
//        System.out.println(visitList.get(0).getPayment());


//        userList = New.user();
//        System.out.println(userList.get(0));
//        System.out.println(userList.get(1));
//        setVisitList();
//        System.out.println(patientList.get(0).getVisit());
//        System.out.println(userList.size());
//        ArrayList<Visit> test = patientList.get(1).getVisitList();
//        System.out.println(test.get(0).getDrugs());

    }

    public static void setVisitList(){

        for(int i = 0; i < patientList.size(); i++){
            ArrayList<Visit> pVisit = new ArrayList<Visit>();
            ArrayList<Drug> vDrug = new ArrayList<Drug>();
            Patient p = patientList.get(i);
            pVisit = New.visit(p.getId());
            for(int j = 0; j < pVisit.size(); j++){
                Visit v = pVisit.get(j);
                vDrug = New.vDrug(v,p);
                v.setDrugList(vDrug);
                p.addVisit(v);
                visitList.add(v);
            }
        }
    }
}
