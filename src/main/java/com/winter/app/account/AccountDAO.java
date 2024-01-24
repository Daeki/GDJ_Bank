package com.winter.app.account;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.winter.app.account.AccountDAO.";

	
	public List<Object> getList(Map<String, Object> map)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", map);
				
	}
}
