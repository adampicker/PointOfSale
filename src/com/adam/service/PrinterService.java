package com.adam.service;
public class PrinterService {
	
	private static final String SUFFIX = "Printer:\n";
	
	private static PrinterService printerInstance = null;
	
	private PrinterService() {}
	
	public static PrinterService getInstance() {
		
		if (printerInstance == null) printerInstance = new PrinterService();		
		return printerInstance;
	}
	
	public void print(String text) {
		StringBuilder sb = new StringBuilder();
		sb.append(SUFFIX)
		.append(text)
		.toString();
		System.out.println(sb);
	}

}