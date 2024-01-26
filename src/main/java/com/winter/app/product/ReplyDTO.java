package com.winter.app.product;

import java.sql.Date;

public class ReplyDTO {
	
	private Long replyNum;
	private Long productNum;
	private String userName;
	private String replyContents;
	private Date replyDate;
	private Integer replyJumsu;
	
	
	public Long getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(Long replyNum) {
		this.replyNum = replyNum;
	}
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getReplyContents() {
		return replyContents;
	}
	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public Integer getReplyJumsu() {
		return replyJumsu;
	}
	public void setReplyJumsu(Integer replyJumsu) {
		this.replyJumsu = replyJumsu;
	}
	
	

}
