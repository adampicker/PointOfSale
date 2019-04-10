package unittest.com.adam.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.adam.model.Product;
import com.adam.model.Receipt;

class ReceiptTest {

	private double price1, price2;
	
	@BeforeEach
	protected void setUp() {
		price1 = 15.99;
		price2 = 8.45;
	}
	
	@Test
	void countTheBillTest() {
		Receipt receipt = new Receipt();
		//prepare some products
		receipt.addProductToReceipt(new Product.ProductBuilder()
												.atPrice(price1)
												.build());
		receipt.addProductToReceipt(new Product.ProductBuilder()
				.atPrice(price2)
				.build());
		
		assertEquals(price1 + price2, receipt.countTheBill());
		
	}

}
