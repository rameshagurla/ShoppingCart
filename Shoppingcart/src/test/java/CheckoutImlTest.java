package test.java;
import static org.junit.Assert.assertEquals;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import main.java.CheckoutImpl;
import main.java.Product;

public class CheckoutImlTest {
	DecimalFormat dateFormat = new DecimalFormat(".##");
	CheckoutImpl checkout = new CheckoutImpl();
	int appleDiscount = checkout.discountOnProduct(1, 2);  
	int orangeDiscount = checkout.discountOnProduct(2, 3); 
	List<Product> products = Arrays.asList(new Product("Apple",0.6), new Product("Apple",0.6), new Product("Orange",0.25), new Product("Apple",0.6));
	List<Product> discountProducts = Arrays.asList(new Product("Orange",0.25, orangeDiscount), new Product("Orange",0.25, orangeDiscount), new Product("Orange",0.25, orangeDiscount), new Product("Apple",0.6, appleDiscount));
	
	//This test is used to calculate the discount on a particular product
	@Test
	public void discountOnProductTest(){
		assertEquals(true, appleDiscount>0);
		assertEquals(true, orangeDiscount>0);
		assertEquals(50, appleDiscount);
		assertEquals(34, orangeDiscount);
	}
	
	//This test is used to calculate the total cost before the discount
	@Test
	public void calculateTotalCostTest() {
		double totalCost = checkout.calculateTotalCost(products);
		assertEquals(true, totalCost>0);
		assertEquals("2.05", dateFormat.format(totalCost));
	}
	
	////This test is used to calculate the total cost after the discount
	@Test
	public void calculateDiscountTotalCostTest() {
		double totalDiscountCost = checkout.calculateDiscountTotalCost(discountProducts);
		assertEquals(true, totalDiscountCost>0);
		assertEquals(".79", dateFormat.format(totalDiscountCost));
	}
}
