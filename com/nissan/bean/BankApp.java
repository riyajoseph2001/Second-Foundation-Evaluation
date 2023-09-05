package com.nissan.bean;

import java.util.ArrayList;

import java.util.Scanner;

import com.nissan.model.Administrator;
import com.nissan.model.Customer;

public class BankApp {

	public static void main(String[] args) {
		menuDisplay();

	}

	public static void menuDisplay() {
		Scanner scan = new Scanner(System.in);
		int choice =0;
		Administrator admin = new Administrator();
		Customer customer = new Customer();
		do {
			try {
		System.out.println("WELCOME TO BANK APPLICATION");
		System.out.println("1.Administrator Login");
		System.out.println("2.Customer Login");
		System.out.println("Choose one option: ");
		choice = Integer.parseInt(scan.nextLine());
		if(choice==1) {
			admin.displayMenuAdmin();
		}
		else if(choice==2) {
			customer.displayMenuCustomer();
			
		}
			}catch(Exception e) {
				System.out.println(e);
				System.out.println("Enter the correct option:");
				
			}
		}while(true);
			
	}

}
