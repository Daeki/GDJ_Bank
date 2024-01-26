package com.winter.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.winter.app.product.ReplyDAO.";
	
	public int setReply(ReplyDTO replyDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setReply", replyDTO);
	}
	
	public List<ReplyDTO> getList(ReplyDTO replyDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", replyDTO);
	}

}
