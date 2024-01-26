package com.winter.app.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winter.app.member.MemberDTO;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@PostMapping("add")
	public String setReply(ReplyDTO replyDTO, HttpSession session, Model model)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		replyDTO.setUserName(memberDTO.getUserName());
		
		int result = replyService.setReply(replyDTO);
		
		List<ReplyDTO> ar = replyService.getList(replyDTO);
		model.addAttribute("list", ar);
		return "product/replyListResult";
		
	}
	
	@GetMapping("list")
	public String getList(ReplyDTO replyDTO, Model model)throws Exception {
		List<ReplyDTO> ar = replyService.getList(replyDTO);
		model.addAttribute("list", ar);
		return "product/replyListResult";
	}
	
	
}
