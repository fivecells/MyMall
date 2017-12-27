package com.qianfeng.service;

import java.sql.SQLException;
import java.util.List;

import com.qianfeng.dao.AdminCategoryListDao;
import com.qianfeng.domain.Category;

public class AdminCategoryListService {

//	public List<Category> getAllCategory() throws SQLException {
//		AdminCategoryListDao dao = new  AdminCategoryListDao();
//		List<Category> catlList = dao.getAllCategoryList();
//		return catlList;
//	}

	public void deleteCategory(String cid) throws SQLException {
		AdminCategoryListDao dao  = new AdminCategoryListDao();
		dao.deleteCategory(cid);
	}

	public void addCategory(Category category) throws SQLException {
		AdminCategoryListDao dao  = new AdminCategoryListDao();
		dao.addCategory(category);
	}

	public Category getCategory(String cid) throws SQLException {
		AdminCategoryListDao dao  = new AdminCategoryListDao();
		Category category = dao.getCategory(cid);
		return category;
	}

	public void updateCategory(Category category) throws SQLException {
		AdminCategoryListDao dao  = new AdminCategoryListDao();
		dao.updateCategory(category);
	}

}
