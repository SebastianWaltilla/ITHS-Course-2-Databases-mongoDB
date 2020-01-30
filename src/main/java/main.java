package main.java;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;


import java.io.FileReader;
import java.io.FileNotFoundException;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonValue;
import javax.json.JsonObject;
import static javax.json.JsonValue.ValueType.*;
import javax.json.JsonReader;
import javax.json.JsonStructure;


public class main {

    public static void main(String[] args) {

        mongoReader hej = new mongoReader();

        try {

           hej.parseAndSaveToClass("C:\\Users\\sebas\\IdeaProjects\\MongoDBJava\\src\\main\\resources\\cafe");
           hej.getCafeClasses();

            hej.parseAndPrint("C:\\Users\\sebas\\IdeaProjects\\MongoDBJava\\src\\main\\resources\\cafe");
        } catch (FileNotFoundException e) {

        }



        /*

        MongoClient mongo = new MongoClient( "localhost" , 27017 );

        // Create database
        MongoDatabase database = mongo.getDatabase("lab3");
        System.out.println("made lab3 database");

        //Create collection
        database.createCollection("restaurants");
        System.out.println("collection restaurants created successfully");

        //
        database.getCollection("resturants").drop();



    */




    }





}

