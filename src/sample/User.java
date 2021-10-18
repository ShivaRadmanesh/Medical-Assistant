package sample;

public class User {
    private String userName;
    private String passWord;
    private boolean doctor;
    public User(String userName, String passWord, boolean doctor){
        this.userName = userName;
        this.passWord = passWord;
        this.doctor = doctor;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isDoctor() {
        return doctor;
    }

    @Override
    public String toString() {
        String s = "";
        s += getUserName() + "\n";
        s += getPassWord() + "\n";
        s += isDoctor() + "\n";

        return s;
    }
}
