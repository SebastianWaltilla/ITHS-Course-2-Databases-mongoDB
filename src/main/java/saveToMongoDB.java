package main.java;
import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;


public class saveToMongoDB {


    public void saveToMongoDBMethod(ArrayList<cafeClass> listWithCafes) {

        MongoClient client= MongoClients.create();

        MongoDatabase database = client.getDatabase("lab3");

        MongoCollection<Document> collection = database.getCollection("restaurants");

        Document doc;


            doc = new Document()
                    .append("_id", "hej")
                    .append("stars", 1)
                    .append("name","Slinus");


            collection.insertOne(doc);

        client.close();





    }
}