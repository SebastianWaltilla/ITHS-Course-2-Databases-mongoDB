package main.java;
import com.mongodb.Block;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.FileNotFoundException;


public class main {

    public static void main(String[] args) {

        // Fill database from json file.
        jsonReader file = new jsonReader();
        saveToMongoDB save = new saveToMongoDB();

        try {
           //method for taking a json-file and parse it to a ArrayList with objects of type cafe
           file.parseAndSaveToClass("C:\\Users\\sebas\\IdeaProjects\\MongoDBJava\\src\\main\\resources\\cafe");
           //method for sent the ArrayList to mongoDB local server
           save.saveToMongoDBMethod(file.getCafeClasses());

        } catch (FileNotFoundException e) {
            System.out.println("Error, path wrong or json in wrong");
        }

        // Methods for access and change mongodb lab3, collection resturants

        MongoClient client= MongoClients.create();
        MongoDatabase database = client.getDatabase("lab3");
        MongoCollection<Document> collection = database.getCollection("restaurants");


        client.close();



    }
}

