package sample;
import java.io.BufferedReader;
import java.io.File;
import java.io.*;

public class Save {
    static FileWriter fw;
    static PrintWriter pw;
    static BufferedWriter bw;

    public static void makeDirectory(String name){
        File file = new File(name);

// if the directory does not exist, create it
        if (!file.exists()) {
            System.out.println("creating directory: " + file.getName());
            boolean result = false;

            try{
                file.mkdir();
                result = true;
            }
            catch(SecurityException se){
                System.out.println("can not make the file");
            }
            if(result) {
                System.out.println("file created");
            }
        }
        else{
            System.out.println("file already existed");
        }
    }

    public static void makeDirectory(String parent, String name){
        File file = new File(parent, name);

// if the directory does not exist, create it
        if (!file.exists()) {
            System.out.println("creating directory: " + file.getName());
            boolean result = false;

            try{
                file.mkdir();
                result = true;
            }
            catch(SecurityException se){
                System.out.println("can not make the file");
            }
            if(result) {
                System.out.println("file created");
            }
        }
        else{
            System.out.println("file already existed");
        }
    }

    //save the drug information
    public static void drug(Drug d){

        String filePath = "drug";
        makeDirectory(filePath);
        File myDrug = new File(filePath, d.getName()+ ".txt");
        try{
            fw = new FileWriter(myDrug, false);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(d.getName());
            pw.println(d.getAdvise());
            pw.println(String.valueOf(d.getDoz()));
            pw.println(String.valueOf(d.getNumber()));
            pw.println(d.getTime());

        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            pw.close();
        }

    }
//    private static void write(File file, String content){
//        try{
//            fw = new FileWriter(file, false);
//            bw = new BufferedWriter(fw);
//            pw = new PrintWriter(bw);
//            pw.println(content);
//        }catch(IOException ex){
//            ex.printStackTrace();
//        }finally{
//            pw.close();
//        }
//    }

    public static void patient(Patient p) {

        String filePath = "patient";
        makeDirectory(filePath);
        File myPatient = new File(filePath, p.getId() + ".txt");
        try {
            fw = new FileWriter(myPatient, false);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(p.getName());
            pw.println(p.getFatherName());
            pw.println(String.valueOf(p.getAge()));
            pw.println(p.getId());
            pw.println(p.getGender());
            pw.println(String.valueOf(p.getVisitCost()));
            pw.println(p.getInsurance());
            pw.println(p.getInsuranceId());
            pw.println(p.getExp());

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            pw.close();
        }
    }

    public static void visit(Visit v, Patient p){
        String file = "visit";
        makeDirectory(file);
        makeDirectory(file, p.getId());
        File myVisit = new File( "visit\\" + p.getId(), v.getVisitDay()+".txt");
        try{
            fw = new FileWriter(myVisit, false);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(v.getCondition());
            pw.println(v.getVisitDay());
            pw.println(v.getDiagnosis());
            pw.println(String.valueOf(v.getPayment()));


        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            pw.close();
        }
        String dList = p.getId() + "visit";
        makeDirectory(file, dList);
        makeDirectory("visit\\" + dList, v.getVisitDay());
        String path = "visit\\" + dList +"\\" + v.getVisitDay();
        for(int i = 0; i < v.getDrugList().size(); i++){
            Drug d = v.getDrugList().get(i);
            File myDrug = new File(path, d.getName()+ ".txt");
            try{
                fw = new FileWriter(myDrug, false);
                bw = new BufferedWriter(fw);
                pw = new PrintWriter(bw);
                pw.println(d.getName());
                pw.println(d.getAdvise());
                pw.println(String.valueOf(d.getDoz()));
                pw.println(String.valueOf(d.getNumber()));
                pw.println(String.valueOf(d.getTime()));

            }catch(IOException ex){
                ex.printStackTrace();
            }finally{
                pw.close();
            }


        }
    }
    public static void user(User u){
        String file = "user";
        makeDirectory(file);
        File myUser = new File("user", u.getUserName() + ".txt");
        try{
            fw = new FileWriter(myUser, false);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(u.getUserName());
            pw.println(u.getPassWord());
            pw.println(u.isDoctor());


        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            pw.close();
        }
    }

    public static void rename(String oldPath, String newPath){
        File dir = new File(oldPath);
        File newDir = new File(newPath);
        dir.renameTo(newDir);
    }
}
