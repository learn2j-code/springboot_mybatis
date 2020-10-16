package com.how2java.springboot_mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.how2java.springboot_mybatis.mapper.CategoryMapper;
import com.how2java.springboot_mybatis.pojo.Category;
import com.how2java.springboot_mybatis.pojo.CategoryExample;
import com.how2java.springboot_mybatis.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryMapper mapper;
	@Override
	public List<Category> list() {
		CategoryExample example = new CategoryExample();
		example.setOrderByClause("id asc");
		return mapper.selectByExample(example);
	}

	@Override
	public void add(Category record) {
		mapper.insertSelective(record);
	}

	@Override
	public void update(Category record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void delete(int id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Category get(int id) {
		return mapper.selectByPrimaryKey(id);
	}

}
