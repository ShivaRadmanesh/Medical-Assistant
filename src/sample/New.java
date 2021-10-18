package sample;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class New {
    static BufferedReader br;
    static FileReader fr;
    public static ArrayList<Patient> patient(){
        File[] files = getFile("patient");
        ArrayList<Patient> patients = new ArrayList<Patient>();
        for(int i = 0; i < files.length; i++){
            String[] s = new String[10];
            Patient p = null;

            try {
                fr = new FileReader(files[i]);
                br= new BufferedReader(fr);
                for(int j = 0; j < 10; j++){
                    s[j] = br.readLine();
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }
            finally{
                try {
                br.close();
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
            p = new Patient(s[0], s[1], Integer.parseInt(s[2]),s[3], s[4], Double.parseDouble(s[5]),s[6], s[7],s[8]);
            patients.add(p);
        }

        return patients;
    }
    public static ArrayList<Drug> drug(){
        File[] files = getFile("drug");
        ArrayList<Drug> drugs = new ArrayList<Drug>();
        String[] s = new String[5];
        Drug d = null;
        for(int i = 0; i < files.length; i++){
            try {
                fr = new FileReader(files[i]);
                br= new BufferedReader(fr);
                for(int j = 0; j < 5; j++){
                    s[j] = br.readLine();
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }
            finally{
                try {
                    br.close();
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
            d = new Drug(s[0], s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3]),s[4]);
            drugs.add(d);
        }
        return drugs;
    }

    public static ArrayList<Visit> visit(String patientId){
        String filePath = "visit\\" + patientId;
        String[] s = new String[4];
        File[] files = getFile(filePath);
        ArrayList<Visit> visits = new ArrayList<Visit>();
        Visit v ;
        for(int i = 0; i < files.length; i++){
            try {
                fr = new FileReader(files[i]);
                br= new BufferedReader(fr);
                for(int j = 0; j < 4; j++){
                    s[j] = br.readLine();
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }
            finally{
                try {
                    br.close();
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
            v = new Visit( Double.parseDouble(s[3]), s[1], s[2], s[0]);
            visits.add(v);
        }
        return visits;

    }

    public static ArrayList<User> user(){
        ArrayList<User> users = new ArrayList<User>();
        User u = null;
        File[] files = getFile("user");
        String[] s = new String[3];
        for(int i = 0; i < files.length; i++){
            try {
                fr = new FileReader(files[i]);
                br= new BufferedReader(fr);
                for(int j = 0; j < 3; j++){
                    s[j] = br.readLine();
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }
            finally{
                try {
                    br.close();
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
            u = new User(s[0], s[1],Boolean.parseBoolean(s[2]));
            users.add(u);
        }
        return users;
    }
    public static ArrayList<Drug> vDrug(Visit v, Patient p){
        String filePath = "visit\\" + p.getId() + "visit\\" + v.getVisitDay();
        File[] files = getFile(filePath);
        ArrayList<Drug> drugs = new ArrayList<Drug>();
        String[] s = new String[5];
        Drug d = null;
        for(int i = 0; i < files.length; i++){
            try {
                fr = new FileReader(files[i]);
                br= new BufferedReader(fr);
                for(int j = 0; j < 5; j++){
                    s[j] = br.readLine();
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }
            finally{
                try {
                    br.close();
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
            d = new Drug(s[0], s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3]), s[4]);
            drugs.add(d);
        }
        return drugs;
    }

    private static File[] getFile(String address){
        Path folderPath = Paths.get(address);
        File pList = new File(folderPath.toString());
        File[] file = pList.listFiles();
        return file;

    }
}
