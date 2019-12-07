package com.shops;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.CommunicationsException;

@ManagedBean
@SessionScoped
public class HeadOfficeController {
	
	MongoDAO dao;
	ArrayList<HeadOffice> headOfficesList =  new ArrayList<HeadOffice>();
	
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public ArrayList<HeadOffice> getHeadOfficesList() 
	{ 
		
		return headOfficesList; 
	}
	

}
