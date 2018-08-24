package bank;




public class Current extends Account 
{
	private final double minbalance = -10000;
	
	Current(long accountnumber,double balance)
	{
		super(accountnumber,balance);
	}
	
	public double getMinbalance() {
		return minbalance;
	}
	
}