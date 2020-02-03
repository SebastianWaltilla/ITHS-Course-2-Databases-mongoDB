
Sebastian Waltilla 


VG-uppgiften

	Hittas på min github: https://github.com/SebastianWaltilla/ITHS-Course-2-Databases-mongoDB
	Ha igång mongo och mongod.
	Starta main och följ instruktionerna.
	Möcke nöje! 
	/Sebastian 

G-uppgiften

	---Task1---

	1: Skapa en databas vid namn citydb. 

> use citydb
switched to db citydb

	2:Sätt in följande dokument i en kollektion med namn: citie

> db.cities.insert({_id:1, name:"Stockholm", population:1372565})
WriteResult({ "nInserted" : 1 })
> db.cities.insert({_id:2, name: "Göteborg", population: 549839})
WriteResult({ "nInserted" : 1 })
> db.cities.insert({_id:3, name: "Malmö", population: 280415})
WriteResult({ "nInserted" : 1 })
> db.cities.insert({_id:4, name: "Uppsala", population: 140454})
WriteResult({ "nInserted" : 1 })
> db.cities.insert({_id:5, name: "Västerås", population: 110877})
WriteResult({ "nInserted" : 1 })


	3: Hitta ett dokument där namnet är “Malmö” och visa bara “namn” och “population”.

> db.cities.find({name:"Malmö"},{name:1, population: 1, _id: 0})
{ "name" : "Malmö", "population" : 280415 }


	4.: Uppdatera dokumentet som har “namn” “Göteborg” med “population” 549890 

> db.cities.update({name: "Göteborg"}, {$set: {population:549890}})
WriteResult({ "nMatched" : 1, "nUpserted" : 0, "nModified" : 1 })
>
> db.cities.find({name:"Göteborg"})
{ "_id" : 2, "name" : "Göteborg", "population" : 549890 }



	5: Ta bort dokumentet med _id:4 

> db.cities.remove({_id:4})
WriteResult({ "nRemoved" : 1 })
>
>
> db.cities.find()
{ "_id" : 1, "name" : "Stockholm", "population" : 1372565 }
{ "_id" : 2, "name" : "Göteborg", "population" : 549890 }
{ "_id" : 3, "name" : "Malmö", "population" : 280415 }
{ "_id" : 5, "name" : "Västerås", "population" : 110877 }



	6:​ Uppdatera dokumentet som har “namn” “Västerås”
	och öka (med increment)  ”population” fält så att det blir 110879. (increment by 2) 

> db.cities.update({name: "Västerås"}, {$inc: {population: 2}})
WriteResult({ "nMatched" : 1, "nUpserted" : 0, "nModified" : 1 })
>
> db.cities.find({name:"Västerås"})
{ "_id" : 5, "name" : "Västerås", "population" : 110879 }
>


	7: Lägg till ett fält “country” och värdet “Sweden” till alla dokument. 

> db.cities.updateMany({},{$set: {Country: "Sweden"}})
{ "acknowledged" : true, "matchedCount" : 4, "modifiedCount" : 4 }
>
> db.cities.find().pretty()
{
        "_id" : 1,
        "name" : "Stockholm",
        "population" : 1372565,
        "Country" : "Sweden"
}
{
        "_id" : 2,
        "name" : "Göteborg",
        "population" : 549890,
        "Country" : "Sweden"
}
{
        "_id" : 3,
        "name" : "Malmö",
        "population" : 280415,
        "Country" : "Sweden"
}
{
        "_id" : 5,
        "name" : "Västerås",
        "population" : 110879,
        "Country" : "Sweden"
}
>


	8.​ Byt namn på fältet “country” till “Country”. 

