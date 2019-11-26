package com.shops;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Store {
	
		int storeID;
		String storeName;
		String founded;
		
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
