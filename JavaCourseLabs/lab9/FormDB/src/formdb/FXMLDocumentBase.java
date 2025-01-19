package formdb;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextFlow;

public class FXMLDocumentBase extends FlowPane {

    protected final MenuBar menuBar;
    protected final Menu menu;
    protected final MenuItem menuItem;
    protected final TextFlow textFlow;
    protected final Label label;
    protected final TextField idTextField;
    protected final TextFlow textFlow0;
    protected final Label label0;
    protected final TextField firstNameTextField;
    protected final TextFlow textFlow1;
    protected final Label label1;
    protected final TextField midelNameTextField;
    protected final TextFlow textFlow2;
    protected final Label label2;
    protected final TextField lastNameTextField;
    protected final TextFlow textFlow3;
    protected final Label label3;
    protected final TextField emailTextField;
    protected final TextFlow textFlow4;
    protected final Label label4;
    protected final TextField phoneTextField;
    protected final TextFlow textFlow5;
    protected Button newSaveButton;
    protected final Button updateSaveButton;
    protected final Button deleteButton;
    protected final Button firstButton;
    protected final Button previousButton;
    protected final Button nextButton;
    protected final Button lastButton;
    protected final TextField outPuttextField;
    Boolean isSave = true;
    Boolean isUpdate = true ; 
    int currentIndex = 0  ; 