> db.cities.find()
{ "_id" : 1, "name" : "Stockholm", "population" : 1372565, "country" : "Sweden" }
{ "_id" : 2, "name" : "Göteborg", "population" : 549890, "country" : "Sweden" }
{ "_id" : 3, "name" : "Malmö", "population" : 280415, "country" : "Sweden" }
{ "_id" : 5, "name" : "Västerås", "population" : 110879, "country" : "Sweden" }
>
>
> db.cities.updateMany({},{$rename:{"country":"Country"}})
{ "acknowledged" : true, "matchedCount" : 4, "modifiedCount" : 4 }
>
> db.cities.find()
{ "_id" : 1, "name" : "Stockholm", "population" : 1372565, "Country" : "Sweden" }
{ "_id" : 2, "name" : "Göteborg", "population" : 549890, "Country" : "Sweden" }
{ "_id" : 3, "name" : "Malmö", "population" : 280415, "Country" : "Sweden" }
{ "_id" : 5, "name" : "Västerås", "population" : 110879, "Country" : "Sweden" }


	---Task2---


	9. Skapa en databas vid namn animalsdb.

> use animalsdb = switched to db animalsdb


	10. Gå till databasen animalsdb. 

> db 		// Testar att jag är i databasen animalsdb
animalsdb


	11. Skriv i mongo-skalet : load ("animals.js"). Vad gör den raden? Visa resultatet.

> load("C:/Program Files/MongoDB/Server/4.2/data/scripts/animals.js") = true		// load laddar in ett json dokument med hjälp av koden db.animals.insert(osv...) 


	12. Hitta alla data från collection animals. 

> db.animals.find() = { "_id" : ObjectId("5e203c24009949fc0935534b"), "name" : "Elephant", "color" : "grey", "weight" : 7000, "has_tusks" : true, "data" : [ "mammal", "herbivore", "live in groups" ], "found_in" : [ "sub-Saharan Africa", "South Asia", "Southeast Asia" ] }
{ "_id" : ObjectId("5e203c24009949fc0935534c"), "name" : "Elk", "color" : "brown", "weight" : 395, "min_weight_male" : 320, "max_weight_male" : 475, "min_weight_female" : 275, "max_weight_female" : 375, "has_antlers" : true, "data" : [ "mammal", "deer family", "herbivore" ], "found_in" : [ "Canada", "Alaska", "New England", "Scandinavia", "Latvia", "Estonia", "Russia" ] }
{ "_id" : ObjectId("5e203c24009949fc0935534d"), "name" : "Fox", "color" : "orange", "weight" : 6, "suborder" : "Caniformia", "class" : "Mammalia", "order" : "Carnivora", "family" : "Canidae", "data" : [ "mammal", "omnivore" ] }
{ "_id" : ObjectId("5e203c24009949fc0935534e"), "name" : "Wolf", "class" : "Mammalia", "order" : "Carnivora", "suborder" : "Caniformia", "color" : "grey", "weight" : 44, "min_weight_male" : 43, "max_weight_male" : 45, "min_weight_female" : 36, "max_weight_female" : 38.5, "found_in" : [ "Eurasia", "North America" ], "data" : [ "mammal", "carnivore", "canid", "live in groups" ] }
{ "_id" : ObjectId("5e203c24009949fc0935534f"), "name" : "Bear", "color" : "brown", "weight" : 505, "found_in" : [ "North America", "South America", "Europe", "Asia" ], "class" : "Mammalia", "order" : "Carnivora", "suborder" : "Caniformia", "family" : "Ursidae", "data" : [ "mammal", "carnivore", "nonretractile claws", "rounded ears", "can stand on its rear legs" ] }
{ "_id" : ObjectId("5e203c24009949fc09355350"), "name" : "Hyena", "family" : "Hyaenidae", "suborder" : "Feliformia", "order" : "Carnivora", "color" : "brown", "weight" : 47, "min_weight_male" : 40.5, "max_weight_male" : 55, "min_weight_female" : 44.5, "max_weight_female" : 63.9, "spotted" : true, "data" : [ "mammal", "carnivore", "live in groups" ] }        
{ "_id" : ObjectId("5e203c24009949fc09355351"), "name" : "Orangutan", "alternative_name" : "Orangutang", "color" : "orange", "weight" : 75, "data" : [ "herbivore", "opposable thumbs", "opposable big toe", "eat fruits", "primate", "ape" ] } 
{ "_id" : ObjectId("5e203c24009949fc09355352"), "name" : "Reindeer", "class" : "Mammalia", "color" : "grey", "weight" : 200, "alternative_name" : "caribou", "has_antlers" : true, "found_in" : [ "northern Europe", "Siberia", "North America" ], "data" : [ "mammal", "deer family", "herbivore", "live in groups" ] }
{ "_id" : ObjectId("5e203c24009949fc09355353"), "name" : "Gorilla", "color" : "black", "weight" : 155, "data" : [ "primate", "ape", "herbivore", "can stand on its rear legs", "live in groups" ] }
{ "_id" : ObjectId("5e203c24009949fc09355354"), "name" : "Chimpanzee", "color" : "black", "weight" : 70, "data" : [ "primate", "ape", "omnivore" ] }
{ "_id" : ObjectId("5e203c24009949fc09355355"), "name" : "Marten", "order" : "Carnivora", "suborder" : "Caniformia", "family" : "Mustelidae", "color" : "brown", "weight" : 1.5, "data" : [ "solitary animal" ] }
{ "_id" : ObjectId("5e203c24009949fc09355356"), "name" : "Mongoose", "color" : "brown", "weight" : 1.7, "family" : "Herpestidae", "suborder" : "Feliformia", "order" : "Carnivora", "data" : [ "carnivore", "eat venomous snakes" ] }
{ "_id" : ObjectId("5e203c24009949fc09355357"), "name" : "Meerkat", "found_in" : [ "Botswana", "Namibia", "Angola", "South Africa" ], "color" : "yellow", "family" : "Herpestidae", "suborder" : "Feliformia", "order" : "Carnivora", "weight" : 1, "data" : [ "can stand on its rear legs", "live in groups" ] }
{ "_id" : ObjectId("5e203c24009949fc09355358"), "name" : "Lion", "color" : "yellow", "weight" : 200, "class" : "Mammalia", "order" : "Carnivora", "family" : "Felidae", "subfamily" : "Pantherinae", "suborder" : "Feliformia", "data" : [ "live in groups", "carnivore", "smaller than tigers", "protractible claws" ] }
{ "_id" : ObjectId("5e203c24009949fc09355359"), "name" : "Raccoon", "color" : "gray", "weight" : 6, "suborder" : "Caniformia", "class" : "Mammalia", "order" : "Carnivora", "family" : "Procyonidae", "data" : [ "omnivore", "nocturnal", "plantigrade locomotion", "can stand on its rear legs" ] }
{ "_id" : ObjectId("5e203c24009949fc0935535a"), "name" : "Black panther", "class" : "Mammalia", "order" : "Carnivora", "family" : "Felidae", "subfamily" : "Pantherinae", "suborder" : "Feliformia", "color" : "black", "weight" : 60, "data" : [ "are leopards in Asia and Africa", "are black jaguars in the Americas", "big cat" ] }



	13. Hitta hur många djur det finns totalt i databasen animals?

