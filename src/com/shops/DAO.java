package com.shops;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {
	DataSource mysqlDS;
	
	/* =============================================================================
	 * ========================= Constructor
	 *=============================================================================
	 */
	
	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/shops";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}
	
	//loadStores
	public ArrayList<Store> loadStores() throws Exception {
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		
		myConn = mysqlDS.getConnection();

		String sql = "select * from store ";

		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);
		
		
		ArrayList<Store> stores = new ArrayList<Store>();

		// process result set
		while (myRs.next()) {
			Store p = new Store();
			p.setStoreID(myRs.getInt("id"));
			p.setStoreName(myRs.getString("name"));
			p.setFounded(myRs.getString("founded"));
			stores.add(p);
		}	
		return stores;
	}
	
	//loadStoresAndProducts
		public ArrayList<Store> loadStoresAndProducts(int storeID) throws Exception {
			
			Connection myConn = null;
			Statement myStmt = null;
			ResultSet myRs = null;

			
			myConn = mysqlDS.getConnection();

			String sql = "select s.id, s.name, s.founded, p.sid, p.prodName, p.price from store as s inner join product p on s.id = p.sid where p.sid =" + storeID + "";
			
			
			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);
						
			ArrayList<Store> storesAndproducts = new ArrayList<Store>();
			

			// process result set
			while (myRs.next()) {
				Store p = new Store();
				p.setStoreID(myRs.getInt("id"));
				p.setStoreName(myRs.getString("name"));
				p.setFounded(myRs.getString("founded"));
				p.setProductID(myRs.getInt("sid"));
				p.setProductName(myRs.getString("prodName"));
				p.setPrice(myRs.getDouble("price"));
				storesAndproducts.add(p);
			}	
			return storesAndproducts;
		}
	
	//loadProducts
	public ArrayList<Product> loadProducts() throws Exception {
			
			Connection myConn = null;
			Statement myStmt = null;
			ResultSet myRs = null;
	
			
			myConn = mysqlDS.getConnection();
	
			String sql = "select s.id, p.pid, p.prodName, p.price from store as s inner join product p on s.id = p.sid order by pid";
	
			myStmt = myConn.createStatement();
	
			myRs = myStmt.executeQuery(sql);
			
			
			ArrayList<Product> products = new ArrayList<Product>();
	
			// process result set
			while (myRs.next()) {
				Product p = new Product();
				p.setStoreID(myRs.getInt("id"));
				p.setProductID(myRs.getInt("pid"));
				p.setProductName(myRs.getString("prodName"));
				p.setPrice(myRs.getDouble("price"));
				products.add(p);
			}	
			return products;
		}
	
	//Add Store to the database
	public void addStore(Store store) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "insert into store values (?, ?, ?)";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setInt(1, store.getStoreID());
		myStmt.setString(2, store.getStoreName());
		myStmt.setString(3, store.getFounded());
		myStmt.execute();			
	}
	
	//Add Product to the database
	public void addProduct(Product product) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "insert into store values (?, ?, ?)";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setInt(1, product.getProductID());
		myStmt.setString(2, product.getProductName());
		myStmt.setDouble(3, product.getPrice());
		myStmt.execute();			
	}
	
	//Delete Store 
		public void deleteStore(int storeID) throws SQLException {
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			
			myConn = mysqlDS.getConnection();
			String sql = "delete from store where id = ?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, storeID);
			myStmt.execute();			
		}
	
	//Delete Product
		public void deleteProduct(int productID) throws SQLException {
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			
			myConn = mysqlDS.getConnection();
			String sql = "delete from product where pid = ?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, productID);
			myStmt.execute();			
		}
}

