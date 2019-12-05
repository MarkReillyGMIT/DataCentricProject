package com.shops;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HeadOfficeController {
	
	MongoDAO dao;
	ArrayList<HeadOffice> headOfficesList;
	
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

}
