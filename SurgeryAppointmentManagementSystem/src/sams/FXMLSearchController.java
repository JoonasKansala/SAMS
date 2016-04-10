
package sams;

import sams.DataModels.Summary;
import sams.DataModels.Condition;
import sams.DataModels.Patient;
import sams.DataModels.Appointment;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
                    TableColumn name = new TableColumn("Name");
                    TableColumn surname = new TableColumn("Surname");
                    TableColumn mobile = new TableColumn("Mobile Phone");
                    //Maybe do a nested column to show the home phone too
                    TableColumn email = new TableColumn("Email");
                    TableColumn addr = new TableColumn("Address");
                    
                    columns.add(name);
                    columns.add(surname);
                    columns.add(mobile);
                    columns.add(email);
                    columns.add(addr);
                    
                    name.setCellValueFactory(new PropertyValueFactory<Patient, String>("pName"));
                    surname.setCellValueFactory(new PropertyValueFactory<Patient, String>("pSurname"));
                    mobile.setCellValueFactory(new PropertyValueFactory<Patient, String>("pMobPhone"));
                    email.setCellValueFactory(new PropertyValueFactory<Patient, String>("pEmail"));
                    addr.setCellValueFactory(new PropertyValueFactory<Patient, String>("pAddress"));
                    
                    tableViewSearch.getColumns().addAll(columns);
                    break;
                case "Summaries":
                    TableColumn spName = new TableColumn("Patient Name");
                    TableColumn summary = new TableColumn("Summary");
                    
                    columns.add(spName);
                    columns.add(summary);
                    
                    spName.setCellValueFactory(new PropertyValueFactory<Summary, String>("pName"));
                    summary.setCellValueFactory(new PropertyValueFactory<Summary, String>("aSummary"));
                    
                    tableViewSearch.getColumns().addAll(columns);
                    break;
                case "Conditions":
                    TableColumn cName = new TableColumn("Condition Name");
                    TableColumn cDesc = new TableColumn("Description");
                    TableColumn tLevel = new TableColumn("Threat level");
                    
                    columns.add(cName);
                    columns.add(cDesc);
                    columns.add(tLevel);
                    
                    cName.setCellValueFactory(new PropertyValueFactory<Condition, String>("cName"));
                    cDesc.setCellValueFactory(new PropertyValueFactory<Condition, String>("cDesc"));
                    tLevel.setCellValueFactory(new PropertyValueFactory<Condition, String>("cThreat_level"));
                    
                    tableViewSearch.getColumns().addAll(columns);
                    break;
                case "Appointment":
                    TableColumn apName = new TableColumn("Patient Name");
                    TableColumn aDate = new TableColumn("Date and time");
                    TableColumn aType = new TableColumn("Type");
                    
                    columns.add(apName);
                    columns.add(aDate);
                    columns.add(aType);
                    
                    apName.setCellValueFactory(new PropertyValueFactory<Appointment, String>("pName"));
                    aDate.setCellValueFactory(new PropertyValueFactory<Appointment, String>("aDatetime"));
                    aType.setCellValueFactory(new PropertyValueFactory<Appointment, String>("aType"));
                    
                    tableViewSearch.getColumns().addAll(columns);
                    break;
            }
            List results = new ArrayList<>();
            //do search with keyword string
            try{
                results = DatabaseHelper.search(selectedTable, keyword);
                tableViewSearch.getItems().setAll(results);
            }
            catch(SQLException e){
                System.out.println(e);
            }
            
            
            
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
