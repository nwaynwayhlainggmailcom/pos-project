package com.jdc.nnh.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="category_tbl")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column (nullable = false,length =45, unique = true)
	private String name;
	@ColumnDefault("1")
	private Boolean isActive;
	
	@ManyToOne
	private Category category;
	@OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	List<Product> products = new ArrayList<>();

}
