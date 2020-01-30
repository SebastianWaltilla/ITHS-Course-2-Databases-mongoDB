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

        for (int i = 0; i < listWithCafes.size(); i++) {

            String allCategories ="";

            for (int j = 0; j < listWithCafes.get(i).getCategories().size(); j++) {
                allCategories = allCategories + listWithCafes.get(i).getCategories().get(j) + ", ";
            }
            allCategories  = allCategories.substring(0, allCategories.length() - 2);

            doc = new Document()
                    .append("_id", listWithCafes.get(i).get_id())
                    .append("name", listWithCafes.get(i).getName())
                    .append("stars", listWithCafes.get(i).getStars())
                    .append("Categories", "new String[]{" + allCategories + "}");

            collection.insertOne(doc);
        }
        client.close();
    }
}