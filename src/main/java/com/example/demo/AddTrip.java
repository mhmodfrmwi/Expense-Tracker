package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class AddTrip {

    @FXML
    private TextField nameField, purposeField, departField, destinationField, budgetField, hotelField;
    @FXML
    private ComboBox<String> typeComboBox;
    @FXML
    private Button saveDraftButton, saveButton;

    public void initialize() {
        typeComboBox.getItems().addAll("Domestic", "International");
        typeComboBox.setValue("Domestic");

        saveButton.setOnAction(event -> saveTrip());
        saveDraftButton.setOnAction(event -> saveDraft());
    }

    private void saveTrip() {
        if (validateForm()) {
            try {
                String name = nameField.getText();
                String purpose = purposeField.getText();
                String type = typeComboBox.getValue();
                String departFrom = departField.getText();
                String destination = destinationField.getText();
                String budget = budgetField.getText();
                String hotel = hotelField.getText();
                Trip trip = new Trip(name, purpose, type, departFrom, destination, budget, hotel);
                DB.saveTrip(trip);
                System.out.println("Trip saved:");
                System.out.println("Name: " + name + ", Type: " + type + ", Purpose: " + purpose);

                showAlert(Alert.AlertType.INFORMATION, "Trip Saved", "Your trip has been successfully saved!");
            } catch (Exception e) {
                e.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Error", "Unable to save trip.");
            }
        }
    }

    private void saveDraft() {
        showAlert(Alert.AlertType.INFORMATION, "Draft Saved", "Your trip draft has been saved.");
    }

    private boolean validateForm() {
        if (nameField.getText().isEmpty() || purposeField.getText().isEmpty() ||
                departField.getText().isEmpty() || destinationField.getText().isEmpty() ||
                budgetField.getText().isEmpty() || hotelField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please fill all required fields.");
            return false;
        }
        return true;
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
