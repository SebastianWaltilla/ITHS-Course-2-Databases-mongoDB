package main.java;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.io.FileNotFoundException;

public class main {

    public static void main(String[] args) {

        GetInput getInput = new GetInput();
        boolean stop = true;

        //Fill database from json file.
        jsonReader file = new jsonReader();     //här skapas en lista
        saveToMongoDB save = new saveToMongoDB();
        try {
            //method for turning a json-file and parse it to a ArrayList with objects of type cafe
            file.parseAndSaveToClass("./src/main/resources/cafe.json");
            //method for sent the ArrayList with objects of type cafe to mongoDB local server
            save.saveToMongoDBMethod(file.getCafeClasses()); // skickar til databasen

        } catch (FileNotFoundException e) {
            System.out.println("Error, path wrong or json in wrong");
        }

        // Methods for access mongodb lab3 and the collection resturants
        MongoClient client= MongoClients.create();
        MongoDatabase database = client.getDatabase("lab3");
        MongoCollection<Document> collection = database.getCollection("restaurants");
        editMongodbCollection print = new editMongodbCollection();

        System.out.println("first enter 1 for watch sebastians lab3");

        while(stop == true){

            switch (getInput.getInt()){

            case 1:
                // Methods for make changes in the collection 'restaurants' in database 'lab3'
                System.out.println("\n" + "\n" + "Task1: Print entire collection of cafes");
                print.printEntireCollection(collection);

                System.out.println("\n" + "\n" + "Task2: Method for sys.out name on documents with category Cafe, " +
                        " only show the name of cafe's");
                print.printCafeFromCollection(collection);

                System.out.println("\n" + "\n" + "Task3: Metod that increment “stars” for the restaurant\n" +
                        " with “name” = “XYZ Coffee Bar” with 1");
                print.incrementStarsInCollection(collection);
                print.printEntireCollection(collection);

                System.out.println("\n" + "\n" + "Task4: Method that updats “name” for “456 Cookies Shop“ to “123 Cookies  Heaven” ");
                print.editNameInCollection(collection);
                print.printEntireCollection(collection);

                System.out.println("\n" + "\n" + "Task5 Method aggragate restaurants with “stars” grater than 4 and print only  “name” and “stars” ");
                print.aggregateInCollection(collection);

                System.out.println("enter 2 to clear restaurants collection and exit:");
                break;

            case 2:
                stop = false;
                print.removeInCollection(collection);
                System.out.println("restaurants removed");
                break;
            }
        }

        // Close connection to local monogoDB
        client.close();
    }
}

