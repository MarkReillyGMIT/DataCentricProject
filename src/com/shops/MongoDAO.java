package com.shops;

import java.util.ArrayList;
import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class MongoDAO {
	
	String mongoDB = "storeHeadOfficeDB";
	String mongoCollection = "storeHeadOffice";
	
	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> collection;
	Gson gson = new Gson();

	
	
	/* ======================================================================================================
	 * Constructor
	 * ====================================================================================================== */
	public MongoDAO() throws Exception {
		mongoClient = new MongoClient();
		database = mongoClient.getDatabase(mongoDB);
		collection = database.getCollection(mongoCollection);
		
		
		
	}
	
	public ArrayList<HeadOffice> loadHeadOffices() throws Exception{
		
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new BasicDBObject("$exists", true));
		
		ArrayList<HeadOffice> headOfficesList = new ArrayList<HeadOffice>();
		FindIterable<Document> headOffices = collection.find(query);
		System.out.println("in Mongo loadHeadOffices()");
		
		for (Document d : headOffices) {
			System.out.println(d.getInteger("_id") + " " + d.getString("location"));
			HeadOffice headOffice = gson.fromJson(d.toJson(),HeadOffice.class);	
			headOfficesList.add(headOffice);
			}
	
		
		return headOfficesList; 
		   
	}
	
	//Add Method
		public void addHeadOffices(HeadOffice hosc){
			System.out.println("adding data..");
			Document d = new Document();
			d.append("_id",hosc.get_id());
			d.append("location",hosc.getLocation());
			collection.insertOne(d);
			System.out.println("data added..");
		}
	
}
	
	
