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

        //Fill database from json file.
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
        printCollection print = new printCollection();



        System.out.println("Print entire database");
        print.printEntireCollection(collection);

        System.out.println("\n" + "Skriv en metod som ​skriver ut ​namnet på alla dokument" +
                " som har kategorin “Cafe”  ○ OBS! Exkludera id så att bara namn visas");
        print.printCafeFromCollection(collection);




        // ● Skriv en metod som uppdaterar genom increment “stars” för den restaurang
        // som  har “name” “XYZ Coffee Bar” så att nya värdet på stars blir 6. 
        // OBS! Ni ska använda ​increment.




        // ○ OBS! ​Skriv ut ​alla restauranger igen, så att jag kan se att “stars” blivit 6,
        // för  denna restaurang när jag kör ert program. 




        //● Skriv en metod som uppdaterar “name” för ​"456 Cookies Shop"​ till “123 Cookies  Heaven” 
        // ● OBS! ​Skriv ut ​alla restauranger igen, så att jag kan se att namnet ändrats för 
        // denna restaurang när jag kör ert program. 




        //● Skriv en metod som aggregerar en lista med alla restauranger som har 4 eller fler  “stars” ​
        // och skriver ut​ endast “name” och “stars” 
        // ○ OBS! Metoderna ska skriva ut via System.out resultatet, det vill säga,
        // när  jag kör ert program ska jag se resultatet från utskrifterna. 







        client.close();



    }


}

