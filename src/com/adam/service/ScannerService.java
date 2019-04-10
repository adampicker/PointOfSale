package com.adam.service;
import java.util.Scanner;

public class ScannerService {
	
	private static final String EXIT_MESSAGE = "exit";
	
	private static final long EMPTY_BARCODE_CODE = 0L;
	private static final long EXIT_CODE = -1L;
	
	private static ScannerService scannerInstance = null;
	private static Scanner scanner;
	
	private ScannerService() {
		scanner = new Scanner(System.in);
	}
	
	public static ScannerService getScannerInstance() {
		
		if (scannerInstance == null) scannerInstance = new ScannerService();		
		return scannerInstance;
	}
	
	public long scanBarcode() {
		getScannerInstance();
		String inputLine = "";
		long outputCode;
		inputLine = scanner.nextLine();		
		outputCode = resolveInputFromScanner(inputLine);
		
		return outputCode;
	}
	
	public long resolveInputFromScanner(String inputLine) {
		if (inputLine.isEmpty() || inputLine.equals("\n") || inputLine.equals(" ")) return EMPTY_BARCODE_CODE;
		else if (inputLine.equalsIgnoreCase(EXIT_MESSAGE)) return EXIT_CODE;
		else return Long.parseLong(inputLine);
	}
	

}
