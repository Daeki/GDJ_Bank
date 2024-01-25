package com.winter.app.account;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.board.BoardDTO;
import com.winter.app.product.ProductDTO;
import com.winter.app.util.Pager;

@Repository
public class AccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String nameSpace = "com.winter.app.account.AccountDAO.";
	
	public int setAdd(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(nameSpace+"setAdd", accountDTO);
	}
	
	public List<ProductDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(nameSpace+"getList", pager);
	}
	
	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(nameSpace+"getTotalCount", pager);
	}
}
