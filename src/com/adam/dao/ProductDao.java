package com.adam.dao;
import java.util.ArrayList;
import java.util.List;

import com.adam.model.Product;


public class ProductDao implements Dao<Product>{

	List<Product> productsDatabase;
	
	public ProductDao() {
		productsDatabase = new ArrayList<Product>();
	}
	
	@Override
	public Product create(Product t) {
		productsDatabase.add(t);
		return productsDatabase.get(productsDatabase.size()-1);
	}

	@Override
	public Product read(int index) {

		return productsDatabase.get(index);
	}

	@Override
	public Product update(Product t, int index) {
		for (int i = 0; i < productsDatabase.size(); i++) {
			if (productsDatabase.get(i).getBarcode() == t.getBarcode()) {
				productsDatabase.set(i, t);
				return productsDatabase.get(i);
			}
		}
		return null;
	}

	@Override
	public void save(Product t) {
		productsDatabase.add(t);		
	}

	@Override
	public List<Product> findAll() {
		return productsDatabase;
	}




}
