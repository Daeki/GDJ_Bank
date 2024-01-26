package com.winter.app.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
	@Autowired
	private ReplyDAO replyDAO;
	
	public int setReply(ReplyDTO replyDTO)throws Exception{
		return replyDAO.setReply(replyDTO);
	}

}
