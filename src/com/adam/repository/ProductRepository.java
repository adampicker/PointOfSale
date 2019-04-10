package com.adam.repository;
import java.util.List;

import com.adam.dao.ProductDao;
import com.adam.model.Product;

public class ProductRepository {
	
	ProductDao productDao;
	public static ProductRepository productRepository = null;
	
	public static ProductRepository getInstance() {
		if (productRepository == null) {
			productRepository = new ProductRepository();
		}
		return productRepository;
	}
	
	private ProductRepository() {
		productDao = new ProductDao();
	}
	
	public Product findProduct(Product p) {
		for (Product product : productDao.findAll()) {
			if (product.getProductName().equalsIgnoreCase(p.getProductName()) && 
					product.getBarcode() == p.getBarcode() && 
					product.getPrice() == p.getPrice()) return product;
		}
		return null;
	}
	
	public Product findProductByBarcode(long barcode) {
		for (Product product : productDao.findAll()) {
			if (product.getBarcode() == barcode) return product;
		}
		return null;
	}
	
	public void saveListOfProducts(List<Product> products) {
		for (Product product : products) {
			productDao.save(product);
		}
	}

}
