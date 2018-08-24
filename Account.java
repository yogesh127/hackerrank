package bank;

import java.io.Serializable;


public class Account implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long accountnumber;
	double balance;
	public Account(long accountnumber, double balance)
	{
		this.accountnumber = accountnumber;
		this.balance = balance;
	}
	
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}