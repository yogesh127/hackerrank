package bank;
import java.awt.List;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class File {

	public void write(Customer c)
	{
		try
		{
		//	File file = new File("cdd");
			FileOutputStream f = new FileOutputStream("C:\\Users\\yogeshchaudhary\\Desktop\\target.ser",true);
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(c);
			o.close();
			f.close();
			ObjectInputStream o1 = new ObjectInputStream(new FileInputStream("C:\\Users\\yogeshchaudhary\\Desktop\\target.ser"));
			Customer c1 = (Customer) o1.readObject();
			System.out.println(c1.getCustomername());
			 c1 = (Customer) o1.readObject();
			 System.out.println(c1.getCustomername());
			
			

		}
		catch( Exception e)
		{
			System.out.println(e);
		}
		
		
	}
	public ArrayList<Customer> read() throws IOException, Exception
	{
		//ArrayList<Customer> customerlist = new ArrayList<Customer>();
		
		FileInputStream f2 = new FileInputStream("C:\\Users\\yogeshchaudhary\\Desktop\\target.ser");
		//ObjectInputStream o2 = new ObjectInputStream(f2);
		ArrayList<Customer> objectsList = new ArrayList<Customer>();
		boolean cont = true;
		 int count =0;
		try{
		   ObjectInputStream input = new ObjectInputStream(f2);
		   while(cont){
		       
		       if(f2.available()!=0)
		       {
		    	   Object obj = (Customer)input.readObject();
		    	   objectsList.add((Customer) obj);
		    	   count++;
		       }
		       else
		         cont = false;
		   }
		   for(Customer customer : objectsList)
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
			
			  //count++;
			}
		  System.out.println("The Number is " + count);
		   
		}catch(Exception e)
		{
		  
		  // System.out.println("Hello Dear");
		  
		}
		
		return objectsList;
		
		
	}
	}
