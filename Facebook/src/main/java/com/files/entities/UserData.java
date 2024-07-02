package com.files.entities;

import java.sql.Timestamp;
import java.util.Arrays;

public class UserData {
	
	private int id;
	private String name,address,password,email;
	private long mobile;
	private byte image[];
	private Timestamp date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "UserData [id=" + id + ", name=" + name + ", address=" + address + ", password=" + password + ", email="
				+ email + ", mobile=" + mobile + ", image=" + Arrays.toString(image) + ", date=" + date 
				;
	}
	
}
