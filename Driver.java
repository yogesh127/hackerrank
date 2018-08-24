package bank;


import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
public class Driver 
{

	public static void main(String[] args) throws Exception
	{
		System.out.println("----------Welcome to YSYP Bnaking System-------------");
		
		
		String choice;
		
		ArrayList<Customer> customerlist  ;
		FileDataBase f = new FileDataBase();
		customerlist=f.read();
		Bank bank = new Bank(customerlist);
		
		
		do
		{
			System.out.println();
			System.out.println("1.New Customer and account creation");
			System.out.println("2.Credit");
			System.out.println("3.Debit");
			System.out.println("4.View Balance");
			System.out.println("5.View Transactions");
			System.out.println("6.View Customer Details");
			System.out.println("Enter Q for Quit ");
			Scanner sc =new Scanner(System.in);
			choice = sc.nextLine();
			switch(choice)
			{
			case "1":
				bank.addCustomer();
				break;
			case "2":
				bank.credit();
				break;
			case "3":
				bank.debit();
				break;
			case "4":
				bank.viewBalance();
				break;
			case "5":
				bank.viewTransactions();
				break;
			case "6":
				bank.viewCustomers();
				break;
			default:
				System.out.println("Wrong Choice");
			}
		}while(!(choice.equalsIgnoreCase("q")));
		
		
		
		

	}

}