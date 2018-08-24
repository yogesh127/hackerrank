package bank;

import java.io.FileInputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
class FirstTimeUse extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FirstTimeUse()
	{
		
		
	}
	public String toString()
	{
		return "WelCome To My New Software \n";
	}

}
public class FileDataBase {
	
	public void write(ArrayList<Customer> database) throws IOException
	{
		FileOutputStream f=null;
		ObjectOutputStream o =null;
		try
		{
			
			
			 f = new FileOutputStream("C:\\Users\\yogeshc4\\Desktop\\database.ser");
			 o = new ObjectOutputStream(f);
			o.writeObject(database);
			o.close();
			f.close();
			
		}
		catch( Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			o.close();
			f.close();	
			
		}
		
		
	}
	public ArrayList<Customer> read() throws IOException
	{
		
		ArrayList<Customer> objectsList = new ArrayList<Customer>();
		try
        {
			File file = new File("C:\\Users\\yogeshc4\\Desktop\\database.ser");
			
			if(file.exists())
			{
				FileInputStream f2 = new FileInputStream("C:\\Users\\yogeshc4\\Desktop\\database.ser");
				ObjectInputStream input=null;
				try{
				    input = new ObjectInputStream(f2);
				   
				    	   objectsList = (ArrayList<Customer>) input.readObject();
				    	   
				    /*	   for(Customer customer :  objectsList)
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
				   		}		   
				*/
				}
				catch(Exception e)
				{
				  
				 
				  System.out.println(e);
				}
				finally
				{
					input.close();
				}
			} 
			else
			{
				throw new FirstTimeUse();
			}
            
        }
        catch (FirstTimeUse ex)
        {
            System.out.println(ex);
 
           
        }
		
		
		
		return objectsList;
		
		
	}

}
