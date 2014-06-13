package com.apps.worldOfIce;

public class Main {

	public static void main(String[] args) {
		SalesData data = new SalesData();
		
		displayGreeting();
		data.display();
	}
	
	private static void displayGreeting(){
		System.out.println("HELLO HAPPY SALES PEOPLE!");
		System.out.println("This APP SHOWS SALES DATA");
		
		System.out.println("Test 1");
		System.out.println("Test 2");
	}

}
