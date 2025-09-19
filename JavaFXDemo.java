/* https://github.com/theta148/Lab04-MihirPatel
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafxdemo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author 6316704
 */
public class JavaFXDemo extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25, 25, 25, 25));
        
        Label daysLabel = new Label("Number of days on the trip: ");
        TextField daysField = new TextField();
        gp.add(daysLabel, 0, 0);
        gp.add(daysField, 1, 0);
        
        Label airfaresLabel = new Label("Amount of airfares, if any: ");
        TextField airfaresField = new TextField();
        gp.add(airfaresLabel, 0, 1);
        gp.add(airfaresField, 1, 1);
        
        Label carRentalFeesLabel = new Label("Amount of car rental fees, if any: ");
        TextField carRentalFeesField = new TextField();
        gp.add(carRentalFeesLabel, 0, 2);
        gp.add(carRentalFeesField, 1, 2);
        
        Label milesDrivenLabel = new Label("Miles driven, if a private vehicule was used: ");
        TextField milesDrivenField = new TextField();
        gp.add(milesDrivenLabel, 0, 3);
        gp.add(milesDrivenField, 1, 3);
        
        Label carRentalFeesLabel = new Label("Amount of car rental fees, if any: ");
        TextField field = new TextField();
        gp.add(label, 0, 4);
        gp.add(field, 1, 4);
        
        Scene scene = new Scene(gp, 500, 400);
        scene.getStylesheets().add("demo1.css");
        
        primaryStage.setTitle("Business Trip Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
