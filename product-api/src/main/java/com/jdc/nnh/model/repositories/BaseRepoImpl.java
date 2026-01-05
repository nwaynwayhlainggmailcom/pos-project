package com.jdc.nnh.model.repositories;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import jakarta.persistence.EntityManager;

//simplejaarepo ko extends cuz don't want to override method
//now override only constructor
//create configuration class in com.jdc.nnh cuz want to call BaseRepoImpl class directly
public class BaseRepoImpl<T,ID> extends SimpleJpaRepository<T, ID> implements BaseRepo<T, ID>{

	public BaseRepoImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		
	}

}
