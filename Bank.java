package bank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class Bank 
{
	ArrayList<Customer> customerlist;
	ArrayList<Transaction> transactionlist;
	File f = new File();
	
	Bank(ArrayList<Customer> customerlist) throws IOException, Exception
	{
		this.customerlist = customerlist;
		
		transactionlist = new ArrayList<Transaction>();
	}
	
	void addCustomer() throws IOException
	{
		Scanner sc=null;
		sc = new Scanner(System.in);
		System.out.println("Enter customer name");
		String name = sc.nextLine();
		System.out.println("Enter customer address");
		String addr = sc.nextLine();
		System.out.println("Enter customer PAN number");
		String pan = sc.nextLine();
		System.out.println("Enter customer AADHAR number");
		String aadhar = sc.nextLine();
		System.out.println("Enter customer phone number");
		String phone = sc.nextLine();
		System.out.println("Enter the Branch in which you want to open account");
		System.out.println("1 for PUNE\n2 for MUMBAI\n3 for DELHI");
		int branchchoice = sc.nextInt();
		Branch branchobj = null;
		switch(branchchoice)
		{
		case 1:
			branchobj = new Branch(1,"PUNE","PUN001");
			break;
		case 2:
			branchobj = new Branch(2,"MUMBAI","MUM002");
			break;
		case 3:
			branchobj = new Branch(3,"DELHI","DEL003");
			break;
		default:
			System.out.println("The Branch you type is wrong");
		}
		Random random = new Random(); 
		long accountnumber = 100000 + random.nextInt(900000);
		System.out.println("Enter the account type\n1 for Current\n2 for Savings");
		int accountype = sc.nextInt();
		Account accountobj = null;
		if(accountype == 1)
			accountobj = new Current(accountnumber,0);
		else if(accountype == 2)
			accountobj = new Savings(accountnumber,500);
		Customer customer = new Customer(name,addr,pan,aadhar,phone,branchobj,accountobj);
		customerlist.add(customer);
		FileDataBase f = new FileDataBase();
		f.write(customerlist);
		System.out.println(name + " account is created");
		System.out.println("Account number is : " + accountnumber);
		//sc.close();
	}
	
	void viewCustomers()
	{
		System.out.println();
		for(Customer customer : customerlist)
		{
			System.out.println("Name             : " + customer.getCustomername());
			System.out.println("Address          : " + customer.getCustomeraddress());
			System.out.println("PAN number       : " + customer.getPannumber());
			System.out.println("AADHAR           : " + customer.getAadharnumber());
			System.out.println("Phone            : " + customer.getPhonenumber());
			System.out.println("BranchId         : " + customer.getBranchobj().getBranchid());
			System.out.println("Branch Location  : " + customer.getBranchobj().getBranchlocation());
			System.out.println("IFSC Code        : " + customer.getBranchobj().getIfsc());
			System.out.println("Account Number   : " + customer.getAccountobj().getAccountnumber());
			System.out.println("Account Balance  : " + customer.getAccountobj().getBalance());
			if(customer.getAccountobj() instanceof Current)
			{
				System.out.println("Account Type     : Current ");
				System.out.println("Minimum Balance  : -10000");
			}
			else if(customer.getAccountobj() instanceof Savings)
			{
				System.out.println("Account Type     : Savings ");
				System.out.println("Minimum Balance  : 500");
			}
			System.out.println("-------------------------------------------");
			
			
			
			
		}
	}
	
	void credit() throws IOException
	{
		System.out.println("-----------------Admin Mode-------------------------");
		Scanner sc=null;
		sc = new Scanner(System.in);
		System.out.println("Enter Bank Admin username");
		String username = sc.nextLine();
		System.out.println("Enter Bank Admin password");
		String password = sc.nextLine();
		if(username.equals("yadvendra") && password.equals("yadav"))
		{
			long accountnumber;
			double amount;
			System.out.println("Enter the customer account number : ");
			accountnumber = sc.nextLong();
			boolean flag = false;
			for(Customer customer : customerlist)
			{
				if(customer.getAccountobj().getAccountnumber() == accountnumber)
					flag = true;
			}
			if(flag == true)
			{
				System.out.println("Enter the amount you want to credit : (LIMIT : 50000) ");
				do
				{
					amount = sc.nextDouble();
					if(validateCreditAmount(amount))
						break;
					else
						System.out.println("Enter valid amount");
				}while(true);
				for(Customer customer : customerlist)
				{
					if(customer.getAccountobj().getAccountnumber() == accountnumber)
					{
						customer.getAccountobj().setBalance(customer.getAccountobj().getBalance() + amount);
						Transaction transaction = new Transaction(customer.getAccountobj().getAccountnumber(),amount,"Credit");
						transactionlist.add(transaction);
						FileDataBase f = new FileDataBase();
						f.write(customerlist);
					}
				}
				FileDataBase f = new FileDataBase();
				f.write(customerlist);
				
			}
			else
			{
				System.out.println("Invalid account number");
			}
		}
		else
		{
			System.out.println("Wrong Admin username and password");
		}
		////sc.close();
	}
	
	boolean validateCreditAmount(double amount)
	{
		if(amount <=0 || amount > 50000)
			return false;
		else
			return true;
	}
	
	void debit()
	{
		System.out.println("-----------------Admin Mode-------------------------");
		Scanner sc=null;
		sc = new Scanner(System.in);
		System.out.println("Enter Bank Admin username");
		String username = sc.next();
		System.out.println("Enter Bank Admin password");
		String password = sc.next();
		if(username.equals("yadvendra") && password.equals("yadav"))
		{
			long accountnumber;
			double amount;
			System.out.println("Enter the customer account number : ");
			accountnumber = sc.nextLong();
			boolean flag = false;
			for(Customer customer : customerlist)
			{
				if(customer.getAccountobj().getAccountnumber() == accountnumber)
					flag = true;
			}
			if(flag == true)
			{
				for(Customer customer : customerlist)
				{
					if(customer.getAccountobj().getAccountnumber() == accountnumber)
					{
						System.out.println("Enter the amount you want to debit");
						do
						{
							amount = sc.nextDouble();
							if(validateDebitAmount(amount,customer.getAccountobj()))
								break;
							else
							{
								System.out.println("Insufficient or invalid amount");
								return;
							}
						}while(true);
						customer.getAccountobj().setBalance(customer.getAccountobj().getBalance() - amount);
						Transaction transaction = new Transaction(customer.getAccountobj().getAccountnumber(),amount,"Debit");
						transactionlist.add(transaction);
						FileDataBase f = new FileDataBase();
						try {
							f.write(customerlist);
						} catch (IOException e) {
							System.out.println(e);
						}
					}
				}
				
			}
			else
			{
				System.out.println("Invalid account number");
			}
		}
		else
		{
			System.out.println("Wrong Admin username and password");
		}
		//sc.close();
	}
	
	boolean validateDebitAmount(double amount,Account obj)
	{
		if(amount <= 0)
			return false;
		if(obj instanceof Current)
		{
			if((obj.getBalance() + 10000 - amount) > 0)
				return true;
			else 
				return false;
		}
		else if(obj instanceof Savings)
		{
			if((obj.getBalance() - 500 - amount) > 0)
				return true;
			else
				return false;
		}
		return false;
	}
	
	void viewBalance()
	{
		System.out.println("Enter the account number to view balance : ");
		Scanner sc=null;
		sc = new Scanner(System.in);
		long accountnumber = sc.nextLong();
		boolean flag = false;
		for(Customer customer : customerlist)
		{
			if(customer.getAccountobj().getAccountnumber() == accountnumber)
			{
				System.out.println("Your balance is : " + customer.getAccountobj().getBalance());
				flag = true;
			}
		}
		if(flag == false)
			System.out.println("Invalid account number");
	/*	try
		{
		FileHandle file = new FileHandle();
		float balance = file.balanceCheck(accountnumber);
		System.out.println("THe Balance is " +balance);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		*/
		//sc.close();
	}
	
	void viewTransactions()
	{
		if(transactionlist.size()==0)
			System.out.println("No Transactions to show");
		else
		{
			for(Transaction transaction : transactionlist)
			{
				System.out.println("Account number       : " + transaction.getAccountnumber());
				System.out.println("Transaction Type     : " + transaction.getTransactiontype());
				System.out.println("Transaction Amount   : " + transaction.getAmount());
				System.out.println("----------------------------------------------");
			}
		}
	}
	void deleteAccount() throws IOException
	{
		System.out.println("Enter the account number to Delete : ");
		Scanner sc=null;
		sc = new Scanner(System.in);
		long accountnumber = sc.nextLong();
		 
	     
		ListIterator<Customer> iter = customerlist.listIterator();
		while(iter.hasNext()){
		    if(iter.next().getAccountobj().getAccountnumber()== accountnumber)
		    {
		        iter.remove();
		    }
		}
		FileDataBase f = new FileDataBase();
		f.write(customerlist);
		
	//sc.close();	
	}
}