> db.animals.count()
16
>


	14. Lägg till en array “favorit_food” med “blueberry, honey och ants” för “Bear” .

> db.animals.update( { name: "Bear" }, { $push: { favorit_food: { $each: [ "blueberry", "honey", "ants" ] } } }) 
 WriteResult({ "nMatched" : 1, "nUpserted" : 0, "nModified" : 1 })


	15. Ta bort ants och honey från arrayen “favorit_food” och “rounded ears” från  arrayen 

> db.animals.update({name: "Bear"}, {$pull: {favorit_food: {$in: ["ants","honey"]}, data: "rounded ears"}}) 
= WriteResult({ "nMatched" : 1, "nUpserted" : 0, "nModified" : 1 })


	16.  Hitta hur många gula djur det finns i kollektionen.  

> db.animals.count({color: "yellow"})
2
>


	17.  Hitta alla namnet på alla djur vars färg är brun och som lever i Asien och visa  deras namn, color och found_in . 

> db.animals.find({color:"brown", found_in:"Asia"}).pretty()
{
        "_id" : ObjectId("5e2039e2be4d482c6d2a252d"),
        "name" : "Bear",
        "color" : "brown",
        "weight" : 505,
        "found_in" : [
                "North America",
                "South America",
                "Europe",
                "Asia"
        ],
        "class" : "Mammalia",
        "order" : "Carnivora",
        "suborder" : "Caniformia",
        "family" : "Ursidae",
        "data" : [
                "mammal",
                "carnivore",
                "nonretractile claws",
                "can stand on its rear legs"
        ],
        "favorit_food" : [
                "blueberry"
        ]
}
>


	18.​ Lägg till fältet “litter_size” med värdet “4-6-kits” för “Fox”.  
