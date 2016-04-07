
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
import javafx.scene.text.Text;


public class FXMLSearchController implements Initializable {
    
    @FXML private Text actiontarget;
    @FXML private TextField searchText;
    @FXML Button goBtn;
    
    @FXML
    private void handleButtonSearch(ActionEvent event) throws IOException{
    
        Stage stage;
        String keyword;
        Parent root;
        
        if(event.getSource() == goBtn){
            keyword = searchText.getText();
            actiontarget.setText("Searching...");
            
            //do search with keyword string
            
            actiontarget.setVisible(false);
            //stage = (Stage)goBtn.getScene().getWindow();
            //root = FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
            //Scene scene = new Scene(root);
            //stage.setScene(scene);
            //stage.show();
        }
        
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
}
