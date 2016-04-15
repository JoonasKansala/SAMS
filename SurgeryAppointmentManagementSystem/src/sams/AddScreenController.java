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
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AddScreenController implements Initializable {
    
    DatabaseHelper db = new DatabaseHelper();
    
    @FXML
    Button dummyBtn, addBtn1, addBtn2;
    
    @FXML
    Label messageLabel1, messageLabel3;
    
    @FXML //add patient textfields
    TextField fName, fSurname, fHome, fMobile, fEmail, fAddress, fSex, fDOB;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, SQLException{
    
        Stage stage;
        Parent root;
        
        if(event.getSource() == dummyBtn) {
            stage = (Stage)dummyBtn.getScene().getWindow();
            stage.close();root = FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
        if(event.getSource() == addBtn1) {
            messageLabel1.setText("Clicked");
        }
        
//Add patient details        
        String pName = fName.getText();
        String pSurname = fSurname.getText();
        String pHomenum = fHome.getText();
        String pMobile = fMobile.getText();
        String pAddress = fAddress.getText();
        String pSex = fSex.getText();
        String pEmail = fEmail.getText();
        String pDOB = fDOB.getText();
        
        if(event.getSource() == addBtn2) {
            db.insertPatient(pName, pSurname, pHomenum, pMobile, pEmail, pAddress, pSex, pDOB);
            messageLabel3.setText("Clicked, you might have done something");
            
        }
        
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
    }
    
}