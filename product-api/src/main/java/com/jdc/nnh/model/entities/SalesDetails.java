package com.jdc.nnh.model.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="sale_details_tbl")
public class SalesDetails {
	
	@EmbeddedId
	private SalesDetailsPk id;
	private int qty;
	private double subTotal;
	
	@ManyToOne
	private Sale sale;
	@ManyToOne
	private ProductPrice productPrice;
	
	

}
