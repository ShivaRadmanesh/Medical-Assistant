package sample;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController {
    public TextField userTextField;
    public TextField passTextField;
    public Label label;
    public static boolean type;

    public void enter() {
        String user = userTextField.getText();
        String pass = passTextField.getText();
        int i;
        for (i = 0; i < Main.userList.size(); i++) {
            if (user.equals(Main.userList.get(i).getUserName()) && pass.equals(Main.userList.get(i).getPassWord())) {
                type = Main.userList.get(i).isDoctor();
                if (Main.userList.get(i).isDoctor()) {
                    try {
                        Pane pane = FXMLLoader.load(getClass().getResource("doctor.fxml"));
                        Scene scene = new Scene(pane);
                        Stage stage = (Stage) label.getScene().getWindow();
                        stage.setScene(scene);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        Pane pane = FXMLLoader.load(getClass().getResource("secretary.fxml"));
                        Scene scene = new Scene(pane);
                        Stage stage = (Stage) label.getScene().getWindow();
                        stage.setScene(scene);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }


        }
        if (i >= Main.userList.size())
            label.setVisible(true);
        if(i < Main.userList.size() && ! pass.equals(Main.userList.get(i).getPassWord()))
            label.setVisible(true);
    }
    public void register(){
        try{
            Pane pane = FXMLLoader.load(getClass().getResource("register.fxml"));
            Scene scene = new Scene(pane);
            Stage stage =(Stage) label.getScene().getWindow();
            stage.setScene(scene);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
