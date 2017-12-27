package com.qianfeng.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.qianfeng.domain.User;
import com.qianfeng.utils.C3P0Utils;
import com.qianfeng.web.Admin;

public class UserDao {
	QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	public User checkUser(String username, String pwd) throws SQLException {
		String sql = "select * from user where username=? and password =?";
		User user = qr.query(sql, new BeanHandler<User>(User.class),username,pwd);
		return user;
	}

	public int addUser(User user) throws SQLException {
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
		int rows = qr.update(sql,user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode());
		return rows;
	}

	public User checkUser(String username) throws SQLException {
		
		String sql = "select * from user where username=?";
		User user = qr.query(sql, new BeanHandler<User>(User.class),username);
		return user;
	}

	public Admin checkAdmin(String username, String pwd) throws SQLException {
		String sql = "select * from admin where adminname=? and password = ?";
		Admin admin = qr.query(sql,new BeanHandler<Admin>(Admin.class),username,pwd);
		return admin;
	}
}
