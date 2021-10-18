package sample;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class RegisterController {
    public TextField userTextField;
    public TextField passTextField;
    public CheckBox type;
    public Button enterButton;
    public Label label;
    public void register(){
        String userName = userTextField.getText();
        String passWord = passTextField.getText();
        Boolean isDoctor = type.isSelected();
        User u = new User(userName, passWord, isDoctor);
        Main.userList.add(u);
        Save.user(u);
        label.setVisible(true);
    }
    public void enter(){
        try{
            Pane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(pane);
            Stage stage =(Stage) label.getScene().getWindow();
            stage.setScene(scene);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
