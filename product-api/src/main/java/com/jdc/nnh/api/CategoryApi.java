package com.jdc.nnh.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.nnh.api.inputs.CategoryForm;
import com.jdc.nnh.api.output.CategoryInfo;
import com.jdc.nnh.api.services.CategoryServie;
import com.jdc.nnh.model.entities.Category;
import com.jdc.nnh.utils.ModificationResult;

@RestController
@RequestMapping("categories")
public class CategoryApi {

	@Autowired
	private CategoryServie service;
	
	@PostMapping("/save")
	ModificationResult<Integer> save(@Validated @RequestBody CategoryForm form){
		var category = service.save(form);	
		return ModificationResult.success(category.getId(),"%s has successfully saved.".formatted(category.getName()));
	}

	@PostMapping("/update/{id}")
	ModificationResult<Integer> update(@Validated @RequestBody CategoryForm form,@PathVariable(required = false) Integer id){
		var category = service.update(id,form);	
		return ModificationResult.success(category.getId(),"%s has successfully updated.".formatted(category.getName()));
	}
	
	@GetMapping
	List<CategoryInfo> findAll(){
		return service.findAll();
	
	}
	
	@GetMapping("{id}")
	CategoryInfo findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@GetMapping("/findbyName")
	CategoryInfo findByName(@RequestParam(name="category") String name) {
		return service.findByName(name);
	}
	
}