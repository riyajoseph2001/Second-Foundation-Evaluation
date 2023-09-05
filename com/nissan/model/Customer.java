package com.nissan.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer implements ICustomer {
	Scanner scan = new Scanner(System.in);
	Administrator obj = new Administrator();
	CustomerDetails cust = new CustomerDetails();
	ArrayList<CustomerDetails> aj = obj.getArrayList();

	public void displayMenuCustomer() {
		int option;
		do {
			System.out.println("Choose an option:");
			System.out.println("1.Deposite Money");
			System.out.println("2.Withdraw Money");
			System.out.println("3.Display Balance");
			System.out.println("4.Transfer Money");
			System.out.println("5.Exit");
			System.out.println("Option: ");
			option = scan.nextInt();
			if (option == 1) {
				depositeMoney();
			} else if (option == 2) {
				withdrawMoney();
			} else if (option == 3) {
				displayBalance();
			} else if (option == 4) {
				transferMoney();
			}
		} while (option != 5);
	}

	@Override
	public void depositeMoney() {
		System.out.println("Enter Account Number: ");
		String id = obj.checkAccountNumber(scan.next());
		for (int i = 0; i < aj.size(); i++) {
			if (aj.get(i).getAccountNumber().equals(id)) {
				System.out.println("Enter amount to be deposited:");
				double amount = scan.nextDouble();
				if (amount > 50000) {
					System.out.println("Enter pan card number:");
					long panNumber = scan.nextLong();
					aj.get(i).setBalance(aj.get(i).getBalance() + amount);
				} else {
					aj.get(i).setBalance(aj.get(i).getBalance() + amount);
				}

				return;
			}
		}
		System.out.println("Account Number Not Found...!!!");

	}

	@Override
	public void withdrawMoney() {
		System.out.println("Enter Account Number: ");
		String id = obj.checkAccountNumber(scan.next());
		for (int i = 0; i < aj.size(); i++) {
			if (aj.get(i).getAccountNumber().equals(id)) {
				System.out.println("Enter amount to withdraw:");
				double amount = scan.nextDouble();
				double availableBalance = aj.get(i).getBalance() - aj.get(i).getMinimumBalance();
				if (amount > availableBalance) {
					System.out.println("Insufficient funds..!!!");
				} else if (amount > 50000) {
					System.out.println("Enter pan card number:");
					long panNumber = scan.nextLong();
					aj.get(i).setBalance(aj.get(i).getBalance() - amount);
				} else {
					aj.get(i).setBalance(aj.get(i).getBalance() - amount);
				}
			

			return;
		}
	}
		System.out.println("Account Number Not Found...!!!");

	}

	@Override
	public void displayBalance() {
		System.out.println("Enter Account Number: ");
		String id = obj.checkAccountNumber(scan.next());
		for (int i = 0; i < aj.size(); i++) {
			if (aj.get(i).getAccountNumber().equals(id)) {
				System.out.println("Balance:");
				System.out.println(aj.get(i).getBalance());

				return;
			}
		}
		System.out.println("Account Number Not Found...!!!");

	}

	@Override
	public void transferMoney() {
		System.out.println("Enter Account Number: ");
		String id = obj.checkAccountNumber(scan.next());
		for (int i = 0; i < aj.size(); i++) {
			if (aj.get(i).getAccountNumber().equals(id)) {
				System.out.println("Enter amount to be transfered:");
				double amount = scan.nextDouble();
				if (amount < aj.get(i).getBalance()) {
					aj.get(i).setBalance(aj.get(i).getBalance() - amount);
					System.out.println(" Transferred Amount Successfully");
				} else {
					System.out.println("Insufficient Balance");
				}

				return;
			}
		}
		System.out.println("Account Number Not Found...!!!");

	}

}
