/* https://github.com/theta148/Lab04-MihirPatel.git
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafxdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    private GridPane gp;
    private TextField daysField = new TextField();
    private TextField airfaresField = new TextField();
    private TextField carRentalFeesField = new TextField();
    private TextField milesDrivenField = new TextField();
    private TextField parkingFeesField = new TextField();
    private TextField taxiChargesField = new TextField();
    private TextField registrationFeesField = new TextField();
    private TextField lodgingChargesField = new TextField();
    private Label totalExpensesLabel;
    private Label allowableExpensesLabel;
    private Label leftOverExpenses;
    private Label amountSavedLabel;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
   
    @Override
    public void start(Stage primaryStage) {
        gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(15, 15, 15, 15));
        
        Label daysLabel = new Label("Number of days on the trip: ");
        daysField = new TextField();
        gp.add(daysLabel, 0, 0);
        gp.add(daysField, 1, 0);
        
        Label airfaresLabel = new Label("Amount of airfares, if any: ");
        airfaresField = new TextField();
        gp.add(airfaresLabel, 0, 1);
        gp.add(airfaresField, 1, 1);
        
        Label carRentalFeesLabel = new Label("Amount of car rental fees, if any: ");
        carRentalFeesField = new TextField();
        gp.add(carRentalFeesLabel, 0, 2);
        gp.add(carRentalFeesField, 1, 2);
        
        Label milesDrivenLabel = new Label("Number of miles driven, if a private vehicule was used: ");
        milesDrivenField = new TextField();
        gp.add(milesDrivenLabel, 0, 3);
        gp.add(milesDrivenField, 1, 3);
        
        Label parkingFeesLabel = new Label("Amount of parking fees, if any: ");
        parkingFeesField = new TextField();
        gp.add(parkingFeesLabel, 0, 4);
        gp.add(parkingFeesField, 1, 4);
        
        Label taxiChargesLabel = new Label("Amount of taxi charges, if any: ");
        taxiChargesField = new TextField();
        gp.add(taxiChargesLabel, 0, 5);
        gp.add(taxiChargesField, 1, 5);
        
        Label registrationFeesLabel = new Label("Conference or seminar registration fees, if any: ");
        registrationFeesField = new TextField();
        gp.add(registrationFeesLabel, 0, 6);
        gp.add(registrationFeesField, 1, 6);
        
        Label lodgingChargesLabel = new Label("Lodging charges, per night: ");
        lodgingChargesField = new TextField();
        gp.add(lodgingChargesLabel, 0, 7);
        gp.add(lodgingChargesField, 1, 7);
        
        Button btn = new Button("OK");
        gp.add(btn, 1, 8);
        btn.setOnAction(new ButtonClickHandler());
        
        
        //double mealCosts = 37;
        //double parkingFees = 10 * Double.parseDouble(dayStr);
        //double taxiCharge = 20 * Double.parseDouble(taxiChargeStr);
        //double lodgingCharge = 95 * Double.parseDouble(lodgingStr);
        //double vehiculeCharge = 0.27 * Double.parseDouble(mileStr);
        
        Scene scene = new Scene(gp, 500, 500);
        //scene.getStylesheets().add("demo1.css");
        
        primaryStage.setTitle("Business Trip Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
    class ButtonClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            double daysNum = Double.parseDouble(daysField.getText());
            double airfareCost = Double.parseDouble(airfaresField.getText());
            double carRentalFees = Double.parseDouble(carRentalFeesField.getText());
            double milesDriven = Double.parseDouble(milesDrivenField.getText());
            double parkingFees = Double.parseDouble(parkingFeesField.getText());
            double taxiCharges = Double.parseDouble(taxiChargesField.getText());
            double registrationFees = Double.parseDouble(registrationFeesField.getText());
            double lodgingCharges = Double.parseDouble(lodgingChargesField.getText());
 
            double totalExpenses = airfareCost + carRentalFees + (milesDriven * 0.27) + parkingFees + taxiCharges + registrationFees + (lodgingCharges * daysNum);
            totalExpensesLabel = new Label(String.format("Total Expenses: $%.2f", totalExpenses));
            gp.add(totalExpensesLabel, 0, 8);
            
            double allowableExpenses = (37 * daysNum) + (10 * daysNum) + (20 * daysNum) + (95 * daysNum) + (0.27 * milesDriven);
            allowableExpensesLabel = new Label(String.format("Total Allowable Expenses: $%.2f", allowableExpenses));
            gp.add(allowableExpensesLabel, 0, 9);
            
            double expenseDifference = totalExpenses - allowableExpenses;
            double amountSaved = -expenseDifference;
            
            if (expenseDifference > 0) {
                leftOverExpenses = new Label(String.format("Leftover Expenses paid by the business person: $%.2f", expenseDifference));
                amountSavedLabel = new Label("The amount saved by the business person: $0");
                gp.add(leftOverExpenses, 0, 10);
                gp.add(amountSavedLabel, 0, 11);
                
            } else {
                leftOverExpenses = new Label("Leftover Expenses paid by the business person: $0");
                amountSavedLabel = new Label(String.format("The amount saved by the business person: $%.2f", amountSaved));
                gp.add(leftOverExpenses, 0, 10);
                gp.add(amountSavedLabel, 0, 11);
            }
        }
    }
    
}