>
>db.animals.update({name: "Fox"},{$set:{litter_size:"4-6-kits"}})
>
> db.animals.find({name: "Fox"}).pretty()
{
        "_id" : ObjectId("5e2039e2be4d482c6d2a252b"),
        "name" : "Fox",
        "color" : "orange",
        "weight" : 6,
        "suborder" : "Caniformia",
        "class" : "Mammalia",
        "order" : "Carnivora",
        "family" : "Canidae",
        "data" : [
                "mammal",
                "omnivore"
        ],
        "litter_size" : "4-6-kits"
}
>

	19.​ Lägg till ett fält med namn “likes meat” i arrayen “data” för alla med "order":  "Carnivora"  och som är gula till färgen.

> db.animals.update({order:"Carnivora",color:"yellow"}, {$push: {data: "likes meat"}}, {multi:true})
	
	// jag missade att skriva ut svaret, men här är resultatet: 
> db.animals.find({color: "yellow"}).pretty()
{
        "_id" : ObjectId("5e2039e2be4d482c6d2a2536"),
        "name" : "Lion",
        "color" : "yellow",
        "weight" : 200,
        "class" : "Mammalia",
        "order" : "Carnivora",
        "family" : "Felidae",
        "subfamily" : "Pantherinae",
        "suborder" : "Feliformia",
        "data" : [
                "live in groups",
                "carnivore",
                "smaller than tigers",
                "protractible claws",
                "likes meat"
        ]
}
{
        "_id" : ObjectId("5e2039e2be4d482c6d2a2535"),
        "name" : "Meerkat",
        "found_in" : [
                "Botswana",
                "Namibia",
                "Angola",
                "South Africa"
        ],
        "color" : "yellow",
        "family" : "Herpestidae",
        "suborder" : "Feliformia",
        "order" : "Carnivora",
        "weight" : 1,
        "data" : [
                "can stand on its rear legs",
                "live in groups",
                "likes meat"
        ]
}	


	20.​ Gruppera efter färger och visa antal djur per färg.

> db.animals.aggregate([{$match: {color: {$exists:true}}}, {$group: {_id: "$color", Total:{$sum: 1 }}}])
{ "_id" : "grey", "Total" : 3 }
{ "_id" : "yellow", "Total" : 2 }
{ "_id" : "brown", "Total" : 5 }
{ "_id" : "orange", "Total" : 2 }
{ "_id" : "black", "Total" : 3 }
{ "_id" : "gray", "Total" : 1 }
>


	21.​ Skriv ut antalet djur som väger mer än 100.  

> db.animals.aggregate([{$match: {weight: {$gte:100}}}, { $group: {_id: "CountingFatAnimals", count: { $sum: 1 }}}])
{ "_id" : "CountingFatAnimals", "count" : 6 }
>


	22.​ Skriv ut djur med “order” “Carnivora”, sorterat efter weight i fallande ordning.  

> db.animals.find({order: "Carnivora"}, {name: 1, weight: 1 }).sort({weight: -1}).pretty()
{
        "_id" : ObjectId("5e2039e2be4d482c6d2a252d"),
        "name" : "Bear",
        "weight" : 505
}
{
        "_id" : ObjectId("5e2039e2be4d482c6d2a2536"),
        "name" : "Lion",
        "weight" : 200
}
{
        "_id" : ObjectId("5e2039e2be4d482c6d2a2538"),
        "name" : "Black panther",
        "weight" : 60
}
{
        "_id" : ObjectId("5e2039e2be4d482c6d2a252e"),
        "name" : "Hyena",
        "weight" : 47
}
{
        "_id" : ObjectId("5e2039e2be4d482c6d2a252c"),
        "name" : "Wolf",
        "weight" : 44
}
{
        "_id" : ObjectId("5e2039e2be4d482c6d2a252b"),
        "name" : "Fox",
        "weight" : 6
}
{
        "_id" : ObjectId("5e2039e2be4d482c6d2a2537"),
        "name" : "Raccoon",
        "weight" : 6
}
{
        "_id" : ObjectId("5e2039e2be4d482c6d2a2534"),
        "name" : "Mongoose",
        "weight" : 1.7
}
{
        "_id" : ObjectId("5e2039e2be4d482c6d2a2533"),
        "name" : "Marten",
        "weight" : 1.5
}
{
        "_id" : ObjectId("5e2039e2be4d482c6d2a2535"),
        "name" : "Meerkat",
        "weight" : 1
}
>


	23.​ Hitta alla dokument som har “mammal” ​eller​ "carnivore" i deras “data” fält. 

