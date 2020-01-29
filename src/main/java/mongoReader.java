package main.java;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonValue;
import javax.json.JsonObject;
import static javax.json.JsonValue.ValueType.*;
import javax.json.JsonReader;
import javax.json.JsonStructure;

public class mongoReader {

    private String jsonFile;

    //public JSONParser(String jsonFile){
    //    this.jsonFile = jsonFile;
    // }

    public void parseAndPrint()throws FileNotFoundException {

        try {
            JsonReader reader = Json.createReader(new FileReader("C:\\Users\\sebas\\IdeaProjects\\MongoDBJava\\src\\main\\resources\\cafe"));
            JsonStructure jsonStruct = reader.read();

            if (jsonStruct.getValueType().equals(OBJECT)) {

                JsonObject jo = (JsonObject) jsonStruct;
                JsonArray doc = jo.getJsonArray("document");

                for (int i = 0; i < doc.size(); i++) {

                    System.out.println("_id: " + doc.getJsonObject(i).getString("_id", "piss"));
                    System.out.println("name: " + doc.getJsonObject(i).getString("name", "piss"));
                    System.out.println("stars: " + doc.getJsonObject(i).getString("stars", "piss"));
                 /*
                   System.out.println("name: " + jo.getString("name", "not working"));
                   System.out.println("stars: " + jo.getString("stars", "not working"));

                    JsonArray arr = jo.getJsonArray("categories");
                    System.out.print("Categories: [");
                    for (int i = 0; i < arr.size() ; i++) {
                        System.out.print(arr.getString(i));
                        if (i != arr.size()-1){
                            System.out.print(", ");
                        }
                    }
                    System.out.print("]");
*/
                }

            }

        } catch (FileNotFoundException fnfe) {
            throw new FileNotFoundException("jsonFile");
        }

    }
}




