package com.jdc.nnh.api.services;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.nnh.api.inputs.ProductForm;
import com.jdc.nnh.api.output.SelectProduct;
import com.jdc.nnh.model.entities.Product;
import com.jdc.nnh.model.repositories.ProductRepo;
import com.jdc.nnh.utils.ModificationResult;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;

	public List<SelectProduct> findBy(ProductForm form) {
		return repo.findBy(searchFunction(form));
	}

	private Function<CriteriaBuilder, CriteriaQuery<SelectProduct>> searchFunction(ProductForm form) {
		return cb -> {
			var cq = cb.createQuery(SelectProduct.class);
			var root = cq.from(Product.class);
			SelectProduct.select(cb, cq, root);
			
			if (null != form) {
				cq.where(form.where(cb, cq, root));
			}
			return cq;
		};

	}

	public SelectProduct save(ProductForm form) {
		var p = repo.save(form.entity(null));
		return SelectProduct.from(p);

	}

	public SelectProduct update(Integer id, ProductForm form) {
		var p = repo.save(form.entity(id));
		return SelectProduct.from(p);
	}

}