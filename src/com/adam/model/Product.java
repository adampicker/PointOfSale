package com.adam.model;

public class Product {
	
	private String productName;	
	private long barcode;	
	private double price;
	
	public String getProductName() {
		return productName;
	}
	
	public long getBarcode() {
		return barcode;
	}
	
	public double getPrice() {
		return price;
	}
 
	public static class ProductBuilder {
		
		public ProductBuilder() {}
		
		private String productName;	
		private long barcode;	
		private double price;
		
		public ProductBuilder setProductName(String productName) {
			this.productName = productName;
			return this;
		}
		
		public ProductBuilder atPrice(double price) {
			this.price = price;
			return this;
		}
		
		public ProductBuilder withUniqueBarcode(long barcode) {
			this.barcode = barcode;
			return this;
		}
		
		public Product build() {
			Product product = new Product();
			product.productName = this.productName;
			product.price = this.price;
			product.barcode = this.barcode;
			
			return product;
		}
		
	}
	
	public Product() {}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.productName)
		.append("  ")
		.append(this.price);
		
		return sb.toString();
	}

}
