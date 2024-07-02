package com.files.entities;

import java.sql.Timestamp;
import java.util.Arrays;

public class Post {
	
	private String postid;
	private int id;
	private String message;
	private byte[] pic;
	private Timestamp lastUpdated;
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	@Override
	public String toString() {
		return "Post [postid=" + postid + ", id=" + id + ", message=" + message + ", pic=" + Arrays.toString(pic)
				+ ", lastUpdated=" + lastUpdated +"]";
	} 
}
