package com.qianfeng.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	public static DataSource dataSource = new ComboPooledDataSource();
	/**
	 * �õ�һ�����ӳض���
	 * @return
	 */
	public static DataSource getDataSource(){
		return dataSource;
	}
	/**
	 * �õ�һ�����Ӷ���
	 */
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
