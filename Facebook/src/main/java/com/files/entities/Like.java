package com.files.entities;

import java.sql.Timestamp;

public class Like {
	private int likeid;
	private String postid;
	private int userid;
	private Timestamp liketime;
	public int getLikeid() {
		return likeid;
	}
	public void setLikeid(int likeid) {
		this.likeid = likeid;
	}
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Timestamp getLiketime() {
		return liketime;
	}
	public void setLiketime(Timestamp liketime) {
		this.liketime = liketime;
	}
	@Override
	public String toString() {
		return "Like [likeid=" + likeid + ", postid=" + postid + ", userid=" + userid + ", liketime=" + liketime + "]";
	}
}
