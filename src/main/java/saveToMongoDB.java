package main.java;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import com.mongodb.client.model.ValidationOptions;

public class saveToMongoDB {

    public void saveToMongoDBMethod(ArrayList<cafeClass> listWithCafes){

        //1. Basic MongoDB connection
        MongoManager.init("lab3");
        MongoCollection<Document> coll = MongoManager.getCollection("test");




    }




}
