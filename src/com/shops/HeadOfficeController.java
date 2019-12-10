package com.shops;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mongodb.MongoException;
import com.mongodb.MongoSocketOpenException;

@ManagedBean
@SessionScoped
public class HeadOfficeController {
	
	MongoDAO dao;
	private ArrayList<HeadOffice> headOfficesList =  new ArrayList<HeadOffice>();
	private ArrayList<Store> checkList;
	private boolean containsSQL, containsMongo;
	
	public  HeadOfficeController(){
		super();
		try {
			dao = new MongoDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadHeadOffices() {
		System.out.println("in loadHeadOffices");
		try {
			headOfficesList =dao.loadHeadOffices();
		} catch(MongoSocketOpenException e) {
			FacesMessage message = 
			new FacesMessage("Error: Cannot connect to Mongo Database");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public ArrayList<HeadOffice> getHeadOfficesList() {
		return headOfficesList;
	}	
	
	//Add Method
		public String addHeadOffices(HeadOffice ho) {
			
			System.out.println("inside addHeadOffices");
			
			try{
				DAO mysql = new DAO();
				checkList = mysql.loadStores();
				headOfficesList = dao.loadHeadOffices();
			} catch (Exception e) {e.printStackTrace();}
			
			//Checking Store to see if file already exists in the database
			for(Store c : checkList) {
				if(ho.get_id()==(c.getStoreID())){
					containsSQL = true;
					break;
				}else {
					containsSQL = false;
				}
			}
			//Checking HeadOffice to see if file already exists in the database
			for(HeadOffice h : headOfficesList) {
				if(h.location != null && !h.location.isEmpty()){
					containsMongo = true;
					break;
				}else {
					containsMongo = false;
				}
			}
			
			//If contains is true and containsM is false then the file will be added to the db. Otherwise an error message will be show to the user.
			if(containsSQL == true) {				
				if(containsMongo == true){
					FacesMessage message = new FacesMessage("Error: Store ID " + ho.get_id() + " already has location");
					FacesContext.getCurrentInstance().addMessage(null, message);
					return null;
				}else{
					System.out.println("File being added");
					dao.addHeadOffices(ho);
				}
			}else {
				
				FacesMessage message = new FacesMessage("Error: Store ID " + ho.get_id() + " does not exist");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			}
			
			System.out.println("Exiting addHeadOffices");
			
			return "manageOffices.xhtml";
		}

}
