package com.example.demo;
import com.mongodb.client.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.bson.Document;
public class DB {
    private static final Dotenv dotenv = Dotenv.configure().directory("src/main/resources").load();

    private static final String CONNECTION_STRING = dotenv.get("MONGO_URI");
    private static final String DATABASE_NAME = "expense-tracker-desktop";
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    static {
        mongoClient = MongoClients.create(CONNECTION_STRING);
        database = mongoClient.getDatabase(DATABASE_NAME);
    }

    public static MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }
    public static MongoDatabase getDatabase(String databaseName) {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(CONNECTION_STRING);
        }
        System.out.println("Connected to database: " + databaseName);
        return mongoClient.getDatabase(databaseName);
    }

    public static void saveTrip(Trip trip) {
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection("trips");

            Document tripDoc = new Document()
                    .append("name", trip.getName())
                    .append("type", trip.getType())
                    .append("purpose", trip.getPurpose())
                    .append("departFrom", trip.getDepartFrom())
                    .append("destination", trip.getDestination())

                    .append("budget", trip.getBudget())

                    .append("hotel", trip.getHotel());

            collection.insertOne(tripDoc);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void saveReceipt(Receipt receipt) {
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection("receipts");

            Document receiptDoc = new Document()
                    .append("receiptNumber", receipt.getReceiptNumber())
                    .append("businessAddress", receipt.getBusinessAddress())
                    .append("customerName", receipt.getCustomerName())
                    .append("customerPhone", receipt.getCustomerPhone())
                    .append("employeeName", receipt.getEmployeeName())
                    .append("referenceNumber", receipt.getReferenceNumber())
                    .append("merchant", receipt.getMerchant());

            collection.insertOne(receiptDoc);

            System.out.println("Receipt saved successfully: " + receipt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void saveReport(Report report) {
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection("reports");

            Document reportDoc = new Document()
                    .append("title", report.getTitle())
                    .append("author", report.getAuthor())
                    .append("date", report.getDate().toString())
                    .append("summary", report.getSummary())
                    .append("content", report.getContent())
                    .append("tags", report.getTags());

            collection.insertOne(reportDoc);

            System.out.println("Report saved successfully: " + report);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
