package sams;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    Button loginBtn, logoutBtn, dummyBtn;    
    @FXML
    Button homeOneBtn;
    @FXML
    Button homeTwoBtn;
    @FXML
    Button homeThreeBtn;
    @FXML
    Button homeFourBtn;
    
    @FXML
    TextField userName;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
    
        Stage stage;
        Parent root;
        
        if(event.getSource() == loginBtn){
            //TODO handle login stuff
            
            stage = (Stage)loginBtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
        if(event.getSource() == logoutBtn) {
            stage = (Stage)logoutBtn.getScene().getWindow();
            stage.close();root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
        if(event.getSource() == dummyBtn) {
            stage = (Stage)dummyBtn.getScene().getWindow();
            stage.close();root = FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
        if(event.getSource() == homeOneBtn) {
            stage = (Stage)homeOneBtn.getScene().getWindow();
            stage.close();root = FXMLLoader.load(getClass().getResource("AddScreen.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
        if(event.getSource() == homeTwoBtn) {
            stage = (Stage)homeTwoBtn.getScene().getWindow();
            stage.close();root = FXMLLoader.load(getClass().getResource("dummy.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
        if(event.getSource() == homeThreeBtn) {
            stage = (Stage)homeThreeBtn.getScene().getWindow();
            stage.close();root = FXMLLoader.load(getClass().getResource("dummy.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
        if(event.getSource() == homeFourBtn) {
            stage = (Stage)homeFourBtn.getScene().getWindow();
            stage.close();root = FXMLLoader.load(getClass().getResource("dummy.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
}
