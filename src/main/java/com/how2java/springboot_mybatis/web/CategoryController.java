package com.how2java.springboot_mybatis.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot_mybatis.pojo.Category;
import com.how2java.springboot_mybatis.service.CategoryService;
import com.how2java.springboot_mybatis.vo.ResponseEntity;

 
   
@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired CategoryService service;
      
    @RequestMapping("/listCategory")
    public @ResponseBody ResponseEntity listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"id desc");
        List<Category> list=service.list();
        PageInfo<Category> page = new PageInfo<Category>(list);
        
        
        ResponseEntity responseEntity = new ResponseEntity();
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("list", page);
		responseEntity.setData(data);
		return responseEntity;
    }
      
}