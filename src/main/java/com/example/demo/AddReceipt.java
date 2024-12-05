package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddReceipt {
    @FXML
    public TextField businessAddressField;
    @FXML
    public TextField customerNameField;
    @FXML
    public TextField customerPhoneField;
    @FXML
    public TextField employeeNameField;
    @FXML
    public TextField refrenceNumberField;
    @FXML
    public TextField merchentField;
    @FXML
    public TextField recieptNumberField;
    @FXML
    public Button back;

    @FXML
    private Button saveDraftButton, saveButton;

    public void initialize() {
        saveButton.setOnAction(event -> saveReceipt());
        saveDraftButton.setOnAction(event -> saveDraft());
    }

    private void saveReceipt() {
        if (validateForm()) {
            try {
                String receiptNumber = recieptNumberField.getText();
                String businessAddress = businessAddressField.getText();
                String customerName = customerNameField.getText();
                String customerPhone = customerPhoneField.getText();
                String employeeName = employeeNameField.getText();
                String referenceNumber = refrenceNumberField.getText();
                String merchant = merchentField.getText();

                Receipt receipt = new Receipt(receiptNumber, businessAddress, customerName, customerPhone, employeeName, referenceNumber, merchant);

                DB.saveReceipt(receipt);

                System.out.println("Receipt saved:");
                System.out.println("Receipt Number: " + receiptNumber + ", Customer Name: " + customerName + ", Merchant: " + merchant);
                showAlert(Alert.AlertType.INFORMATION, "Receipt Saved", "Your receipt has been successfully saved!");
            } catch (Exception e) {
                e.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Error", "Unable to save the receipt.");
            }
        }
    }

    private void saveDraft() {
        showAlert(Alert.AlertType.INFORMATION, "Draft Saved", "Your receipt draft has been saved.");
    }

    private boolean validateForm() {
        if (recieptNumberField.getText().isEmpty() || businessAddressField.getText().isEmpty() ||
                customerNameField.getText().isEmpty() || customerPhoneField.getText().isEmpty() ||
                employeeNameField.getText().isEmpty() || refrenceNumberField.getText().isEmpty() ||
                merchentField.getText().isEmpty()) {
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

    public void Back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 620);
        Stage stage = (Stage) back.getScene().getWindow();

        stage.setTitle("Add Trip!");
        stage.setScene(scene);
    }
}
