package main.java;

import com.mongodb.Block;
import com.mongodb.client.*;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.*;
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

        Block<Document> printBlock = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.toJson());
            }
        };
        collection.find(eq("Categories", "Cafe")).forEach(printBlock);
    }

    public void incrementStarsInCollection(MongoCollection<Document> collection){
        collection.updateMany(eq("name", "XYZ Coffee Bar"), inc("stars", 1));
        // how its done in mongoDB
        //db.restaurants.update({}, {$inc:{stars: 1}},{multi:true})
    }

    public void editNameInCollection(MongoCollection<Document> collection){
         collection.updateOne(eq("name", "456 Cookies Shop"), new Document("$set", new Document("name", "123 Cookies  Heaven")));
    }

    public void aggregateInCollection(MongoCollection<Document> collection) {

        AggregateIterable<Document> result = collection.aggregate(
                Arrays.asList(
                        Aggregates.match(Filters.eq(matchField, matchValue)),
                        Aggregates.group(("$" + groupField),
                                Accumulators.sum("count", 1))));


    }
}

