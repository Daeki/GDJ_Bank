package com.winter.app.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.winter.app.member.MemberDAO.";
	
	
	public int setUpdate(MemberDTO memberDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", memberDTO);
	}
	
	public MemberDTO getDetail(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", memberDTO);
	}
	
	public int setJoin(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setJoin", memberDTO);
	}
	
	public int setAvatarAdd(AvatarDTO avatarDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAvatarAdd", avatarDTO);
	}
	

}
