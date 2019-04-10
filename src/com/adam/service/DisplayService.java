package com.adam.service;
public class DisplayService {
	
	private static final String SUFFIX = "LCD display:\n";
	
	private static DisplayService displayInstance = null;
	
	private DisplayService() {}
	
	public static  DisplayService getInstance() {
		
		if (displayInstance == null) displayInstance = new DisplayService();		
		return displayInstance;
	}
	
	public void print(String text) {		
		StringBuilder sb = new StringBuilder();
		sb.append(SUFFIX)
		.append(text)
		.toString();
		System.out.println(sb);
	}

}
