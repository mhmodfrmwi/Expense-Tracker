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

public class Trips {
    public Button homeBtn;
    public Button expensesBtn;
    public Button tipsBtn;
    public Button approvalBtn;
    public Button settingsBtn;
    public Button supportBtn;
    public Button addTripBtn;
    @FXML
    private TableView<Trip> tripsTable;

    @FXML
    private TableColumn<Trip, String> nameColumn;
    @FXML
    private TableColumn<Trip, String> typeColumn;
    @FXML
    private TableColumn<Trip, String> departFromColumn;
    @FXML
    private TableColumn<Trip, String> destinationColumn;

    @FXML
    private Button addTripButton;

    @FXML
    public void initialize() {
        // Initialize columns with properties
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        departFromColumn.setCellValueFactory(new PropertyValueFactory<>("departFrom"));
        destinationColumn.setCellValueFactory(new PropertyValueFactory<>("destination"));

        // Example data setup
        fetchTrips();
    }
    private void fetchTrips() {
        ObservableList<Trip> trips = FXCollections.observableArrayList();

        try {
            MongoCollection<Document> collection = DB.getDatabase("expense-tracker-desktop").getCollection("trips");
            MongoCursor<Document> cursor = collection.find().iterator();

            while (cursor.hasNext()) {
                Document doc = cursor.next();
                String name = doc.getString("name");
                String type = doc.getString("type");
                String departFrom = doc.getString("departFrom");
                String destination = doc.getString("destination");

                trips.add(new Trip(name,type,departFrom,destination));
            }

            cursor.close();
        } catch (Exception e) {
            System.err.println("Error fetching expenses: " + e.getMessage());
        }

        tripsTable.setItems(trips);

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

    public void handleAddTrip(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addTrip.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 620);
        Stage stage = (Stage) addTripBtn.getScene().getWindow();

        stage.setTitle("Add Trip!");
        stage.setScene(scene);
    }
}
