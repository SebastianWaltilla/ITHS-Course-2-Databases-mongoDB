package main.java;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import static javax.json.JsonValue.ValueType.*;
import javax.json.JsonReader;
import javax.json.JsonStructure;
public class jsonReader {

   private ArrayList<cafeClass> cafeClasses = new ArrayList<cafeClass>();

   //  parseAndSaveToClass takes a json file and parse it to a cafe class, put the cafe instance and put it in ArrayList.
    public ArrayList<cafeClass> parseAndSaveToClass(String localPath)throws FileNotFoundException {

        try {
            JsonReader reader = Json.createReader(new FileReader(localPath));
            JsonStructure jsonStruct = reader.read();

            if (jsonStruct.getValueType().equals(OBJECT)) {
                JsonObject jo = (JsonObject) jsonStruct;
                JsonArray doc = jo.getJsonArray("document");

                for (int i = 0; i < doc.size(); i++) {

                    String id   = doc.getJsonObject(i).getString("_id", "no id");
                    String name =  doc.getJsonObject(i).getString("name", "no name");
                    int stars   =  doc.getJsonObject(i).getInt("stars");
                    cafeClass newCafe = new cafeClass(id, name, stars);

                    JsonArray arr = doc.getJsonObject(i).getJsonArray("categories");
                    for (int k = 0; k < arr.size(); k++) {
                        newCafe.addToCategories(arr.getString(k));
                    }
                    cafeClasses.add(newCafe);
                }
            }
        } catch (FileNotFoundException fnfe) {
            throw new FileNotFoundException("jsonFile");
        }
        return cafeClasses;
    }

    public ArrayList<cafeClass> getCafeClasses() {
        return cafeClasses;
    }
    public void setCafeClasses(ArrayList<cafeClass> cafeClasses) {
        this.cafeClasses = cafeClasses;
    }
}




