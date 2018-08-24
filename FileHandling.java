package bank;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

class FileHandle
{
	
	public void FileWriter(Customer c) throws IOException
	{
		Customer customer=c;
		FileWriter fw=null;
		BufferedWriter bw = null;
		String s=customer.accountobj.getAccountnumber()+"\t"+customer.getAadharnumber()+"\t"+customer.getPannumber()+"\t"+customer.getCustomername()+"\t"+customer.accountobj.getBalance();
		try
		{
			
				fw= new FileWriter("C:/Users/yogeshc4/workspace/bank.txt", true);
				bw = new BufferedWriter(fw);
				bw.write(s);
				bw.newLine();
				
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		finally
		{
			bw.close();
		}
		
		
	}

	
	
	public void FileReader()
	{
		
		FileReader fr=null;
		BufferedReader br = null;
		try
		{
			
				System.out.println("Hi");
				fr=new FileReader("C:/Users/yogeshc4/workspace/bank.txt");
				br = new BufferedReader(fr);
				String line = " ";
				while ((line = br.readLine()) != null)
				{
				   // String[] words = line.split(" ");
				    System.out.println(line);
				   /* if(line.contains("Yogesh"))
				    {
				    	String Pqr = line;
				    	System.out.println(Pqr);
				    	String[] sp = Pqr.split("\t");
				        System.out.println("second word is " + sp[1]);
				      //  System.out.println("third word is " + sp[2]);
				       // System.out.println("Fourth words is " +sp[3]);
				    }
				    */
				}
				
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		finally
		{
			
		}
		
	}
public String detail(long accountNo) throws IOException
{
	String detail = null;
	FileReader fr=null;
	BufferedReader br = null;
	try
	{
		
			System.out.println("Hi");
			fr=new FileReader("C:/Users/yogeshc4/workspace/bank.txt");
			br = new BufferedReader(fr);
			String line = " ";
			String account=Integer.toString((int) accountNo);
			while ((line = br.readLine()) != null)
			{
			   // String[] words = line.split(" ");
			 //   System.out.println(line);
			    if(line.contains(account))
			    {
			    //	String Pqr = line;
			    	//System.out.println(Pqr);
			    //	String[] sp = Pqr.split("\t");
			       // System.out.println("second word is " + sp[1]);
			      //  System.out.println("third word is " + sp[2]);
			      // System.out.println("Fourth words is " +sp[3]);
			    //	return Float.parseFloat(sp[3]);
			    	return line;
			    }
			    
			}
			
		
	}
	catch(Exception e)
	{
		System.out.println(e);
		
	}
	finally
	{
		br.close();
	}
	return detail;
	
	
}
public void modify(long accountNo,float balance) throws IOException
{
	String detail = detail(accountNo);
	String[] sp = detail.split("\t");
	String newString=sp[0]+"\t"+sp[1]+"\t"+sp[2]+"\t"+balance;
	System.out.println(newString);
	/*List<String> fileContent = new ArrayList<>(Files.readAllLines("C:/Users/yogesh chaudhary/workspace/Test/abc.txt", StandardCharsets.UTF_8));

	for (int i = 0; i < fileContent.size(); i++) {
	    if (fileContent.get(i).equals(detail)) {
	        fileContent.set(i, newString);
	        break;
	    }
	}

	Files.write("C:/Users/yogesh chaudhary/workspace/Test/abc.txt", fileContent, StandardCharsets.UTF_8);
	*/
	RandomAccessFile file = new RandomAccessFile("C:/Users/yogeshc4/workspace/bank.txt", "rw");
	String line = " ";
	long offset = 0;
	while ((line = file.readLine()) != null)
	{
	   // String[] words = line.split(" ");
	 //   System.out.println(line);
	    if(line.equals(detail))
	    {
	    	System.out.println("Haha");
	    	file.seek(offset);
	    	file.writeBytes(newString);
	    	break;
	    }
	    offset = file.getFilePointer();
	}



}
public float balanceCheck(long accountNo) throws IOException 
{
	
	String detail = detail(accountNo);
	String[] sp = detail.split("\t");
	return Float.parseFloat(sp[3]);
	
	
}

}