> db.animals.find({data: {$in:["mamal","carnivore"]}}, {name:1}).pretty()
{ "_id" : ObjectId("5e2039e2be4d482c6d2a252c"), "name" : "Wolf" }
{ "_id" : ObjectId("5e2039e2be4d482c6d2a252d"), "name" : "Bear" }
{ "_id" : ObjectId("5e2039e2be4d482c6d2a252e"), "name" : "Hyena" }
{ "_id" : ObjectId("5e2039e2be4d482c6d2a2534"), "name" : "Mongoose" }
{ "_id" : ObjectId("5e2039e2be4d482c6d2a2536"), "name" : "Lion" }
>


	24.​ Hitta alla dokument som har “mammal” ​och​ "carnivore" i deras “data” fält.  

> db.animals.find({data: {$all: ["mammal", "carnivore"]}}, {name: 1}).pretty()
{ "_id" : ObjectId("5e2039e2be4d482c6d2a252c"), "name" : "Wolf" }
{ "_id" : ObjectId("5e2039e2be4d482c6d2a252d"), "name" : "Bear" }
{ "_id" : ObjectId("5e2039e2be4d482c6d2a252e"), "name" : "Hyena" }
>


	---Task3---


	25.​ Sätt in följande record i kollektion orders: 

> use orders
switched to db orders
> db.createCollection("orders")
{ "ok" : 1 }

> db.orders.insertMany([{"Id": 100, "Name": "Eva", "Subscriber": true, "Payment": {"Type": "Credit-Card","Total":400,"Success": true},"Note": "1st Complete Record"}, {"Id": 101,"Name": "Johan","Subscriber": true,"Payment": {"Type": "Debit-Card","Total": 500,"Success": true},"Note":null}, {"Id": 102,"Name": "Matilda","Subscriber": true,"Payment": {"Type": "Credit-Card","Total": 700,"Success": false}}, {"Id": 103,"Name": "Mikael","Subscriber": false,"Payment": null,"Note":"Payment is Null"}, {"Id": 104,"Name": "Rikard","Subscriber": false,"Payment":{"Type": "Debit-Card","Total": 300,"Success":false},"Note": "Completed Payment"}])
{
        "acknowledged" : true,
        "insertedIds" : [
                ObjectId("5e34015d672af4c3b46a9a29"),
                ObjectId("5e34015d672af4c3b46a9a2a"),
                ObjectId("5e34015d672af4c3b46a9a2b"),
                ObjectId("5e34015d672af4c3b46a9a2c"),
                ObjectId("5e34015d672af4c3b46a9a2d")
        ]
}
>



	26.  Hitta alla dokument där fältet “Note” är “null” ​eller​ saknas .

> db.orders.find({ $or : [  { Note : { $exists: false }}, { Note: null}]}).pretty()
{
        "_id" : ObjectId("5e34015d672af4c3b46a9a2a"),
        "Id" : 101,
        "Name" : "Johan",
        "Subscriber" : true,
        "Payment" : {
                "Type" : "Debit-Card",
                "Total" : 500,
                "Success" : true
        },
        "Note" : null
}
{
        "_id" : ObjectId("5e34015d672af4c3b46a9a2b"),
        "Id" : 102,
        "Name" : "Matilda",
        "Subscriber" : true,
        "Payment" : {
                "Type" : "Credit-Card",
                "Total" : 700,
                "Success" : false
        }
}
>


	27. Hitta alla dokument där fältet “Note” saknas. 

