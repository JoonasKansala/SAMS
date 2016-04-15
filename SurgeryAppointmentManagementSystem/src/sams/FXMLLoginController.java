package sams;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.*;
import javafx.scene.control.Alert;



public class FXMLLoginController implements Initializable {
    
    @FXML
    Button loginBtn, logoutBtn;
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Label errorMessage;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, SQLException{
    
        Stage stage;
        Parent root;
        
        if(event.getSource() == loginBtn){
            //TODO handle login stuff
            String user= username.getText();
            String pass= password.getText();
            
            
            if(DatabaseHelper.login(user, pass) == 1){
                try{
            SAMS.loggedUser=user;
            SAMS.loggedPrivileges= DatabaseHelper.getPrivileges(user , pass);
            System.out.println(SAMS.loggedPrivileges);
            stage = (Stage)loginBtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
                }
                catch(Exception e){
                System.out.println(e);}
            }
            else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Wrong username or password");
            alert.setContentText("Please insert the correct username or password");

        alert.showAndWait();
            }
        }
        
        if(event.getSource() == logoutBtn) {
            stage = (Stage)logoutBtn.getScene().getWindow();
            stage.close();
            root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
        
        
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
}
