package com.jdc.nnh.api.output;

import java.util.UUID;

import com.jdc.nnh.model.entities.Category;

public record CategoryInfo(
		int id,
		String name,
		Category category
		){

	public static CategoryInfo from(Category c) {
		return new CategoryInfo(c.getId(),c.getName(),c.getCategory());
	}

}