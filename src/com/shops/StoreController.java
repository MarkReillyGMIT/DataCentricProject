package com.shops;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.CommunicationsException;


@ManagedBean
@SessionScoped
public class StoreController {
	
	DAO dao;
	ArrayList<Store> stores;
	public StoreController() {
		super();
		try {
			dao = new DAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadStores() {
		System.out.println("in loadStores");
		try {
			stores =dao.loadStores();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String addStore(Store p) {
		System.out.println(p.getStoreID() + "  " +p.getStoreName() + "  " + p.getFounded());
		try {
			dao.addStore(p);
			return "manageStores";
			//Different types of Error Messages
		}catch(SQLIntegrityConstraintViolationException e){
			FacesMessage message = 
			new FacesMessage("Error: Store " + p.getStoreName() + " already exists");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}catch(CommunicationsException e) {
			FacesMessage message = 
			new FacesMessage("Error: Can not communicate with Database");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		catch (Exception e) {
			FacesMessage message = 
			new FacesMessage("Error:" + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Store> getStores() {
		return stores;
	}
	
	public String deleteStore(int storeID) {
		System.out.println(storeID);
		try {
			dao.deleteStore(storeID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}