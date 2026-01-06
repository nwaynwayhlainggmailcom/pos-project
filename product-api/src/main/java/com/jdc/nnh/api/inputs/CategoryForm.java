package com.jdc.nnh.api.inputs;

import java.util.UUID;

import com.jdc.nnh.model.entities.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoryForm(
		
		//Integer id,
		@NotBlank(message = "Please type category name !") 
		String name,
		Integer categoryId,
		Boolean isActive) {

	public Category entity(Integer id) {
		var cat = new Category();
		cat.setId(id);
		cat.setName(name);
		cat.setIsActive(isActive);

		if (null != categoryId) {
			
			var catId = new Category();
			catId.setId(categoryId);
			cat.setCategory(catId);
		}
		return cat;
	}

}