package com.winter.app.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.member.MemberDTO;
import com.winter.app.util.Pager;

@Service
public class AccountService {
	@Autowired
	private AccountDAO accountDAO;
	
	public List<Object> getList(Pager pager, MemberDTO memberDTO)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		pager.makeRow();
		map.put("pager", pager);
		map.put("memberDTO", memberDTO);
		
		return accountDAO.getList(map);
	}

}
