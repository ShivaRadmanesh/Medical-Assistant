package sample;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;

public class Patient {
    private String name;
    private String fatherName;
    private int age;
    private String id;
    private String gender;
    private double visitCost = 0;
    private String exp = "";
    private String insurance;
    private String insuranceId;
    private ArrayList<Visit> visits = new ArrayList<Visit>();
    public boolean saved ;

    public Patient(String name, String fatherName, int age, String id, String gender){
        this.name = name;
        this.fatherName = fatherName;
        this.age = age;
        this.id = id;
        this.gender = gender;

    }
    public Patient(String name, String fatherName, int age, String id, String gender, double visitCost){
        this.name = name;
        this.fatherName = fatherName;
        this.age = age;
        this.id = id;
        this.gender = gender;
        this.visitCost = visitCost;

    }
    public Patient(String name, String fatherName, int age, String id, String gender, double visitCost, String insurance, String insuranceId, String exp){
        this.name = name;
        this.fatherName = fatherName;
        this.age = age;
        this.id = id;
        this.gender = gender;
        this.visitCost += visitCost;
        this.insurance = insurance;
        this.insuranceId = insuranceId;
        this.exp = exp;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender(){
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public double getVisitCost() {
        return visitCost;
    }
    public void addVisitCost(Visit v){
        visitCost += v.getPayment();
    }

    public void setVisitCost(double visitCost) {
        this.visitCost = visitCost;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }
    public void addVisit(Visit v){
        visits.add(v);
    }

    public ArrayList<Visit> getVisits() {
        return visits;
    }

    public void setVisits(ArrayList<Visit> visits) {
        this.visits = visits;
    }
    public void addVisitCost(Double d){
        visitCost += d;
    }

    public String getVisit(){
        String s = "";
        for(Visit v : visits){
            s += v.toString();
        }
        return s;
    }
    public ArrayList<Visit> getVisitList(){
        return visits;
    }

    @Override
    public String toString() {
        String s = "";
        s += getName() + "\t";
        s += getFatherName() + "\t";
        s += getAge() + "\t";
        s +=  getId() + "\t";
        s += getGender() + "\t";
        s += getVisitCost() + "\t";
        s += getInsurance() + "\t";
        s += getInsuranceId() + "\t";
        s += getExp() + "\t";

        return s;
    }
}
