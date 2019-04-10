import java.util.ArrayList;
import java.util.List;

import com.adam.model.Product;
import com.adam.repository.ProductRepository;
import com.adam.service.PointOfSaleService;

public class PointOfSaleApplication {

	private static List<Product> createSampleDatabaseRecords() {
		
		List<Product> sampleProducts = new ArrayList<Product>();
		
		sampleProducts.add(new Product.ProductBuilder()
				.setProductName("Screws 50pc.")
				.withUniqueBarcode(111L)
				.atPrice(5.99)
				.build());
		sampleProducts.add(new Product.ProductBuilder()
				.setProductName("Steel Hammer.")
				.withUniqueBarcode(222L)
				.atPrice(15.99)
				.build());
		sampleProducts.add(new Product.ProductBuilder()
				.setProductName("Moisture Plasterboards")
				.withUniqueBarcode(333L)
				.atPrice(8.50)
				.build());
		sampleProducts.add(new Product.ProductBuilder()
				.setProductName("Fence Panel")
				.withUniqueBarcode(444L)
				.atPrice(25.99)
				.build());
		return sampleProducts;
	}
	
	
	public static void main(String[] args) {
		
		
		// add some sample records to database
		ProductRepository productRepository = ProductRepository.getInstance();
		productRepository.saveListOfProducts(createSampleDatabaseRecords());
		
		PointOfSaleService till = PointOfSaleService.getInstance();
		
		till.open();

	}

}
