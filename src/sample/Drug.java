package sample;

public class Drug {
    private String name;
    private String advise;
    private int doz;
    private int number;
    private String time;


    public Drug(String name, String advise, int doz, int number,String time){
        this.name = name;
        this.advise = advise;
        this.doz = doz;
        this.number = number;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getDoz() {
        return doz;
    }

    public String getAdvise() {
        return advise;
    }

    public void setAdvise(String advise) {
        this.advise = advise;
    }

    public void setDoz(int doz) {
        this.doz = doz;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        String s = "";
        s +=  getName() + "\t";
        s +=  getAdvise() + "\t";
        s +=  getDoz() + "\t";
        s +=  getNumber() + "\t";

        return s;
    }
}
