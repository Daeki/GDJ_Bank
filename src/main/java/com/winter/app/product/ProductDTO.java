package com.winter.app.product;

import java.util.List;

public class ProductDTO {
	
	private Long productNum;
	private String productName;
	private String productContents;
	private Double productRate;
	private Double productJumsu;
	private List<ProductFileDTO> productFileDTOs;
	private List<ReplyDTO> replyDTOs;
	
	
	
	public List<ReplyDTO> getReplyDTOs() {
		return replyDTOs;
	}
	public void setReplyDTOs(List<ReplyDTO> replyDTOs) {
		this.replyDTOs = replyDTOs;
	}
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductContents() {
		return productContents;
	}
	public void setProductContents(String productContents) {
		this.productContents = productContents;
	}
	public Double getProductRate() {
		return productRate;
	}
	public void setProductRate(Double productRate) {
		this.productRate = productRate;
	}
	public Double getProductJumsu() {
		return productJumsu;
	}
	public void setProductJumsu(Double productJumsu) {
		this.productJumsu = productJumsu;
	}
	public List<ProductFileDTO> getProductFileDTOs() {
		return productFileDTOs;
	}
	public void setProductFileDTOs(List<ProductFileDTO> productFileDTOs) {
		this.productFileDTOs = productFileDTOs;
	}
	
	
}
