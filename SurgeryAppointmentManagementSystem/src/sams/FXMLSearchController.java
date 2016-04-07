
package sams;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.text.Text;


public class FXMLSearchController implements Initializable {
    
    Collection<TableColumn> columns = new ArrayList<>();
    
    @FXML private Text actiontarget;
    @FXML private TextField searchText;
    @FXML private TableView tableViewSearch;
    @FXML private ComboBox tableCombo;
    @FXML Button goBtn;
    
    @FXML
    private void handleButtonSearch(ActionEvent event) throws IOException{
    
        Stage stage;
        String keyword;
        String selectedTable;
        Parent root;
        
        if(event.getSource() == goBtn){
            keyword = searchText.getText();
            selectedTable = (String) tableCombo.getSelectionModel().getSelectedItem();
            actiontarget.setText("Searching...");
            if(!tableViewSearch.getColumns().isEmpty()){
                tableViewSearch.getColumns().removeAll(columns);
                columns.removeAll(columns);
            }
            switch(selectedTable){
                case "Patients":
                    columns.add(new TableColumn("Name"));
                    columns.add(new TableColumn("Surname"));
                    columns.add(new TableColumn("Mobile Phone"));
                    columns.add(new TableColumn("Email"));
                    columns.add(new TableColumn("Address"));
                    tableViewSearch.getColumns().addAll(columns);
                case "Summaries":
                case "Conditions":
                case "Apointments":
            }
            //do search with keyword string
            
            //actiontarget.setVisible(false);
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
