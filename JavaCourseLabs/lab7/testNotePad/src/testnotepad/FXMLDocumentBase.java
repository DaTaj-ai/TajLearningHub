package testnotepad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.IndexRange;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXMLDocumentBase extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu menu;
    protected final MenuItem newMenuItem;
    protected final MenuItem openMenuItemLow;
    protected final MenuItem saveMenuItemLow;
    protected final MenuItem exitMenuItem;
    protected final MenuItem openMenuItemHigh;
    protected final MenuItem saveMenuItemHigh;
    protected final Menu menu0;
    protected final MenuItem copyMenuItem;
    protected final MenuItem pasteMenuItem;
    protected final MenuItem cutMenuItem;
    protected final MenuItem deleteMenuItem;
    protected final MenuItem selectAllMenuItem;
    protected final Menu menu1;
    protected final MenuItem aboutMeniItem;
    protected final TextArea textArea;
    private Stage mystage;

    public FXMLDocumentBase(Stage stage) {
        mystage = stage;
        menuBar = new MenuBar();
        menu = new Menu();
        newMenuItem = new MenuItem();
        openMenuItemLow = new MenuItem();
        saveMenuItemLow = new MenuItem();
        exitMenuItem = new MenuItem();
        openMenuItemHigh = new MenuItem();
        saveMenuItemHigh = new MenuItem();
        menu0 = new Menu();
        copyMenuItem = new MenuItem();
        pasteMenuItem = new MenuItem();
        cutMenuItem = new MenuItem();
        deleteMenuItem = new MenuItem();
        selectAllMenuItem = new MenuItem();
        menu1 = new Menu();
        aboutMeniItem = new MenuItem();
        textArea = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);

        menu.setMnemonicParsing(false);
        menu.setText("File");

        newMenuItem.setMnemonicParsing(false);
        newMenuItem.setText("New");
        newMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));

        newMenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.clear();
            }
        });

        openMenuItemLow.setMnemonicParsing(false);
        openMenuItemLow.setText("Open Low");
        openMenuItemLow.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        openMenuItemLow.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fc = new FileChooser();
                    
                File file = fc.showOpenDialog(stage);

                if (file != null) {
                    
                    
                    try {
                        FileInputStream fis = new FileInputStream(file);
                        int size = fis.available();
                        byte[] b = new byte[size];
                        fis.read(b);
                        textArea.setText(new String(b));
                        fis.close();
                        fis = new FileInputStream(file);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    

                }
            }
        });
        
        saveMenuItemLow.setMnemonicParsing(false);
        saveMenuItemLow.setText("Save Low");
        saveMenuItemLow.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        saveMenuItemLow.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fc = new FileChooser();
                    
                File file = fc.showSaveDialog(stage);

                if (file != null) {
                    FileOutputStream fos;
                    try {
                        fos = new FileOutputStream(file);
                         byte[] b = textArea.getText().getBytes();
                         fos.write(b);
                         fos.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }


            }
        });

        exitMenuItem.setMnemonicParsing(false);
        exitMenuItem.setText("Exit");
        exitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
        exitMenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });

        openMenuItemHigh.setMnemonicParsing(false);
        openMenuItemHigh.setText("Open High");
        openMenuItemHigh.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));

        saveMenuItemHigh.setMnemonicParsing(false);
        saveMenuItemHigh.setText("Save High");
        saveMenuItemHigh.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        saveMenuItemHigh.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fc = new FileChooser();
                    
                File file = fc.showSaveDialog(stage);

                if (file != null) {
                    FileOutputStream fos;
                    try {
                        fos = new FileOutputStream(file);
                         byte[] b = textArea.getText().getBytes();
                         fos.write(b);
                         fos.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }}});
        
        
        menu0.setMnemonicParsing(false);
        menu0.setText("Edit");

        copyMenuItem.setMnemonicParsing(false);
        copyMenuItem.setText("Copy");
        copyMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
        copyMenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.copy();
            }
        });

        pasteMenuItem.setMnemonicParsing(false);
        pasteMenuItem.setText("Paste");
        pasteMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN));
        pasteMenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.paste();
            }
        });

        cutMenuItem.setMnemonicParsing(false);
        cutMenuItem.setText("Cut");
        cutMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
        cutMenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.cut();
            }
        });

        deleteMenuItem.setMnemonicParsing(false);
        deleteMenuItem.setText("Delete");
        deleteMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN));
        deleteMenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("this is the selected range " + textArea.getSelectedText());
                IndexRange selectedRange = textArea.getSelection();
                textArea.deleteText(selectedRange);
            }
        });

        selectAllMenuItem.setMnemonicParsing(false);
        selectAllMenuItem.setText("Select All ");
        selectAllMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        selectAllMenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.selectAll();
            }
        });

        menu1.setMnemonicParsing(false);
        menu1.setText("Help");

        aboutMeniItem.setMnemonicParsing(false);
        aboutMeniItem.setText("About");
        aboutMeniItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showPopup();
            }

            private void showPopup() {
                // Create a new Stage for the popup
                Stage popupStage = new Stage();
                popupStage.initModality(Modality.APPLICATION_MODAL); // Block interaction with the main window

                // Create content for the popup
                VBox popupContent = new VBox();
                popupContent.setSpacing(10);
                popupContent.setPadding(new Insets(10));

                Label label = new Label("This is an About popup!");
                Button closeButton = new Button("Close");
                closeButton.setOnAction(e -> popupStage.close());

                popupContent.getChildren().addAll(label, closeButton);

                // Set the scene for the popup
                Scene popupScene = new Scene(popupContent, 300, 150);
                popupStage.setScene(popupScene);

                // Set popup title and show it
                popupStage.setTitle("About");
                popupStage.showAndWait();
            }

        });

        setTop(menuBar);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        setCenter(textArea);

        menu.getItems().add(newMenuItem);
        menu.getItems().add(openMenuItemLow);
        menu.getItems().add(saveMenuItemLow);
        menu.getItems().add(exitMenuItem);
        menu.getItems().add(openMenuItemHigh);
        menu.getItems().add(saveMenuItemHigh);
        menuBar.getMenus().add(menu);
        menu0.getItems().add(copyMenuItem);
        menu0.getItems().add(pasteMenuItem);
        menu0.getItems().add(cutMenuItem);
        menu0.getItems().add(deleteMenuItem);
        menu0.getItems().add(selectAllMenuItem);
        menuBar.getMenus().add(menu0);
        menu1.getItems().add(aboutMeniItem);
        menuBar.getMenus().add(menu1);

    }
}
