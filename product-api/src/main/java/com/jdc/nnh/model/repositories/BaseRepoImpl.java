package com.jdc.nnh.model.repositories;

import java.util.List;
import java.util.function.Function;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

//simplejaarepo ko extends cuz don't want to override method
//now override only constructor
//create configuration class in com.jdc.nnh cuz want to call BaseRepoImpl class directly
public class BaseRepoImpl<T,ID> extends SimpleJpaRepository<T, ID> implements BaseRepo<T, ID>{

	private EntityManager em;
	
	public BaseRepoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em = entityManager;
	}

	@Override
	public <R> List<R> findBy(Function<CriteriaBuilder, CriteriaQuery<R>> queryFun) {	
		return em.createQuery(queryFun.apply(em.getCriteriaBuilder())).getResultList();
	}

}