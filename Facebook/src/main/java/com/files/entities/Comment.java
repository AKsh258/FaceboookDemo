package com.files.entities;

import java.sql.Timestamp;

public class Comment {
	
	private int cmid;
	private String postid;
	private int userid;
	private String comments;
	private Timestamp commenttime;
	public int getCmid() {
		return cmid;
	}
	public void setCmid(int cmid) {
		this.cmid = cmid;
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
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Timestamp getCommenttime() {
		return commenttime;
	}
	public void setCommenttime(Timestamp commenttime) {
		this.commenttime = commenttime;
	}
	@Override
	public String toString() {
		return "Comment [cmid=" + cmid + ", postid=" + postid + ", userid=" + userid + ", comments=" + comments
				+ ", commenttime=" + commenttime + "]";
	}
}
