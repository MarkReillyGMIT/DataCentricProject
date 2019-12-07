package com.shops;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class HeadOffice {
	
	int storeID;
	String location;
	
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	

}
