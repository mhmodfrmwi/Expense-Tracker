package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Home {
    public Button homeBtn;
    public Button expensesBtn;
    public Button tipsBtn;
    public Button approvalBtn;
    public Button settingsBtn;
    public Button supportBtn;
    public Button newExpenseBtn;
    public Button addTripBtn;

    public void homeRouter(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 620);
        Stage stage = (Stage) homeBtn.getScene().getWindow();

        stage.setTitle("Home!");
        stage.setScene(scene);
    }

    public void expensesRouter(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("expenses.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 620);
        Stage stage = (Stage) expensesBtn.getScene().getWindow();

        stage.setTitle("Expenses!");
        stage.setScene(scene);
    }

    public void tipsRouter(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 620);
        Stage stage = (Stage) tipsBtn.getScene().getWindow();

        stage.setTitle("Tips!");
        stage.setScene(scene);
    }

    public void approvalRouter(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 620);
        Stage stage = (Stage) approvalBtn.getScene().getWindow();

        stage.setTitle("Approvals!");
        stage.setScene(scene);
    }

    public void settingsRouter(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 620);
        Stage stage = (Stage) settingsBtn.getScene().getWindow();

        stage.setTitle("Settings!");
        stage.setScene(scene);
    }

    public void supportRouter(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 620);
        Stage stage = (Stage) supportBtn.getScene().getWindow();

        stage.setTitle("Support!");
        stage.setScene(scene);
    }

    public void newExpenseController(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("newExpense.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 620);
        Stage stage = (Stage) newExpenseBtn.getScene().getWindow();

        stage.setTitle("New Expense!");
        stage.setScene(scene);
    }

    public void addTripController(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addTrip.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 620);
        Stage stage = (Stage) addTripBtn.getScene().getWindow();

        stage.setTitle("Add Trip!");
        stage.setScene(scene);
    }
}
