package formdb;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.TextFlow;

public abstract class FXMLDocumentBasenew extends FlowPane {

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
    protected final Button newSaveButton;
    protected final Button updateSaveButton;
    protected final Button deleteButton;
    protected final Button firstButton;
    protected final Button previousButton;
    protected final Button nextButton;
    protected final Button lastButton;
    protected final TextField outPuttextField;

    public FXMLDocumentBasenew() {

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
        newSaveButton = new Button();
        updateSaveButton = new Button();
        deleteButton = new Button();
        firstButton = new Button();
        previousButton = new Button();
        nextButton = new Button();
        lastButton = new Button();
        outPuttextField = new TextField();

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

        updateSaveButton.setMnemonicParsing(false);
        updateSaveButton.setText("Update");

        deleteButton.setMnemonicParsing(false);
        deleteButton.setText("Delete");

        firstButton.setMnemonicParsing(false);
        firstButton.setText("First");

        previousButton.setMnemonicParsing(false);
        previousButton.setText("Previous");

        nextButton.setMnemonicParsing(false);
        nextButton.setText("Next");

        lastButton.setMnemonicParsing(false);
        lastButton.setText("Last");

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
