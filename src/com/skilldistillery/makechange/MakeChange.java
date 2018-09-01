package com.skilldistillery.makechange;

import java.util.Scanner;


public class MakeChange {
double price;
double paid;
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
		price = sc.nextDouble() * 100;

//		User Story #2
//		The user is then prompted asking how much money was tendered by the customer.		
		System.out.print("Please enter how much was tendered by the customer: ");
		paid = sc.nextDouble() * 100;
		
		int choice = isPoor();
		System.out.println(choice);
		System.out.println(change(choice));
		
		sc.close();

	}
//		User Story #3
//		Display an appropriate message if the customer provided too little money or the exact amount.

	public int isPoor() {
		Scanner sc = new Scanner(System.in);
		int choice = 2;
		
		while (paid < price) {
			System.out.println("The amount tendered is lower than the price. Chose an option below:\n1. Press 1 to cancel the transaction. ");
			System.out.println("2. Press 2 to enter a new tendered value.");
			choice = sc.nextInt();
			if (choice == 1) {
				break;
			} else if (choice == 2) {
				System.out.print("Enter the new amount paid: ");
				paid = sc.nextDouble() * 100;
			}
		}
		
		if (price == paid) {
				System.out.println("The amount paid and the amount tendered are the same value. Customer recieves no change.");
				price = paid - 2;
				choice = 1;     //latest change
			}
		
		sc.close();
		return choice;
		

		}


//		User Story #4
//		If the amount tendered is more than the cost of the item, display the number of bills and coins that should be given to the customer.
	public  String change(int choice) {
		double totalChange = paid - price;
		int penny = 0;
		int dime = 0;
		int nickel = 0;
		int quarter = 0;
		
		int dollar = 0;
		int five = 0;
		int ten = 0;
		int twenty = 0;
		
		String change = "\nThe transaction was unsuccessful.Please return the customer his $" + paid/100;
		

		
		
	if(choice == 2)	{
		if(totalChange > 0) {
			if (totalChange / 2000 >= 1) {
				twenty = (int)(totalChange / 2_000);
			    totalChange = (totalChange % 2_000);
			}
			if (totalChange / 1000 >= 1) {
				ten = (int)(totalChange / 1_000);
				totalChange = (totalChange % 1_000);
			}
			if (totalChange / 500 >= 1) {
				five = (int)(totalChange / 500);
				totalChange = (totalChange % 500);
			}
			if (totalChange / 100 >= 1) {
				dollar = (int)(totalChange / 100);
				totalChange = (totalChange % 100);
			}
			if (totalChange / 25 >= 1) {
				quarter = (int)(totalChange / 25);
				totalChange = (totalChange % 25);
			}
			if (totalChange / 10 >= 1) {
				dime = (int)(totalChange / 10);
				totalChange = (totalChange % 10);
			}
			if (totalChange / 5 >= 1) {
				nickel = (int)(totalChange / 5);
				totalChange = (totalChange % 5);
			}
			if (totalChange / 1 >= 1) {
				penny = (int)(totalChange / 1);
				totalChange = 0;
			}
		}
			change = "\nPlease return the following change to the customer!\n\nBills" + "\n$20 Bills:\t" + twenty + "\n$10 Bills:\t" + ten + "\n$5 Bills:\t" + five + "\n$1 Bills:\t" + dollar + "\n\nCoins" + "\nQuarters:\t" + quarter + "\nDimes:\t\t" + dime  + "\nNickels:\t"+  nickel + "\nPennies:\t" + penny;
		}
	
	
		else if (price == paid - 2) {
			change = "\nCustomer has paid the full amount. There is no change to be distributed.";
		}
		
		
		return change;
	}
	
}