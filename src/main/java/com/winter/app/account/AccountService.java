package com.winter.app.account;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.product.ProductDTO;
import com.winter.app.util.Pager;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	public int setAdd(AccountDTO accountDTO) throws Exception{
		
		Calendar cal = Calendar.getInstance();
		accountDTO.setAccountNum(cal.getTimeInMillis()+"");
		int result = accountDAO.setAdd(accountDTO);

		return result;
	}
	
	public List<ProductDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		Long totalCount=accountDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		List<ProductDTO> ar = accountDAO.getList(pager);
		return ar;
	}
	
	
	
}
