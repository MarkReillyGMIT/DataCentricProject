package com.shops;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Store {
	
		int storeID;
		String storeName;
		String founded;
		int productID;
		String productName;
		double price;
		
		public int getProductID() {
			return productID;
		}
		public void setProductID(int productID) {
			this.productID = productID;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getStoreID() {
			return storeID;
		}
		public void setStoreID(int storeID) {
			this.storeID = storeID;
		}
		public String getStoreName() {
			return storeName;
		}
		public void setStoreName(String storeName) {
			this.storeName = storeName;
		}
		public String getFounded() {
			return founded;
		}
		public void setFounded(String founded) {
			this.founded = founded;
		}
}
