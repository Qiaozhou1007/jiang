package com.aust.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.aust.bean.User;
import com.mysql.jdbc.ResultSet;

public class Userdao {
	public static String url = "jdbc:mysql://localhost:3306/test";
	public static String user = "root";
	public static String pw = "";
	public static String path = "com.mysql.jdbc.Driver";
	public Connection con;
	public java.sql.PreparedStatement pre;
	ResultSet rs;

	public Connection getConnect() {
		try {
			Class.forName(path);// 指定连接类型
			con = DriverManager.getConnection(url, user, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void close() {
		try {
			this.con.close();
			this.pre.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int insert(User user) {
		int result = 0;
		try {
			con = getConnect();
			String sql = "insert into user(name,password,gender) values(?,?,?)";
			pre = con.prepareStatement(sql);
			pre.setString(1, user.getUsername());
			pre.setString(2, user.getPassword());
			pre.setString(3, user.getGender());
			result = pre.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return result;
		}
	}

	/*
	 * public String judge(User user) { try { con = getConnect(); String sql =
	 * "select * from user"; pre = con.prepareStatement(sql); pre.setString(1,
	 * user.getUsername()); pre.setString(2, user.getPassword());
	 * pre.setString(3, user.getGender()); pre.executeUpdate(); } catch
	 * (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return null; }
	 */

	public Map<String, Object> getPwByName(String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			con = getConnect();
			String sql = "select password,id from user where name=?";
			pre = con.prepareStatement(sql);
			pre.setString(1, name);
			rs = (ResultSet) pre.executeQuery();
			System.out.println("resultSet内容:" + rs);
			while (rs.next()) {
				// System.out.println("密码："+rs.getString("password"));
				// System.out.println("id："+rs.getInt("id"));

				// rs.getString(1) 按照所查询的sql语句中的列的索引
				map.put("pw", rs.getString(1));
				map.put("id", rs.getInt("id"));
				System.out.println("map:" + map);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map;
	};

	public Map<String, Object> registergetPwByName(String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			con = getConnect();
			String sql = "select password,id from user where name=?";
			pre = con.prepareStatement(sql);
			pre.setString(1, name);
			rs = (ResultSet) pre.executeQuery();
			while (rs.next()) {
				map.put("pw", rs.getString(1));
				map.put("id", rs.getInt("id"));
				System.out.println("map:" + map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
