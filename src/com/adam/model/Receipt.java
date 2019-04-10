package com.adam.model;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
	
	List<Product> receipt;
	
	public Receipt() {
		receipt = new ArrayList<Product>();
	}
	
	public String toString() {
		
		StringBuilder receiptToPrint = new StringBuilder();
		
		for (int i = 0; i < this.receipt.size(); i++) {
			receiptToPrint.append(i+1 + ": ")
				.append(this.receipt.get(i).getProductName())
				.append("     ")
				.append(this.receipt.get(i).getPrice())
				.append("\n")
				.toString();
		}
		
		return receiptToPrint.append("     Total amount:    " + countTheBill()).toString();
	}
	
	
	public double countTheBill() {
		double totalAmount = 0;
		for (Product product : this.receipt) totalAmount += product.getPrice();
		
		return totalAmount;
	}
	
	public void addProductToReceipt(Product p) {
		receipt.add(p);
	}

}
