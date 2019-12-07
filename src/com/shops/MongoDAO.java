package com.shops;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.BasicDBList;
import com.mongodb.DBCursor;
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
		ArrayList<HeadOffice> headOfficesList = new ArrayList<HeadOffice>();
		FindIterable<Document> headOffices = collection.find();
		System.out.println("in Mongo loadHeadOffices()");
		
		for (Document d : headOffices) {
			System.out.println(d.getInteger("_id") + " " + d.getString("location"));
			HeadOffice headOffice = gson.fromJson(d.toJson(),HeadOffice.class);	
			headOfficesList.add(headOffice);
			}
		System.out.println( "Array" + headOfficesList);
	
		
		
		return headOfficesList; 
		   
	}
}
	
	