    public FXMLDocumentBase(DataAccessLayer myDataAccessLayer) {

        isSave = true;
        isUpdate = true ; 
        menuBar = new MenuBar();
        menu = new Menu();
        menuItem = new MenuItem();
        textFlow = new TextFlow();
        label = new Label();
        idTextField = new TextField();
        textFlow0 = new TextFlow();
        label0 = new Label();
        firstNameTextField = new TextField();
        textFlow1 = new TextFlow();
        label1 = new Label();
        midelNameTextField = new TextField();
        textFlow2 = new TextFlow();
        label2 = new Label();
        lastNameTextField = new TextField();
        textFlow3 = new TextFlow();
        label3 = new Label();
        emailTextField = new TextField();
        textFlow4 = new TextFlow();
        label4 = new Label();
        phoneTextField = new TextField();
        textFlow5 = new TextFlow();
        outPuttextField = new TextField();
        outPuttextField.setDisable(true);
        
        idTextField.setDisable(true);
        firstNameTextField.setDisable(true);
        lastNameTextField.setDisable(true);
        midelNameTextField.setDisable(true);
        emailTextField.setDisable(true);
        phoneTextField.setDisable(true);

        newSaveButton = new Button();
        updateSaveButton = new Button();
        deleteButton = new Button();
        firstButton = new Button();
        previousButton = new Button();
        nextButton = new Button();
        lastButton = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        menu.setMnemonicParsing(false);
        menu.setText("About");

        menuItem.setMnemonicParsing(false);
        menuItem.setText("Close");

        textFlow.setPrefHeight(45.0);
        textFlow.setPrefWidth(602.0);

        label.setPrefHeight(21.0);
        label.setPrefWidth(103.0);
        label.setText("      ID       ");

        idTextField.setPrefHeight(31.0);
        idTextField.setPrefWidth(406.0);

        textFlow0.setPrefHeight(45.0);
        textFlow0.setPrefWidth(602.0);

        label0.setPrefHeight(21.0);
        label0.setPrefWidth(101.0);
        label0.setText("  First Name  ");

        firstNameTextField.setPrefHeight(31.0);
        firstNameTextField.setPrefWidth(412.0);

        textFlow1.setPrefHeight(45.0);
        textFlow1.setPrefWidth(602.0);

        label1.setPrefHeight(21.0);
        label1.setPrefWidth(101.0);
        label1.setText("  Midel Name ");

        midelNameTextField.setPrefHeight(31.0);
        midelNameTextField.setPrefWidth(414.0);

        textFlow2.setPrefHeight(45.0);
        textFlow2.setPrefWidth(602.0);

        label2.setPrefHeight(21.0);
        label2.setPrefWidth(102.0);
        label2.setText("  Last Name    ");

        lastNameTextField.setPrefHeight(31.0);
        lastNameTextField.setPrefWidth(412.0);

        textFlow3.setPrefHeight(45.0);
        textFlow3.setPrefWidth(602.0);

        label3.setPrefHeight(21.0);
        label3.setPrefWidth(104.0);
        label3.setText("  Email  ");

        emailTextField.setPrefHeight(31.0);
        emailTextField.setPrefWidth(415.0);

        textFlow4.setPrefHeight(45.0);
        textFlow4.setPrefWidth(602.0);

        label4.setPrefHeight(21.0);
        label4.setPrefWidth(108.0);
        label4.setText("  phone ");

        phoneTextField.setPrefHeight(31.0);
        phoneTextField.setPrefWidth(412.0);

        textFlow5.setPrefHeight(52.0);
        textFlow5.setPrefWidth(529.0);

        newSaveButton.setMnemonicParsing(false);
        newSaveButton.setPrefHeight(31.0);
        newSaveButton.setPrefWidth(68.0);
        newSaveButton.setText("New");
        newSaveButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
              public void handle(ActionEvent event) {

                newSaveButton.setText("New");

                if (isSave == false) {
                    isSave = true;
                    int val = -100;
                    try {
                        val = myDataAccessLayer.insert(idTextField.getText(),
                                firstNameTextField.getText(),
                                midelNameTextField.getText(),
                                lastNameTextField.getText(),
                                emailTextField.getText(),
                                phoneTextField.getText());
                        
                        idTextField.setDisable(true);
                        firstNameTextField.setDisable(true);
                        lastNameTextField.setDisable(true);
                        midelNameTextField.setDisable(true);
                        emailTextField.setDisable(true);
                        phoneTextField.setDisable(true);
                        
                                
                               
                    } catch (Exception ex) {
                        //   Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText(ex.getMessage());
                        alert.showAndWait();
                    }

                    if (val > 0) {
                        // how to change the color  for this ? 
                        outPuttextField.appendText("yes saved + \n");
                    } else {
                        outPuttextField.appendText("No check your connection+ \n");

                    }

                } else {
                        idTextField.setText(" ");
                        firstNameTextField.setText(" ");
                        midelNameTextField.setText(" ");
                        lastNameTextField.setText(" ");
                        emailTextField.setText(" ");
                        phoneTextField.setText(" ");
                        
                        
                    idTextField.setDisable(false);
                    firstNameTextField.setDisable(false);
                    lastNameTextField.setDisable(false);
                    midelNameTextField.setDisable(false);
                    emailTextField.setDisable(false);
                    phoneTextField.setDisable(false);
                    isSave = false;
                    
                    newSaveButton.setText("Save");
                }
            }
        });

        updateSaveButton.setMnemonicParsing(false);
        updateSaveButton.setText("Update");
        updateSaveButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                updateSaveButton.setText("Update");

                if (isUpdate == false) {
                    isUpdate = true;
                    int val = -100;
                    try {
                        val = myDataAccessLayer.update(idTextField.getText(),
                                firstNameTextField.getText(),
                                midelNameTextField.getText(),
                                lastNameTextField.getText(),
                                emailTextField.getText(),
                                phoneTextField.getText());
                        
                        idTextField.setDisable(true);
                        firstNameTextField.setDisable(true);
                        lastNameTextField.setDisable(true);
                        midelNameTextField.setDisable(true);
                        emailTextField.setDisable(true);
                        phoneTextField.setDisable(true);
                        
                                
                               
                    } catch (Exception ex) {
                        //   Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText(ex.getMessage());
                        alert.showAndWait();
                    }

                    if (val > 0) {
                        // how to change the color  for this ? 
                        outPuttextField.appendText("yes updated + \n");
                    } else {
                        outPuttextField.appendText("No check your connection+ \n");

                    }

                } else {
                    
                    firstNameTextField.setDisable(false);
                    lastNameTextField.setDisable(false);
                    midelNameTextField.setDisable(false);
                    emailTextField.setDisable(false);
                    phoneTextField.setDisable(false);
                    isUpdate = false;
                    updateSaveButton.setText("Save");
                    
                    System.out.println("update logic ");
                }
            }
        });

        deleteButton.setMnemonicParsing(false);
        deleteButton.setText("Delete");
        deleteButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    int val = myDataAccessLayer.delete(idTextField.getText());
                    if (val > 0) {
                        outPuttextField.appendText("yes deleted + \n");
                    } else {
                        outPuttextField.appendText("No check your connection+ \n");
                    }
                } catch (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText(ex.getMessage());
                    alert.showAndWait();
                }
            }
        });

        firstButton.setMnemonicParsing(false);
        firstButton.setText("First");
        firstButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    currentIndex = 0 ; 
                    ResultSet result = myDataAccessLayer.first();
                    //(ID, FIRSTNAME ,MIDDLENAME, LASTNAME , EMAIL,PHONE) 
                    if (result != null) {
                        String id = result.getString("ID");
                        String firstName = result.getString("FIRSTNAME");
                        String middleName = result.getString("MIDDLENAME");
                        String lastName = result.getString("LASTNAME");
                        String email = result.getString("EMAIL");
                        String phone = result.getString("PHONE");
                        
                        idTextField.setText(id);
                        firstNameTextField.setText(firstName);
                        midelNameTextField.setText(middleName);
                        lastNameTextField.setText(lastName);
                        emailTextField.setText(email);
                        phoneTextField.setText(phone);
                    } else {
                        System.out.println("No data found.");
                    }

                } catch (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText(ex.getMessage());
                    alert.showAndWait();
                }
            }
        });

        previousButton.setMnemonicParsing(false);
        previousButton.setText("Previous");

        nextButton.setMnemonicParsing(false);
        nextButton.setText("Next");
        nextButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    currentIndex+=1 ; 
                    ResultSet result = myDataAccessLayer.next(currentIndex);
                     
                    if (result != null) {
                        String id = result.getString("ID");
                        String firstName = result.getString("FIRSTNAME");
                        String middleName = result.getString("MIDDLENAME");
                        String lastName = result.getString("LASTNAME");
                        String email = result.getString("EMAIL");
                        String phone = result.getString("PHONE");
                        idTextField.setText(id);
                        firstNameTextField.setText(firstName);
                        midelNameTextField.setText(middleName);
                        lastNameTextField.setText(lastName);
                        emailTextField.setText(email);
                        phoneTextField.setText(phone);
                    } else {
                        System.out.println("No data found.");
                    }

                } catch (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText(ex.getMessage());
                    alert.showAndWait();
                }
            }
        });

        lastButton.setMnemonicParsing(false);
        lastButton.setText("Last");
        lastButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ResultSet result = myDataAccessLayer.last();
                    //(ID, FIRSTNAME ,MIDDLENAME, LASTNAME , EMAIL,PHONE) 
                    if (result != null) {
                        String id = result.getString("ID");
                        String firstName = result.getString("FIRSTNAME");
                        String middleName = result.getString("MIDDLENAME");
                        String lastName = result.getString("LASTNAME");
                        String email = result.getString("EMAIL");
                        String phone = result.getString("PHONE");
                        idTextField.setText(id);
                        firstNameTextField.setText(firstName);
                        midelNameTextField.setText(middleName);
                        lastNameTextField.setText(lastName);
                        emailTextField.setText(email);
                        phoneTextField.setText(phone);
                    } else {
                        System.out.println("No data found.");
                    }

                } catch (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText(ex.getMessage());
                    alert.showAndWait();
                }
            }
        });

        menu.getItems().add(menuItem);
        menuBar.getMenus().add(menu);
        getChildren().add(menuBar);
        textFlow.getChildren().add(label);
        textFlow.getChildren().add(idTextField);
        getChildren().add(textFlow);
        textFlow0.getChildren().add(label0);
        textFlow0.getChildren().add(firstNameTextField);
        getChildren().add(textFlow0);
        textFlow1.getChildren().add(label1);
        textFlow1.getChildren().add(midelNameTextField);
        getChildren().add(textFlow1);
        textFlow2.getChildren().add(label2);
        textFlow2.getChildren().add(lastNameTextField);
        getChildren().add(textFlow2);
        textFlow3.getChildren().add(label3);
        textFlow3.getChildren().add(emailTextField);
        getChildren().add(textFlow3);
        textFlow4.getChildren().add(label4);
        textFlow4.getChildren().add(phoneTextField);
        getChildren().add(textFlow4);
        textFlow5.getChildren().add(newSaveButton);
        textFlow5.getChildren().add(updateSaveButton);
        textFlow5.getChildren().add(deleteButton);
        textFlow5.getChildren().add(firstButton);
        textFlow5.getChildren().add(previousButton);
        textFlow5.getChildren().add(nextButton);
        textFlow5.getChildren().add(lastButton);
        textFlow5.getChildren().add(outPuttextField);
        getChildren().add(textFlow5);

    }
}

//                idTextField.getText();
//                firstNameTextField.getText();
//                midelNameTextField.getText();
//                lastNameTextField.getText();
//                emailTextField.getText();
//                phoneTextField.getText();            
