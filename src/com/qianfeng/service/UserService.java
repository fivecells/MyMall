package com.qianfeng.service;

import java.sql.SQLException;

import com.qianfeng.dao.UserDao;
import com.qianfeng.domain.User;
import com.qianfeng.web.Admin;

public class UserService {
	UserDao dao = new UserDao();
	public User checkUser(String username, String pwd) throws SQLException {
		User user = dao.checkUser(username,pwd);
		return user;
	}

	public int addUser(User user) {
		int rows=0;
		try {
			rows = dao.addUser(user);
		} catch (SQLException e) {
			System.out.println("新建用户失败");
		}
		return rows;
	}

	public User checkUser(String username) {
		User user=null;
		try {
			user = dao.checkUser(username);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return user;
	}

	public Admin checkAdmin(String username, String pwd) {
		Admin admin = null;
		try {
			admin = dao.checkAdmin(username,pwd);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return admin;
	}
}
