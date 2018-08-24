package bank;


public class Savings extends Account
{
	private final double minbalance = 500;
	Savings(long accountnumber,double balance)
	{
		super(accountnumber,balance);
	}
	
	public double getMinbalance() {
		return minbalance;
	}
	
}