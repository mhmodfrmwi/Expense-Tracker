package com.example.demo;

import com.mongodb.client.MongoCollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.bson.Document;

import java.io.IOException;

public class NewExpense {
    @FXML
    public Button submitBtn;
    public Button backBtn;
    @FXML
    private TextField subjectTxt, merchantTxt, totalTxt, employeeTxt;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ComboBox<String> currencyCombo, categoryCombo;
    @FXML
    private TextArea descriptionTxt;
    @FXML
    private RadioButton yesRadio, noRadio;
    @FXML
    private ToggleGroup addToReportGroup;
    @FXML
    public void initialize() {
        currencyCombo.getItems().addAll("USD", "EUR", "GBP", "EGP", "JPY");

        categoryCombo.getItems().addAll("Food", "Travel", "Accommodation", "Utilities", "Entertainment", "Others");
    }

    public void handleSubmit() {
        try {
            String subject = subjectTxt.getText();
            String merchant = merchantTxt.getText();
            String date = datePicker.getValue().toString();
            double total = Double.parseDouble(totalTxt.getText());
            String currency = currencyCombo.getValue();
            String category = categoryCombo.getValue();
            String description = descriptionTxt.getText();
            String employee = employeeTxt.getText();
            boolean addToReport = yesRadio.isSelected();

            Document expense = new Document()
                    .append("subject", subject)
                    .append("merchant", merchant)
                    .append("date", date)
                    .append("total", total)
                    .append("currency", currency)
                    .append("category", category)
                    .append("description", description)
                    .append("employee", employee)
                    .append("addToReport", addToReport);

            MongoCollection<Document> collection = DB.getDatabase("expense-tracker-desktop").getCollection("expenses");
            collection.insertOne(expense);

            System.out.println("Expense added successfully!");
        } catch (Exception e) {
            System.err.println("Error adding expense: " + e.getMessage());
        }
    }

    public void backController(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 620);
        Stage stage = (Stage) backBtn.getScene().getWindow();

        stage.setTitle("Home!");
        stage.setScene(scene);
    }
}
