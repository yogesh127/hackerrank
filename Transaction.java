package bank;


public class Transaction 
{
	private long accountnumber;
	private double amount;
	private String transactiontype;
	
	public Transaction(long accountnumber, double amount, String transactiontype) 
	{
		super();
		this.accountnumber = accountnumber;
		this.amount = amount;
		this.transactiontype = transactiontype;
	}

	public long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	
	
}