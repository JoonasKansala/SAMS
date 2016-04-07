
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
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    Button loginBtn, logoutBtn, searchBtn;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
    
        Stage stage;
        Parent root;
        
        if(event.getSource() == loginBtn){
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
        
        if(event.getSource() == searchBtn) {
            stage = (Stage)searchBtn.getScene().getWindow();
            stage.close();root = FXMLLoader.load(getClass().getResource("SearchScreen.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
}
