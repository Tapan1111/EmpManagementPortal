package com.work.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_data")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private int lot_number;

	private int weight;

	private int quantity;

	private int totalWeight;

	public Product(Integer id, String name, int lot_number, int weight, int quantity, int totalWeight) {
		super();
		this.id = id;
		this.name = name;
		this.lot_number = lot_number;
		this.weight = weight;
		this.quantity = quantity;
		this.totalWeight = weight * quantity;

	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLot_number() {
		return lot_number;
	}

	public void setLot_number(int lot_number) {
		this.lot_number = lot_number;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(int totalWeight) {
		this.totalWeight = totalWeight;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", lot_number=" + lot_number + ", weight=" + weight
				+ ", quantity=" + quantity + ", totalWeight=" + totalWeight + "]";
	}


}
