package main.java;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class Checkout {

	public static void main(String[] args) {
		DecimalFormat dateFormat = new DecimalFormat(".##");
		
		List<Product> products = Arrays.asList(new Product("Apple",0.6), new Product("Apple",0.6), new Product("Orange",0.25), new Product("Apple",0.6));
		
		CheckoutImpl checkout = new CheckoutImpl();
		
		//To get the base checkout price of all products without discount
		double totalCost = checkout.calculateTotalCost(products);
		System.out.println("The total price of the products without discount = " + dateFormat.format(totalCost));
		System.out.println("=======================================================");
		
		//Calculating the discount on particular product by passing initialQuantity, finalQuantity
		// eg: - if initial quantity of Apple is 1 then for same price after discount we get 2 quantity
		// Similarly for 2 oranges we get 3 after discount
		int appleDiscount = checkout.discountOnProduct(1, 2);  // gets 50% discount
		int orangeDiscount = checkout.discountOnProduct(2, 3); // gets 34% discount
		
		List<Product> discountProducts = Arrays.asList(new Product("Orange",0.25, orangeDiscount), new Product("Orange",0.25, orangeDiscount), new Product("Orange",0.25, orangeDiscount), new Product("Apple",0.6, appleDiscount));
		
		//To get the base checkout price of all products with discount
		double totalDiscountCost = checkout.calculateDiscountTotalCost(discountProducts);
		System.out.println("The total price of the products after applying discount = " + dateFormat.format(totalDiscountCost));
		
	}

}
