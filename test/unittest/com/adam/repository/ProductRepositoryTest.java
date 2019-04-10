package unittest.com.adam.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.adam.repository.ProductRepository;

class ProductRepositoryTest {

	protected ProductRepository productRepository;
	
	@BeforeEach
	protected void setUp() {
		productRepository = ProductRepository.getInstance();
	}
	
	@Test
	void repositoryInstanceSingletonTest() {
		assertNotNull(productRepository);
	}
	
	@Test
	void repositoryInstanceSingletonTest2() {
		ProductRepository secondProductRepository = ProductRepository.getInstance();
		assertSame(secondProductRepository, productRepository);
	}

}
