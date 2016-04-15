
package sams;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SAMS extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        
        Scene scene = new Scene(root);
        
        scene.getStylesheets().add(SAMS.class.getResource("OverallStyle.css").toExternalForm());
        
        stage.setScene(scene);
        stage.show();
    }

static void main(String[] args) {
        launch(args);
    }
    
}
