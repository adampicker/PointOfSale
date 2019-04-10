package com.adam.service;
import com.adam.model.Product;
import com.adam.model.Receipt;
import com.adam.repository.ProductRepository;


public class PointOfSaleService implements PointOfSale {

	private static final String PRODUCT_NOT_FOUND_MESSAGE = "Product not found";
	private static final String INVALID_BARCODE_MESSAGE = "Invalid bar-code";
	private static final String PLEASE_SCAN_THE_BARCODE_MESSAGE = "Please scan the barcode..";
	
	
	private static PointOfSaleService pointOfSaleServiceInstance = null;
	private ScannerService scannerInstance = null;
	private PrinterService printerInstance = null;
	private ProductRepository productServiceInstance = null;
	private DisplayService displayInstance = null;
	
	public static PointOfSaleService getInstance() {
		if (pointOfSaleServiceInstance == null) pointOfSaleServiceInstance = new PointOfSaleService();
		return pointOfSaleServiceInstance;
	}

	@Override
	public void open() {
		if (scannerInstance == null) {
			displayInstance.print("Scanner connection interrupted");
			System.exit(0);
		}
		if (printerInstance == null) {
			displayInstance.print("Printer connection interrupted");
			System.exit(0);
		}
		if (productServiceInstance == null) {
			displayInstance.print("Error while connections to database");
			System.exit(0);
		}
		if (displayInstance == null) {
			System.exit(0);
		}
		else nextCustomer();
		
		
	}

	@Override
	public void nextCustomer() {
		 Receipt receipt = new Receipt();
		 long scannedBarcode = 0L;
		 
		 do {
			 displayInstance.print(PLEASE_SCAN_THE_BARCODE_MESSAGE);
			 scannedBarcode = scannerInstance.scanBarcode();
			 
			 if (scannedBarcode == 0L ) invalidBarcode(); 
			 else if (scannedBarcode > 0L) addProductToReceipt(scannedBarcode, receipt);
			 else if (scannedBarcode == -1L) break;
		 }  while (scannedBarcode >= 0L);
		 
		 if (scannedBarcode == -1L) {
			 printerInstance.print(receipt.toString());
			 displayInstance.print("     Total amount:    " + receipt.countTheBill());
		 }	
	}
	
	private PointOfSaleService() {
		scannerInstance = ScannerService.getScannerInstance();
		printerInstance = PrinterService.getInstance();
		productServiceInstance = ProductRepository.getInstance();
		displayInstance = DisplayService.getInstance();
	}
	
	private void invalidBarcode() {
		displayInstance.print(INVALID_BARCODE_MESSAGE);
	}
	
	private void addProductToReceipt(long scannedBarcode, Receipt receipt) {
		Product p = productServiceInstance.findProductByBarcode(scannedBarcode); 
		 if (p == null) displayInstance.print(PRODUCT_NOT_FOUND_MESSAGE);
		 else {
			 receipt.addProductToReceipt(p);
			 displayInstance.print(p.toString());
		 }
	}
}
