package com.shops;

import java.util.ArrayList;

import org.bson.Document;

import com.google.gson.Gson;
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
	Gson gson;

	
	
	/* ======================================================================================================
	 * Constructor
	 * ====================================================================================================== */
	public MongoDAO() throws Exception {
		mongoClient = new MongoClient();
		database = mongoClient.getDatabase(mongoDB);
		collection = database.getCollection(mongoCollection);
		
	}
	public ArrayList<HeadOffice> loadHeadOffices() throws Exception{
		ArrayList<HeadOffice> headOfficesList = new ArrayList<HeadOffice>();

		FindIterable<Document> headOffices = collection.find();
		   for (Document d : headOffices) {
			System.out.println(d.get("_id")+ " " + d.get("location"));
			HeadOffice ho = gson.fromJson(d.toJson(), HeadOffice.class);
			headOfficesList.add(ho);
		   }		   
		   return headOfficesList;	   
	}
	
}