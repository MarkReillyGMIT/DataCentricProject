package com.shops;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class HeadOffice {
	
	int _id;
	String location;
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	

}
