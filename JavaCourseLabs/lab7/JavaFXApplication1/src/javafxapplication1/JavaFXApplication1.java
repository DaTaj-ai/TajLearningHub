/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class JavaFXApplication1 extends Application {
    
    @Override
    public void start(Stage stage) {
        try { 
  
            // set title for the stage 
            stage.setTitle("Hello JFX"); 
            
            Reflection reflection = new Reflection();
            reflection.setFraction(0.7);

            Text text = new Text();
            text.setX(10.0);
            text.setY(50.0);
            text.setCache(true);
            text.setText("Hello World!");
            text.setFill(Color.RED);
            text.setFont(Font.font(null, FontWeight.BOLD, 40));
            text.setEffect(reflection);
            
            
            Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(1, Color.WHITE)};

               LinearGradient lg1 = new LinearGradient(0, 0, 500, 500, false, CycleMethod.REPEAT, stops);
               
               Rectangle r1 = new Rectangle(0,0,1000 , 500);
               r1.setFill(lg1);
               
               
               
            StackPane stack_pane = new StackPane(r1,text); 
  
            Scene scene = new Scene(stack_pane, 400, 300); 

            stage.setScene(scene); 
  
            stage.show(); 
        } 
  
        catch (Exception e) { 
  
            System.out.println(e.getMessage()); 
        } 
    } 
    

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
