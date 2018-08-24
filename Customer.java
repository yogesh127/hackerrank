package bank;

import java.io.Serializable;


public class Customer implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String customername;
	private String customeraddress;
	private String pannumber;
	private String aadharnumber;
	private String phonenumber;
	Branch branchobj;
	Account accountobj;
	public Customer(String customername, String customeraddress, String pannumber, String aadharnumber,
					String phonenumber, Branch branchobj, Account accountobj) 
	{
		this.customername = customername;
		this.customeraddress = customeraddress;
		this.pannumber = pannumber;
		this.aadharnumber = aadharnumber;
		this.phonenumber = phonenumber;
		this.branchobj = branchobj;
		this.accountobj = accountobj;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomeraddress() {
		return customeraddress;
	}
	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}
	public String getPannumber() {
		return pannumber;
	}
	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}
	public String getAadharnumber() {
		return aadharnumber;
	}
	public void setAadharnumber(String aadharnumber) {
		this.aadharnumber = aadharnumber;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Branch getBranchobj() {
		return branchobj;
	}
	public void setBranchobj(Branch branchobj) {
		this.branchobj = branchobj;
	}
	public Account getAccountobj() {
		return accountobj;
	}
	public void setAccountobj(Account accountobj) {
		this.accountobj = accountobj;
	}
	
	
}