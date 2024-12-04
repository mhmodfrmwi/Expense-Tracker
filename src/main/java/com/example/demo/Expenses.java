package com.example.demo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.bson.Document;

import java.io.IOException;

public class Expenses {
    public Button homeBtn;
    public Button expensesBtn;
    public Button tipsBtn;
    public Button approvalBtn;
    public Button settingsBtn;
    public Button supportBtn;
    public Button newExpenseBtn;
    public Button addReceiptBtn;


    @FXML
    private TableView<Expense> expensesTable;

    @FXML
    private TableColumn<Expense, String> subjectColumn;

    @FXML
    private TableColumn<Expense, String> merchantColumn;

    @FXML
    private TableColumn<Expense, Double> amountColumn;

    @FXML
    private TableColumn<Expense, String> dateColumn;
    public Button refreshButton;


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
    @FXML
    private void initialize() {
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));
        merchantColumn.setCellValueFactory(new PropertyValueFactory<>("merchant"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        fetchExpenses();
    }
    @FXML
    private void fetchExpenses() {
        ObservableList<Expense> expenses = FXCollections.observableArrayList();

        try {
            MongoCollection<Document> collection = DB.getDatabase("expense-tracker-desktop").getCollection("expenses");
            MongoCursor<Document> cursor = collection.find().iterator();

            while (cursor.hasNext()) {
                Document doc = cursor.next();
                String subject = doc.getString("subject");
                String merchant = doc.getString("merchant");
                double total = doc.getDouble("total");
                String date = doc.getString("date");

                expenses.add(new Expense(subject, merchant, total, date));
            }

            cursor.close();
        } catch (Exception e) {
            System.err.println("Error fetching expenses: " + e.getMessage());
        }

        expensesTable.setItems(expenses);
    }
}