> db.orders.find({Note : {$exists : false}}).pretty()
{
        "_id" : ObjectId("5e34015d672af4c3b46a9a2b"),
        "Id" : 102,
        "Name" : "Matilda",
        "Subscriber" : true,
        "Payment" : {
                "Type" : "Credit-Card",
                "Total" : 700,
                "Success" : false
        }
}
>



	28 Hitta alla dokument som har "Type": "Credit-Card" sorterat efter “Total” i  stigande ordning. 


> db.orders.find({ "Payment.Type" : "Credit-Card"}).sort({"Payment.Total" : 1}).pretty()
{
        "_id" : ObjectId("5e34015d672af4c3b46a9a29"),
        "Id" : 100,
        "Name" : "Eva",
        "Subscriber" : true,
        "Payment" : {
                "Type" : "Credit-Card",
                "Total" : 400,
                "Success" : true
        },
        "Note" : "1st Complete Record"
}
{
        "_id" : ObjectId("5e34015d672af4c3b46a9a2b"),
        "Id" : 102,
        "Name" : "Matilda",
        "Subscriber" : true,
        "Payment" : {
                "Type" : "Credit-Card",
                "Total" : 700,
                "Success" : false
        }
}
>


	29 Sortera all dokument efter Total i fallande ordning och visa bara dokument 2  och 3. 

> db.orders.find({}).sort({"Payment.Total": -1}).skip(1).limit(2).pretty()
{
        "_id" : ObjectId("5e34015d672af4c3b46a9a2a"),
        "Id" : 101,
        "Name" : "Johan",
        "Subscriber" : true,
        "Payment" : {
                "Type" : "Debit-Card",
                "Total" : 500,
                "Success" : true
        },
        "Note" : null
}
{
        "_id" : ObjectId("5e34015d672af4c3b46a9a29"),
        "Id" : 100,
        "Name" : "Eva",
        "Subscriber" : true,
        "Payment" : {
                "Type" : "Credit-Card",
                "Total" : 400,
                "Success" : true
        },
        "Note" : "1st Complete Record"
}
>

	30. Aggregera “Success” och visa antal i fallande ordning. (Hur många “Success”  är “true” och hur många är “false”)


> db.orders.aggregate([{$group: {_id: "$Payment.Success", count: {$sum: 1}}},{$sort: {count: -1}}])
{ "_id" : true, "count" : 2 }
{ "_id" : false, "count" : 2 }
{ "_id" : null, "count" : 1 }
>
























    public void parseAndPrint()throws FileNotFoundException {
        try{
            JsonReader reader = Json.createReader(new FileReader("C:\\Users\\sebas\\IdeaProjects\\MongoDBJava\\src\\main\\resources\\cafe"));
            JsonStructure jsonStruct = reader.read();

            if(jsonStruct.getValueType().equals(OBJECT)){
                
                                
                JsonObject jo = (JsonObject) jsonStruct;
                JsonArray doc = jo.getJsonArray("document");
               
                for (int i = 0; i < doc.size() ; i++) {

                    System.out.println("_id: " + doc.etString("_id", "not working"));
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
   
                }
                
            }
        }catch(FileNotFoundException fnfe){
            throw new FileNotFoundException("jsonFile");
        }

    }




















    public void parseAndPrint()throws FileNotFoundException {
        try{
            JsonReader reader = Json.createReader(new FileReader("C:\\Users\\sebas\\IdeaProjects\\MongoDBJava\\src\\main\\resources\\cafe"));
            JsonStructure jsonStruct = reader.read();

            if(jsonStruct.getValueType().equals(OBJECT)){
                
                                
                JsonObject jo = (JsonObject) jsonStruct;
                JsonArray doc = jo.getJsonArray("document");
               
                for (int i = 0; i < doc.size() ; i++) {

                    System.out.println("_id: " + doc.etString("_id", "not working"));
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
   
                }
                
            }
        }catch(FileNotFoundException fnfe){
            throw new FileNotFoundException("jsonFile");
        }

    }







