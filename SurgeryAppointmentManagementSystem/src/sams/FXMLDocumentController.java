package sams;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
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
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    ListView todaysApp;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, SQLException{
    
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
            stage.close();
            root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
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
            stage.close();root = FXMLLoader.load(getClass().getResource("dummy.fxml"));
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
        ListProperty<String> listProperty = new SimpleListProperty<>();
        try {
            todaysApp.itemsProperty().bind(listProperty);
            listProperty.set(FXCollections.observableArrayList(DatabaseHelper.todaysApp()));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
