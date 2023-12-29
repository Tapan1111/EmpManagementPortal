package com.work.productDto;

public class ProductDto {

	private Integer id;

	private String name;

	private int lot_number;

	private int weight;

	private int quantity;

	public ProductDto() {
		super();

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

}
