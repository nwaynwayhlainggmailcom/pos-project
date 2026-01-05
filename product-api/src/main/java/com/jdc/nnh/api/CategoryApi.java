package com.jdc.nnh.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.nnh.api.inputs.CategoryForm;
import com.jdc.nnh.api.output.CategoryInfo;
import com.jdc.nnh.api.services.CategoryServie;
import com.jdc.nnh.model.entities.Category;

@RestController
@RequestMapping("categories")
public class CategoryApi {

	@Autowired
	private CategoryServie service;
	
	@PostMapping("/save")
	CategoryInfo save(@Validated @RequestBody CategoryForm form){
		var category = service.save(form);
		var info = CategoryInfo.from(category);		
		return info;
	}
}