package main.java;
import com.mongodb.client.*;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Updates.inc;

public class editMongodbCollection {

    public void printEntireCollection(MongoCollection<Document> collection){
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }

    public void printCafeFromCollection(MongoCollection<Document> collection){
        AggregateIterable<Document> result = collection.aggregate(
                Arrays.asList(
                        Aggregates.match(Filters.eq("Categories", "Cafe")),
                        Aggregates.project(
                                fields(
                                        Projections.excludeId(),
                                        Projections.include("name")
                                )
                        )
                )
        );
        List<Document> listDoc = new ArrayList<>();
        for (Document doc : result) {
            listDoc.add(doc);
        }
        for (int i = 0; i < listDoc.size(); i++) {
            System.out.println(listDoc.get(i).toJson());
        }
    }

    public void incrementStarsInCollection(MongoCollection<Document> collection){

        collection.updateMany(eq("name", "XYZ Coffee Bar"), inc("stars", 1));
    }

    public void editNameInCollection(MongoCollection<Document> collection){

         collection.updateOne(eq("name", "456 Cookies Shop"), new Document("$set", new Document("name", "123 Cookies  Heaven")));
    }

    public void aggregateInCollection(MongoCollection<Document> collection) {

        AggregateIterable<Document> result = collection.aggregate(
                                                        Arrays.asList(
                                                            Aggregates.match(Filters.gt("stars", 3)),
                                                                Aggregates.project(
                                                                        fields(
                                                                                Projections.excludeId(),
                                                                                Projections.include("name","stars")
                                                                        )
                                                                )
                                                        )
        );
        List<Document> listDoc = new ArrayList<>();
        for (Document doc : result) {
            listDoc.add(doc);
        }
        for (int i = 0; i < listDoc.size(); i++) {
            System.out.println(listDoc.get(i).toJson());
        }
    }
}

