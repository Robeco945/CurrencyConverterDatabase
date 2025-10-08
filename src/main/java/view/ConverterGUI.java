package view;

import dao.CurrenciesDao;
import entity.Currency;
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
import java.util.List;

public class ConverterGUI extends Application{


    private ConverterController controller;
    CurrenciesDao cur = new CurrenciesDao();
    public void start(Stage stage) {
        this.controller = new ConverterController(this);

        GridPane adder = new GridPane();
        HBox all = new HBox();
        TextField name = new TextField("currency name");
        TextField abr = new TextField("abbreviation");
        TextField toUSD = new TextField("rate to USD");
        Button add = new Button("add");
        Button exit = new Button("exit");

        all.getChildren().add(name);
        all.getChildren().add(abr);
        all.getChildren().add(toUSD);
        all.getChildren().add(add);
        all.getChildren().add(exit);
        adder.add(all,0,0);

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
        Button addCur = new Button("Add new currency");

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
        layout.add(addCur,0,3);


        Scene scene1 = new Scene(layout);
        Scene scene2 = new Scene(adder);

        scene1.getStylesheets().add("style.css");
        scene2.getStylesheets().add("style.css");

        cur1.setOnAction(e -> cur1.setText(controller.change1()));
        cur2.setOnAction(e -> cur2.setText(controller.change2()));
        addCur.setOnAction(e -> {stage.setScene(scene2); stage.show();});
        exit.setOnAction(e -> {stage.setScene(scene1); stage.show();});

        add.setOnAction(e -> {
            String newName = name.getText();
            String abre = abr.getText();
            double exrate = Double.parseDouble(toUSD.getText());

            controller.addtoBut1(abre);
            controller.addtoBut2(abre);
            cur.persist(new Currency(newName, abre, exrate));

        });
        convert.setOnAction(e -> {
            double value = Double.parseDouble(enter.getText());
            String curr1 = cur1.getText();
            String curr2 = cur2.getText();
            double resultValue = controller.convert(value, curr1, curr2);
            DecimalFormat df = new DecimalFormat("#.######");
            result.setText(df.format(resultValue));
        });
        stage.setScene(scene1);
        stage.show();




        /*convert.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent change1){controller.convert(value,curr1,curr2);}
        });
        stage.show();*/
    }

}