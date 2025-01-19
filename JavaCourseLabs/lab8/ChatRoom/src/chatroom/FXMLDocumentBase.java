package chatroom;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextFlow;

public class FXMLDocumentBase extends BorderPane {

    protected final TextArea textArea;
    protected final TextFlow textFlow;
    protected final TextField textField;
    protected final Button button;
    protected final ButtonBar buttonBar;

    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;

    public FXMLDocumentBase() {

        textArea = new TextArea();
        textFlow = new TextFlow();
        textField = new TextField();
        button = new Button();
        buttonBar = new ButtonBar();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(420.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(279.0);
        textArea.setPrefWidth(600.0);
        setCenter(textArea);

        BorderPane.setAlignment(textFlow, javafx.geometry.Pos.CENTER);
        textFlow.setPrefHeight(1.0);
        textFlow.setPrefWidth(600.0);

        textField.setPrefHeight(36.0);
        textField.setPrefWidth(492.0);

        button.setMnemonicParsing(false);
        button.setText("Send");
        button.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textMessage;
                textMessage = textField.getText();

                try {
                    mySocket = new Socket("127.0.0.1", 5005);
                    ps = new PrintStream(mySocket.getOutputStream());
                    ps.println(textMessage);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }
                textField.clear();
            }
        });
        
        new HandelRequests(textArea);
        
        buttonBar.setPrefHeight(40.0);
        buttonBar.setPrefWidth(200.0);
        setBottom(textFlow);

        textFlow.getChildren().add(textField);
        textFlow.getChildren().add(button);
        textFlow.getChildren().add(buttonBar);

    }
}

class HandelRequests extends Thread {

    DataInputStream dis;
    Socket mySocket;
    TextArea textArea ; 
    public HandelRequests(TextArea textArea) {
        this.textArea = textArea  ; 
        start();
    }

    public void run() {
        while (true) {
            try {
                mySocket = new Socket("127.0.0.1", 5005);
                dis = new DataInputStream(mySocket.getInputStream());
                String replyMsg = dis.readLine();
                
                System.out.println("this is the inside");
                System.out.println("this is the clint " + replyMsg);
                textArea.appendText(replyMsg);
                textArea.appendText("\n");
                textArea.setDisable(true);
            } catch (IOException ex) {  
                Logger.getLogger(HandelRequests.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
