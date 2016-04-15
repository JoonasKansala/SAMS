package sams;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import sams.DataModels.Appointment;
import sams.DataModels.Condition;
import sams.DataModels.Patient;
import sams.DataModels.Summary;


public class ViewSearchDetailsController implements Initializable {
    
    private Patient patient;
    private Appointment apointment;
    private Summary summary;
    private Condition condition;
    
    @FXML private Text name;

    public void setName(String name) {
        this.name.setText(name);
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setApointment(Appointment apointment) {
        this.apointment = apointment;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
    
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
}