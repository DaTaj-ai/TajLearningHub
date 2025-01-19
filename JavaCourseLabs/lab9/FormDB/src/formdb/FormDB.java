/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formdb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Taj
 */
public class FormDB extends Application {
    
    private DataAccessLayer myDataAccessLayer;
    
    public void init(){
        try {
            super.init();
           myDataAccessLayer = new DataAccessLayer();
        } catch (Exception ex) {
            Logger.getLogger(FormDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new FXMLDocumentBase(myDataAccessLayer) ; 
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
