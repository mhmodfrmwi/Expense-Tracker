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
import javafx.stage.Stage;
import org.bson.Document;

import java.io.IOException;
import java.time.LocalDate;

public class Reports {
    public Button homeBtn;
    public Button expensesBtn;
    public Button reportsBtn;
    public Button settingsBtn;
    public TableColumn titleColumn;
    public TableColumn authorColumn;
    public TableColumn dateColumn;
    public TableColumn summaryColumn;
    public TableColumn tagsColumn;
    public Button refreshButton;
    private final MongoCollection<Document> reportsCollection = DB.getDatabase("expense-tracker-desktop").getCollection("reports");
    @FXML
    private TableView<Report> reportsTable;
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

    public void reportsRouter(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("reports.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 620);
        Stage stage = (Stage) reportsBtn.getScene().getWindow();

        stage.setTitle("Reports!");
        stage.setScene(scene);
    }

    public void settingsRouter(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("settings.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 620);
        Stage stage = (Stage) settingsBtn.getScene().getWindow();

        stage.setTitle("Settings!");
        stage.setScene(scene);
    }

    @FXML
    public void initialize() {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        summaryColumn.setCellValueFactory(new PropertyValueFactory<>("summary"));
        tagsColumn.setCellValueFactory(new PropertyValueFactory<>("tags"));

        ObservableList<Report> reportList = FXCollections.observableArrayList(
                new Report("Annual Report", "John Doe", LocalDate.of(2024, 12, 1), "Overview of 2024 performance", "Detailed content here", "business, 2024"),
                new Report("Project Update", "Jane Smith", LocalDate.of(2024, 11, 15), "Progress report for Project X", "Full content here", "project, update")
        );
        reportsTable.setItems(reportList);
        fetchReports();
    }
    @FXML
    public void fetchReports() {
        ObservableList<Report> reportList = FXCollections.observableArrayList();

        try (MongoCursor<Document> cursor = reportsCollection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                String title = doc.getString("title");
                String author = doc.getString("author");
                String date = doc.getString("date");
                String summary = doc.getString("summary");
                String tags = doc.getString("tags");
                System.out.println(date);
                reportList.add(new Report(title, author, date, summary, "", tags));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        reportsTable.setItems(reportList);
    }
}
