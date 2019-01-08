package com.hai.idao;

import java.util.List;

import com.hai.model.Category;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface ICategoryDAO {
	
	public boolean createCategory(Category category);
	public Category readCategory(int categoryID);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(int categoryID);
	public List<Category> readAllCategorys();
	public List<Category> readCategoryByProperty(String name, Object value);
	
}
