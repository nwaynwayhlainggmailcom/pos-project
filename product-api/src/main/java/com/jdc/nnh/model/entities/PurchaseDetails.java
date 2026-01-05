package com.jdc.nnh.model.entities;

import java.io.Serializable;


import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "purchase_detail_tbl")
public class PurchaseDetails {

	@EmbeddedId
	private PurchaseDetailsPk id;
	private double price;
	private int qty;
	
	@ManyToOne
	private Purchase purchase;
	@ManyToOne
	private Product product;
	@ManyToOne
	private Size size;
}