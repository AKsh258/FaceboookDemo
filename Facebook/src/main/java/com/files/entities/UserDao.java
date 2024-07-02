package com.files.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class UserDao {

	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;

	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver found");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akshay_test/facebook", "root", "123456");
			System.out.println("connection created");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static UserData checkLogin(String email, String password) {
		UserData u = new UserData();
		try {
			ps = con.prepareStatement("select * from user where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();

			if (rs.next()) {
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setAddress(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setMobile(rs.getLong(6));
				u.setImage(rs.getBytes(7));
				u.setDate(rs.getTimestamp(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	public static ArrayList<Post> getAllPostedData(int start,int end) {
		ArrayList<Post> m = new ArrayList<Post>();

		try {
			ps = con.prepareStatement("select * from postdata limit ?,?");
			ps.setInt(1, start);
			ps.setInt(2, end);

			rs = ps.executeQuery();

			while (rs.next()) {
				Post mm = new Post();
				mm.setPostid(rs.getString(1));
				mm.setId(rs.getInt(2));
				mm.setMessage(rs.getString(3));
				mm.setPic(rs.getBytes(4));
				mm.setLastUpdated(rs.getTimestamp(5));
				m.add(mm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	public static int countRecords() {

		int count = 0;

		try {
			ps = con.prepareStatement("select count(postid) from postdata");
			rs = ps.executeQuery();
			if (rs.next()) { 
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public static ArrayList<Comment> getAllComments() {
		ArrayList<Comment> comment = new ArrayList<Comment>();

		try {
			ps = con.prepareStatement("select * from comments");

			rs = ps.executeQuery();

			while (rs.next()) {
				Comment c = new Comment();
				c.setCmid(rs.getInt(1));
				c.setPostid(rs.getString(2));
				c.setUserid(rs.getInt(3));
				c.setComments(rs.getString(4));
				c.setCommenttime(rs.getTimestamp(5));
				comment.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comment;
	}

	public static ArrayList<Like> getAllLikes() {
		ArrayList<Like> like = new ArrayList<Like>();

		try {
			ps = con.prepareStatement("select * from likes");
			rs = ps.executeQuery();

			while (rs.next()) {
				Like l = new Like();
				l.setLikeid(rs.getInt(1));
				l.setPostid(rs.getString(2));
				l.setUserid(rs.getInt(3));
				l.setLiketime(rs.getTimestamp(4));
				like.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return like;
	}

	public static int saveRecords(UserData ud) {
		int status = 0;
		try {
			ps = con.prepareStatement("insert into user values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, ud.getId());
			ps.setString(2, ud.getName());
			ps.setString(3, ud.getAddress());
			ps.setString(4, ud.getPassword());
			ps.setString(5, ud.getEmail());
			ps.setLong(6, ud.getMobile());
			ps.setBytes(7, ud.getImage());
			ps.setTimestamp(8, new Timestamp(new Date().getTime()));

			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public static int newPost(Post p) {
		int status = 0;
		try {
			ps = con.prepareStatement("insert into postdata values(?,?,?,?,?)");
			String uniqueID = UUID.randomUUID().toString();
			ps.setString(1, uniqueID);
			ps.setInt(2, p.getId());
			ps.setString(3, p.getMessage());
			ps.setBytes(4, p.getPic());
			ps.setTimestamp(5, new Timestamp(new Date().getTime()));

			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public static Post getPostByID(String id) {
		Post m = new Post();
		try {
			ps = con.prepareStatement("select * from postdata where postid=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				m.setPostid(rs.getString(1));
				m.setId(rs.getInt(2));
				m.setMessage(rs.getString(3));
				m.setPic(rs.getBytes(4));
				m.setLastUpdated(rs.getTimestamp(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	public static int updatePost(String pid, String message, byte[] b) {
		int status = 0;
		try {
			ps = con.prepareStatement("update postdata set message=?, pic=? where postid=?;");
			ps.setString(1, message);
			ps.setBytes(2, b);
			ps.setString(3, pid);
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int DeleteYourPost(String postid, ArrayList<Integer> cmid, ArrayList<Integer> likeid) {
		int status = 0;
		try {
			ps = con.prepareStatement("DELETE FROM postdata WHERE postid='" + postid + "'");

			status = ps.executeUpdate();
			for(int c : cmid) {
				ps = con.prepareStatement("DELETE FROM comments WHERE cmid='" + c + "'");
				ps.executeUpdate();
			}
			for(int l : likeid) {
				ps = con.prepareStatement("DELETE FROM likes WHERE likeid='" + l + "'");
				ps.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public static int commentPost(int userid, String postid, String comment) {
		int status = 0;
		try {
			ps = con.prepareStatement("insert into comments (postid, userid, comments) values(?,?,?)");
			ps.setString(1, postid);
			ps.setInt(2, userid);
			ps.setString(3, comment);

			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public static UserData retriveRecords(String name, String email, String mobile) {
		
		UserData u=new UserData();
		
		try {
			ps=con.prepareStatement("select * from user where email=? and mobile=? and name=?");
			ps.setString(1, email);
			ps.setString(2, mobile);
			ps.setString(3, name);
			rs = ps.executeQuery();

			if (rs.next()) {
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setAddress(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setMobile(rs.getLong(6));
				u.setImage(rs.getBytes(7));
				u.setDate(rs.getTimestamp(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
}
