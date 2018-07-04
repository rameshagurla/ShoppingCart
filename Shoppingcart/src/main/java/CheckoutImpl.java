package main.java;

import java.util.List;

import main.java.Product;

public class CheckoutImpl {

	//returns the base checkout price of all products without discount
	public double calculateTotalCost(List<Product> products) {
		return products.stream().filter(o -> o.getPrice() > 0).mapToDouble(Product::getPrice).sum();
	}

	//calculating discount percentage based on initial quantity and final quantity 
	public int discountOnProduct(int initialQuantity, int finalQuantity) {
		int discount  = 100 - (initialQuantity * 100)/finalQuantity;
		return discount;
	}

	//return the base checkout price of all products with discount
	public double calculateDiscountTotalCost(List<Product> discountProducts) {
		return discountProducts.stream().filter(o -> o.discount > 0).mapToDouble(Product::getDiscount).sum();
	}
	
}
