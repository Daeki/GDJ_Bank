package com.winter.app.account;

import java.sql.Date;

public class AccountDTO{

	private String accountNum;
	private String userName;
	private Long productNum;
	private Integer accountPw;
	private Date accountDate;
	private	Long accountBalance;
	
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public Integer getAccountPw() {
		return accountPw;
	}
	public void setAccountPw(Integer accountPw) {
		this.accountPw = accountPw;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	public Long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "AccountDTO [accountNum=" + accountNum + ", userName=" + userName + ", productNum=" + productNum
				+ ", accountPw=" + accountPw + ", accountDate=" + accountDate + ", accountBalance=" + accountBalance
				+ "]";
	}
	
	
}
