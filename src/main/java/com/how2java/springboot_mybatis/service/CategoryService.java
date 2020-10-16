package com.how2java.springboot_mybatis.service;

import java.util.List;

import com.how2java.springboot_mybatis.pojo.Category;


public interface CategoryService {
	List<Category> list();
	void add(Category record);
	void update(Category record);
	void delete(int id);
	Category get(int id);
}
