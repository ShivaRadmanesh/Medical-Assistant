package sample;

import java.util.ArrayList;
import java.util.Date;

public class Visit {
    private String condition;
    private String diagnosis;
    private double payment;
    private ArrayList<Drug> drugs = new ArrayList<Drug>();
    private String visitDay;
    public Visit(double payment, String visitDay, String diagnosis, String condition){
        this.payment = payment;
        this.visitDay = visitDay;
        this.condition = condition;
        this.diagnosis = diagnosis;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }
    public void addDrug(Drug d){
        drugs.add(d);
    }
    public String getDrugs(){
        String s = "";
        for(Drug d : drugs){
            s += d.toString() + "\n";
        }
        return s;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getPayment() {
        return payment;
    }


    public void setVisitDay(String visitDay) {
        this.visitDay = visitDay;
    }

    public String getVisitDay() {
        return visitDay;
    }

    public void setDiagnosis(String diagnosis) {
       this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
    public ArrayList<Drug> getDrugList(){
        return drugs;
    }

    public void setDrugList(ArrayList<Drug> drugs){
        this.drugs = drugs;
    }



    @Override
    public String toString(){
    String s = "";

    s += condition + "\t";;
    s += getDiagnosis() + "\t";
    s += getPayment() + "\t";
    s += getVisitDay() + "\t";
    s += getDrugs() + "\t";

    return s;
    }
}

