package com.example.demo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.bson.Document;

import java.io.IOException;

public class Login {
    @FXML
    private Button loginBtn;

    @FXML
    private Button registerBtn;
    @FXML
    private TextField emailTxt;
    @FXML
    private PasswordField passwordTxt;
    @FXML
    private Label errorLabel;

    public void registerController(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 540);
        Stage stage = (Stage) registerBtn.getScene().getWindow();

        stage.setTitle("Register");
        stage.setScene(scene);
    }


    public void loginController(ActionEvent actionEvent) throws IOException {
        String email = emailTxt.getText();
        String password = passwordTxt.getText();

        MongoDatabase database = DB.getDatabase("expense-tracker-desktop");
        MongoCollection<Document> usersCollection = database.getCollection("users");

        Document query = new Document("email", email).append("password", password);
        Document user = usersCollection.find(query).first();
        if (user != null) {
            errorLabel.setText("Login successful!");
        } else {
            errorLabel.setText("email or password incorrect.");
            return;
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 620);
        Stage stage = (Stage) loginBtn.getScene().getWindow();

        stage.setTitle("Home!");
        stage.setScene(scene);
    }

}
