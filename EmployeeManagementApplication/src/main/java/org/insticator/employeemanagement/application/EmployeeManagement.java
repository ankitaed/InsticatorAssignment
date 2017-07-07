package org.insticator.employeemanagement.application;

import java.util.Scanner;

public class EmployeeManagement {

	static Scanner input=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String choice;
		
		do{
			System.out.println("Which employee operation would you like to perform:");
			System.out.println("1. Add Employee");
			System.out.println("2. Search Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit");
			System.out.println("Enter you choice: ");
			choice=input.nextLine();
			switch(choice){
			case "1": createEmployee();
					break;
					
			case "2": searchEmployee();
					break;
					
			case "3": updateEmployee();
					break;
					
			case "4": deleteEmployee();
					break;
					
			case "5": break;
					
			default: System.out.println("Please enter an option from the list");
			}
		}while (!choice.equals("5"));
		
		input.close();
	}

	private static void createEmployee() {
		
		String firstName;
		String lastName;
		
		System.out.println("Enter employee first name: ");
		firstName=input.nextLine();
		System.out.println("Enter employee last name: ");
		lastName=input.nextLine();
		
	}

	private static void searchEmployee() {
				
		System.out.println("Please enter search criteria. Expected format: \n"
				+ "example 1: FirstName= Ankita\n"
				+ "example 2: FirstName= Ankita,LastName= Abc\n"
				+ "example 3: Id= 123");
		String searchCriteria=input.nextLine();
		
	}

	private static void updateEmployee() {
		
		System.out.println("Please enter the employee id to be updated");
		Long id=input.nextLong();
	}

	private static void deleteEmployee() {
		System.out.println("Please enter the employee id to be deteletd");
		Long id=input.nextLong();
		
	}

}
