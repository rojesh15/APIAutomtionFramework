package com.api.models.requests;

public class AccountControllerRequest {
	
	private String accountType;
	private String branch;
	
	@Override
	public String toString() {
		return "AccountControllerRequest [accountType=" + accountType + ", branch=" + branch + "]";
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public AccountControllerRequest(String accountType, String branch) {
		super();
		this.accountType = accountType;
		this.branch = branch;
	}

	
}
