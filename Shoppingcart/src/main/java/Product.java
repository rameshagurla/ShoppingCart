package main.java;

public class Product {
	String name;
	double pricePerUnit;
	double discount;

	public Product(String name, double pricePerUnit) {
		this.name = name;
		this.pricePerUnit = pricePerUnit;
	}
	
	public Product(String name, double pricePerUnit, double discount) {
		this.name = name;
		this.pricePerUnit = pricePerUnit;
		this.discount = calculateDiscount(pricePerUnit, discount);
	}

	public double calculateDiscount(double pricePerUnit, double discount) {
		double afterDiscount = pricePerUnit - (pricePerUnit * discount)/100;
		return afterDiscount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getPrice() {
		return pricePerUnit;
	}

	public void setPrice(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
