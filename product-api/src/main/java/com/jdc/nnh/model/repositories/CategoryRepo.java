package com.jdc.nnh.model.repositories;


import java.util.Optional;
import java.util.stream.Stream;

import com.jdc.nnh.model.entities.Category;

public interface CategoryRepo extends BaseRepo<Category, Integer>{

	Optional<Category> findByNameAndIsActiveTrue(String name);


	
}
