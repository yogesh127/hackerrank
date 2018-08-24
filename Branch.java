package bank;

import java.io.Serializable;




public class Branch implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int branchid;
	private String branchlocation;
	private String ifsc;
	
	public Branch(int branchid, String branchlocation, String ifsc) 
	{
		this.branchid = branchid;
		this.branchlocation = branchlocation;
		this.ifsc = ifsc;
	}

	public int getBranchid() 
	{
		return branchid;
	}

	public void setBranchid(int branchid) 
	{
		this.branchid = branchid;
	}

	public String getBranchlocation() 
	{
		return branchlocation;
	}

	public void setBranchlocation(String branchlocation)
	{
		this.branchlocation = branchlocation;
	}

	public String getIfsc() 
	{
		return ifsc;
	}

	public void setIfsc(String ifsc)
	{
		this.ifsc = ifsc;
	}
	
	
}