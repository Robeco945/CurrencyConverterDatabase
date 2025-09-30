package view;

import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import application.ConverterController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.text.DecimalFormat;

public class ConverterGUI extends Application{


    private ConverterController controller;
    public void start(Stage stage) {
        this.controller = new ConverterController(this);

        GridPane layout = new GridPane();
        HBox inner = new HBox();
        BorderPane title1 = new BorderPane();

        
        stage.setTitle("Currency converter");

        Label help = new Label("select your base currency, goal currency, enter your amount, and then press convert");
        layout.add(help,0,0);

        Button cur1 = new Button("EUR");
        Button cur2 = new Button("VND");
        Button convert = new Button("Convert");
        TextField result = new TextField("Results");
        TextField enter = new TextField("5");

        title1.setLeft(new Label("Source currency"));

        title1.setCenter(new Label("Convert button"));

        title1.setRight(new Label("Goal currency"));

        inner.getChildren().add(cur1);
        inner.getChildren().add(enter);
        inner.getChildren().add(convert);
        inner.getChildren().add(result);
        inner.getChildren().add(cur2);
        layout.add(inner,0,1);
        layout.add(title1,0,2);


        Scene scene = new Scene(layout);

        scene.getStylesheets().add("style.css");

        cur1.setOnAction(e -> cur1.setText(controller.change1()));
        cur2.setOnAction(e -> cur2.setText(controller.change2()));

        convert.setOnAction(e -> {
            double value = Double.parseDouble(enter.getText());
            String curr1 = cur1.getText();
            String curr2 = cur2.getText();
            double resultValue = controller.convert(value, curr1, curr2);
            DecimalFormat df = new DecimalFormat("#.######");
            result.setText(df.format(resultValue));
        });
        stage.setScene(scene);
        stage.show();




        /*convert.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent change1){controller.convert(value,curr1,curr2);}
        });
        stage.show();*/
    }

}