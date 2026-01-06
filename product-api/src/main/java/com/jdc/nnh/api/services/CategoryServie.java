package com.jdc.nnh.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.nnh.api.inputs.CategoryForm;
import com.jdc.nnh.api.output.CategoryInfo;
import com.jdc.nnh.model.entities.Category;
import com.jdc.nnh.model.repositories.CategoryRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryServie {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	public Category save(CategoryForm form) {
		return categoryRepo.save(form.entity(null));
	}

	public Category update(Integer id, CategoryForm form) {		
		return categoryRepo.save(form.entity(id));
	}

	public List<CategoryInfo> findAll() {
		
		return categoryRepo.findAll().stream().map(cat -> CategoryInfo.from(cat)).toList();
	}

	public CategoryInfo findById(int id) {
		
		return categoryRepo.findById(id).map(c -> CategoryInfo.from(c)).orElseThrow(() -> new EntityNotFoundException());
	}

	public CategoryInfo findByName(String name) {
		// TODO Auto-generated method stub
		return categoryRepo.findByNameAndIsActiveTrue(name).map(c -> CategoryInfo.from(c)).orElseThrow(() -> new EntityNotFoundException());
	}

}
