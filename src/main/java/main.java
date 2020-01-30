package main.java;


import com.mongodb.Block;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.FileNotFoundException;


public class main {

    public static void main(String[] args) {
        jsonReader hej = new jsonReader();
        saveToMongoDB save = new saveToMongoDB();

        try {
           hej.parseAndSaveToClass("C:\\Users\\sebas\\IdeaProjects\\MongoDBJava\\src\\main\\resources\\cafe");
           hej.getCafeClasses();
           save.saveToMongoDBMethod(hej.getCafeClasses());

            hej.parseAndPrint("C:\\Users\\sebas\\IdeaProjects\\MongoDBJava\\src\\main\\resources\\cafe");
        } catch (FileNotFoundException e) {

            save.saveToMongoDBMethod(hej.getCafeClasses());
        }

    }
}

