package com.example.demo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.bson.Document;

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
    public TableColumn subjectColumn;
    public TableColumn merchantColumn;
    public TableColumn totalColumn;
    public TableColumn dateColumn;
    public Label tripsCount;
    public Label expensesCount;
    public Button addReportBtn;
    public Button addReceipt;
    @FXML
    private TableView<Expense> recentExpensesTable;
    @FXML
    private AnchorPane recentExpensesPane;
    public void initialize() {
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));
        merchantColumn.setCellValueFactory(new PropertyValueFactory<>("merchant"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        tripsCount.setText(String.valueOf((DB.getDatabase("expense-tracker-desktop").getCollection("trips").countDocuments())));
        expensesCount.setText(String.valueOf((DB.getDatabase("expense-tracker-desktop").getCollection("expenses").countDocuments())));
        fetchRecentExpenses();
    }
    @FXML
    private void fetchRecentExpenses() {
        ObservableList<Expense> recentExpenses = FXCollections.observableArrayList();

        try {
            MongoCollection<Document> collection = DB.getDatabase("expense-tracker-desktop").getCollection("expenses");

            MongoCursor<Document> cursor = collection.find().iterator();

            while (cursor.hasNext()) {
                Document doc = cursor.next();
                String subject = doc.getString("subject");
                String merchant = doc.getString("merchant");
                double total = doc.getDouble("total");
                String date = doc.getString("date");

                recentExpenses.add(new Expense(subject, merchant, total, date));
            }

            cursor.close();

        } catch (Exception e) {
            System.err.println("Error fetching recent expenses: " + e.getMessage());
        }
        recentExpensesTable.setItems(recentExpenses);
    }


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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("trips.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 620);
        Stage stage = (Stage) tipsBtn.getScene().getWindow();

        stage.setTitle("Trips!");
        stage.setScene(scene);
    }

    public void approvalRouter(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("reports.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 620);
        Stage stage = (Stage) approvalBtn.getScene().getWindow();

        stage.setTitle("Reports!");
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

    public void addReportController(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addReport.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 620);
        Stage stage = (Stage) addReportBtn.getScene().getWindow();

        stage.setTitle("Add Report!");
        stage.setScene(scene);
    }

    public void addReceiptController(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addReceipt.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 620);
        Stage stage = (Stage) addReceipt.getScene().getWindow();

        stage.setTitle("Add Receipt!");
        stage.setScene(scene);
    }
}
