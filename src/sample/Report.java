package sample;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Report {
    public static String totalPayment(){
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        double result = 0 ;
        for(int i = 0; i < Main.patientList.size(); i++){
            for(int j = 0; j < Main.patientList.get(i).getVisitList().size(); j++){
                result +=  Main.patientList.get(i).getVisitList().get(j).getPayment();
            }
        }
        return fmt.format(result);
    }
    public static String personalPayment(Patient p){
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        double result = 0;
        for(int j = 0; j < p.getVisitList().size(); j++){
            result +=  p.getVisitList().get(j).getPayment();
        }
        return fmt.format(result);
    }
    public static int patientNumber(String date){
        int result = 0;
        for(int i = 0; i < Main.visitList.size(); i++){
            if(date.equals(Main.visitList.get(i).getVisitDay())){
                result++;
            }
        }
        return result;
    }
    public static ArrayList<Patient> searchByAge(int age){
        ArrayList<Patient> patientArrayList = new ArrayList<Patient>();
        for(int i = 0; i < Main.patientList.size(); i++){
            if(age == Main.patientList.get(i).getAge())
                patientArrayList.add(Main.patientList.get(i));
        }
        return patientArrayList;
    }
    public static String searchByInsurance(String insurance){
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        double result = 0;
        for(int i = 0; i < Main.patientList.size(); i++){
            if(insurance.equals(Main.patientList.get(i).getInsurance()))
                result += Main.patientList.get(i).getVisitCost();
        }
        return fmt.format(result);
    }
}
