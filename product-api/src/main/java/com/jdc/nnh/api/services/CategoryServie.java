package com.jdc.nnh.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.nnh.api.inputs.CategoryForm;
import com.jdc.nnh.model.entities.Category;
import com.jdc.nnh.model.repositories.CategoryRepo;

@Service
public class CategoryServie {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	public Category save(CategoryForm form) {
		return categoryRepo.save(form.entity());
	}

}
