package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class AddReport {
    @FXML
    private TextField reportTitleField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField summaryField;

    @FXML
    private TextArea contentField;

    @FXML
    private TextField tagsField;

    @FXML
    private Button saveDraftButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    @FXML
    public void initialize() {
    }

    @FXML
    private void handleSaveDraft() {
        if (validateInputs()) {
            showAlert(Alert.AlertType.INFORMATION, "Draft Saved", "Your report draft has been saved successfully.");
        }
    }

    @FXML
    private void handleSave() {
        if (validateInputs()) {
            saveReportToDatabase();
            showAlert(Alert.AlertType.INFORMATION, "Report Saved", "Your report has been saved successfully.");
        }
    }

    @FXML
    private void handleBack() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 620);
        Stage stage = (Stage) backButton.getScene().getWindow();

        stage.setTitle("Add Trip!");
        stage.setScene(scene);
    }

    private boolean validateInputs() {
        if (reportTitleField.getText().isEmpty() || authorField.getText().isEmpty() ||
               summaryField.getText().isEmpty() ||
                contentField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "All fields except 'Tags' are required.");
            return false;
        }
        return true;
    }

    private void saveReportToDatabase() {
        try {
            String title = reportTitleField.getText().trim();
            String author = authorField.getText().trim();
            String summary = summaryField.getText().trim();
            String content = contentField.getText().trim();
            String tags = tagsField.getText().trim();

            if (title.isEmpty() || author.isEmpty() || summary.isEmpty() || content.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Validation Error", "Please fill in all required fields.");
                return;
            }

            Report report = new Report(title, author, LocalDate.now(), summary, content, tags);

            DB.saveReport(report);

            System.out.println("Report saved successfully:");
            System.out.println("Title: " + title + ", Author: " + author + ", Date: " + report.getDate());

            showAlert(Alert.AlertType.INFORMATION, "Report Saved", "Your report has been successfully saved!");

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Save Error", "An error occurred while saving the report. Please try again.");
        }
    }


    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
