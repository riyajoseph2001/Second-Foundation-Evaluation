package com.nissan.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Administrator implements IAdministrator {
	Scanner scan = new Scanner(System.in);
	static ArrayList<CustomerDetails> cd = new ArrayList<CustomerDetails>();

	public void displayMenuAdmin() {
		int option;
		do {
			CustomerDetails cust = new CustomerDetails();
			System.out.println("Choose an option:");
			System.out.println("1.Add new customer");
			System.out.println("2.Update customer details");
			System.out.println("3.Delete a customer");
			System.out.println("4.Display all customers");
			System.out.println("5.Display details of a customer");
			System.out.println("6.Exit");
			System.out.println("Option: ");
			option = scan.nextInt();
			if (option == 1) {
				addCustomer();
			} else if (option == 2) {
				updateCustomer();
			} else if (option == 3) {
				deleteCustomer();
			} else if (option == 4) {
				displayAllCustomers();
			} else if (option == 5) {
				displayCustomer();
			}
		} while (option != 6);

	}

	public ArrayList<CustomerDetails> getArrayList() {
		return cd;
	}

	@Override
	public void addCustomer() {
		char choice = 'n';
		do {
			CustomerDetails obj = new CustomerDetails();
			System.out.println("Enter Customer Name: ");
			obj.setCustomerName(checkName(scan.next()));
			System.out.println("Enter Account Type(Savings/Current): ");
			obj.setAccountType(scan.next());
			System.out.println("Enter Balance:");
			obj.setBalance(scan.nextDouble());
			obj.setMinimumBalance(1000);
			System.out.println("Enter Mobile Number: ");
			obj.setMobileNumber(checkMobile(scan.next()));
			System.out.println("Enter Email Id:");
			obj.setEmailId(scan.next());
			obj.setAccountNumber(Integer.toString(generateAccountNumber()));
			obj.setAtmPin(generateAtmPin());
			cd.add(obj);
			System.out.println("Do you want to continue(y/n):");
			choice = scan.next().charAt(0);

		} while (choice == 'Y' || choice == 'y');

	}

	private int generateAccountNumber() {
		Random random = new Random();
		return 100000000 + random.nextInt(900000000);
	}

	private int generateAtmPin() {
		Random random = new Random();
		return 1000 + random.nextInt(9000);
	}

	@Override
	public void updateCustomer() {
		System.out.println("Enter Account Number: ");
		String id = checkAccountNumber(scan.next());
		for (int i = 0; i < cd.size(); i++) {
			if (cd.get(i).getAccountNumber().equals(id)) {
				System.out.println("Enter new Mobile Number: ");
				cd.get(i).setMobileNumber(checkMobile(scan.next()));
				System.out.println("Enter new Email Id: ");
				cd.get(i).setEmailId(scan.next());
				System.out.println("Details updated sucessfully!");
				return;
			}
		}
		System.out.println("Account Number Not Found...!!!");

	}

	@Override
	public void deleteCustomer() {
		System.out.print("Enter Account Number : ");
		String id = checkAccountNumber(scan.next());
		for (int i = 0; i < cd.size(); i++) {
			if (cd.get(i).getAccountNumber().equals(id)) {
				cd.remove(i);
				System.out.println("Customer Details deleted...");
				return;
			}
		}
		System.out.println("Account Number Not Found...!!!");

	}

	@Override
	public void displayAllCustomers() {
		System.out.println("Customer Details ");
		for (int i = 0; i < cd.size(); i++)
			System.out.println(cd.get(i).toString());

	}

	@Override
	public void displayCustomer() {
		System.out.print("Enter Account Number : ");
		String id = scan.next();
		for (int i = 0; i < cd.size(); i++) {
			if (cd.get(i).getAccountNumber().equals(id)) {
				System.out.println(cd.toString());
				return;
			}
		}
		System.out.println("Account Number Not Found...!!!");

	}

	private static String checkName(String customerName) {

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			Pattern pattern = Pattern.compile("[^A-Za-z ]");
			do {

				Matcher matcher = pattern.matcher(customerName);
				boolean finder = matcher.find();

				if (finder) {
					System.out.println("Name must contain only alphabets. Please re-enter!");
					customerName = br.readLine();
				} else if (customerName.length() > 30) {
					System.out.println("Name must not be longer than 30 letters please re-enter!");
					customerName = br.readLine();
				} else {
					break;
				}
			} while (true);
		} catch (Exception e) {
			System.out.println(e);
		}
		return customerName;
	}

	private String checkMobile(String mobileNumber) {
		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Pattern pattern = Pattern.compile("[^0-9]");
			do {
				Matcher matcher = pattern.matcher(mobileNumber);
				boolean finder = matcher.find();
				if (finder) {
					System.out.println("Mobile Number must contain only digits please re-enter!");
					mobileNumber = br.readLine();
				} else if (mobileNumber.length() > 10) {
					System.out.println("Mobile Number must not be longer than 10 digits please re-enter!");
					mobileNumber = br.readLine();
				} else if (mobileNumber.length() < 10) {
					System.out.println("Mobile Number should not be less than 10 digits please re-enter!");
					mobileNumber = br.readLine();

				} else {
					break;
				}
			} while (true);
		} catch (Exception e) {
			System.out.println(e);
		}
		return mobileNumber;
	}

	String checkAccountNumber(String accountNo) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Pattern pattern = Pattern.compile("[^0-9]");
			do {

				Matcher matcher = pattern.matcher(accountNo);
				boolean finder = matcher.find();
				if (finder) {
					System.out.println("Account Number must contain only digits please re-enter!");
					accountNo = br.readLine();
				} else if (accountNo.length() > 9) {
					System.out.println("Account Number must not be longer than 9 digits please re-enter!");
					accountNo = br.readLine();
				} else {
					break;
				}
			} while (true);
		} catch (Exception e) {
			System.out.println(e);
		}
		return accountNo;
	}

}
