package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChange {

//	public static void main(String[] args) {
//		Overview
//		In the cash register we will calculate the amount of change returned to a customer based on the purchase price and the amount tendered. We will also notify the attendant how many of each piece of currency ($20 ,$10 ,$5 ,$1, .25c, .10c, .05c, .01c) is needed to make the change for the customer. Change should be provided using the largest bill and coin denominations as possible. Denominations that are not used should not be displayed.
//
//		Hint: Mod operator
//
//		User Story #1
//		The user is prompted asking for the price of the item.
//
		public void pricePaid() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the price of the product: ");
		double price = sc.nextDouble();

//		User Story #2
//		The user is then prompted asking how much money was tendered by the customer.		
		System.out.print("Please enter how much was tendered by the customer: ");
		double paid = sc.nextDouble();
		
		lowPrice(price, paid);
		System.out.println(change(price,paid));
		
		sc.close();

	}
//		User Story #3
//		Display an appropriate message if the customer provided too little money or the exact amount.

	public static void lowPrice(double price, double paid) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;

		while (paid < price) {
			System.out.println(
					"The price is lower than. Chose what you would like to do:\n1. Press one to cancel the transaction. ");
			System.out.println("Press 2 to enter a new tendered value.");
			choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("Goodbye!");
				break;
			} else if (choice == 2) {
				System.out.print("Enter the new amount paid: ");
				paid = sc.nextDouble();
			}
		}
		while (price == paid) {
				System.out.println("The amount paind and the amount tendered are the same value. Customer recieves no change.");
				break;
			}
		sc.close();

		}


//		User Story #4
//		If the amount tendered is more than the cost of the item, display the number of bills and coins that should be given to the customer.
	public static  String change(double price, double paid) {
		int penny;
		int dime;
		int nickel;
		int dollar;
		int five;
		int ten;
		int twenty=0;
		
		double totalChange = paid - price;
		
		String change;
		
		
		if(totalChange > 0) {
			if (totalChange / 20 > 1) {
				twenty = (int)(totalChange/20);
			    totalChange -= 20*twenty;
			    System.out.println(totalChange);
			}
		}
			change = "Please return the following bills and coins to the customer!\nTwenties :" + twenty + "\n";
		return change;
	}
	
}