package com.winter.app.wishlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.account.AccountDTO;
import com.winter.app.member.MemberDTO;
import com.winter.app.product.ProductDTO;

@Service
public class WishListService {

	@Autowired
	private WishListDAO wsListDAO;
	
	public List<ProductDTO> getList(MemberDTO memberDTO)throws Exception{
		return wsListDAO.getList(memberDTO);
	}
	
	public int setAdd(AccountDTO accountDTO)throws Exception{
		return wsListDAO.setAdd(accountDTO);
	}
}
