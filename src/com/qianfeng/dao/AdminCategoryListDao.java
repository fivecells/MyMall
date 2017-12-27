package com.qianfeng.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qianfeng.domain.Category;
import com.qianfeng.utils.C3P0Utils;

public class AdminCategoryListDao {

	public List<Category> getAllCategoryList() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from category";
		List<Category> catlList = qr.query(sql, new BeanListHandler<Category>(Category.class));
		return catlList;
	}

	public void deleteCategory(String cid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "delete from category where cid = ?";
		qr.update(sql,cid);
	}

	public void addCategory(Category category) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into category values(?,?)";
		qr.update(sql,category.getCid(),category.getCname());
	}

	public Category getCategory(String cid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from category where cid = ?";
		Category category = qr.query(sql, new BeanHandler<Category>(Category.class),cid);
		return category;
	}

	public void updateCategory(Category category) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "update category set cname = ? where cid = ?";
		qr.update(sql,category.getCname(),category.getCid());
	}

}
