package com.hai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hai.idao.ICategoryDAO;
import com.hai.iservice.ICategoryService;
import com.hai.model.Category;

@Service
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	ICategoryDAO categoryDAO;
	
	@Override
	public List<Category> getAllCategory() {
		
		return categoryDAO.readAllCategorys();
	}

}
