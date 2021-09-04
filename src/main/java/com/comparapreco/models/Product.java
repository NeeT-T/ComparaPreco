package com.comparapreco.models;

public class Product {
	private String name;
	private Brand brand;
	private Category category;
	
	public Product() {}

	public Product(String name, Brand brand, Category category) {
		this.setName(name);
		this.setBrand(brand);
		this.setCategory(category);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
