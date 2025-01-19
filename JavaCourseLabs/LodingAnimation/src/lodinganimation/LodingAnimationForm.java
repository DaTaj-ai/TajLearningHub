package lodinganimation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import static lodinganimation.LodingAnimationController.setRotate;

public abstract class LodingAnimationForm extends AnchorPane {

    protected final Circle c1;
    protected final Circle c2;
    protected final Circle c3;
    protected final Button button;

    public LodingAnimationForm() {

        c1 = new Circle();
        c2 = new Circle();
        c3 = new Circle();
        button = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(695.0);
        setStyle("-fx-background-color: black;");

        c1.setFill(javafx.scene.paint.Color.valueOf("#ff000000"));
        c1.setLayoutX(346.0);
        c1.setLayoutY(186.0);
        c1.setRadius(129.0);
        c1.setStroke(javafx.scene.paint.Color.valueOf("#3651ff"));
        c1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        c1.setStrokeWidth(15.0);
        c1.setStyle("-fx-stroke-dash-array: 50;");

        c2.setFill(javafx.scene.paint.Color.valueOf("#ff000000"));
        c2.setLayoutX(346.0);
        c2.setLayoutY(187.0);
        c2.setRadius(91.0);
        c2.setStroke(javafx.scene.paint.Color.valueOf("#9bf000"));
        c2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        c2.setStrokeWidth(13.0);
        c2.setStyle("-fx-stroke-dash-array: 50;");

        c3.setFill(javafx.scene.paint.Color.valueOf("#ff000000"));
        c3.setLayoutX(347.0);
        c3.setLayoutY(186.0);
        c3.setRadius(54.0);
        c3.setStroke(javafx.scene.paint.Color.valueOf("#00f0c8"));
        c3.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        c3.setStrokeWidth(10.0);
        c3.setStyle("-fx-stroke-dash-array: 50;");

        button.setLayoutX(316.0);
        button.setLayoutY(349.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(31.0);
        button.setPrefWidth(76.0);
        button.setText("Play");

        
        getChildren().add(c1);
        getChildren().add(c2);
        getChildren().add(c3);
        getChildren().add(button);

    }
}
