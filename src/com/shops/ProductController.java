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
public class ProductController {
	
	DAO dao;
	ArrayList<Product> products;
	ArrayList<Store> stores;
	public ProductController() {
		super();
		try {
			dao = new DAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadProducts() {
		System.out.println("in loadProducts");
		try {
			products =dao.loadProducts();
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
	
	public String addProduct(Product p) {
		System.out.println(p.getProductID() + "  " +p.getProductName() + "  " + p.getPrice());
		try {
			dao.addProduct(p);
			return "manageStores";
			//Different types of Error Messages
		}catch(SQLIntegrityConstraintViolationException e){
			FacesMessage message = 
			new FacesMessage("Error: " + p.getProductName() + " already exists");
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

	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public ArrayList<Store> getStores() {
		return stores;
	}
	
	public String deleteProduct(int productID) {
		System.out.println(productID);
		try {
			dao.deleteProduct(productID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}