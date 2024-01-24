package com.winter.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("idCheck")
	public String getIdCheck(MemberDTO memberDTO, Model model)throws Exception{
		memberDTO = memberService.getDetail(memberDTO);
		
		int result=0;
		if(memberDTO == null) {
			result=1;
		}
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	@PostMapping("update")
	public String setUpdate(MemberDTO memberDTO, HttpSession session)throws Exception{
		//DB에 업데이트 후 myPage로 이동..
		MemberDTO m = (MemberDTO)session.getAttribute("member");
		
		memberDTO.setUserName(m.getUserName());
		
		int result = memberService.setUpdate(memberDTO);
		
		
		
		return "redirect:./mypage";
	}
	
	@GetMapping("update")
	public void setUpdate(HttpSession session, Model model)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO = memberService.getDetail(memberDTO);
		model.addAttribute("member", memberDTO);
	}
	
	@GetMapping("mypage")
	public void getMypage(HttpSession session, Model model)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO=memberService.getDetail(memberDTO);
		
		model.addAttribute("member", memberDTO);
		
	}
	
	@GetMapping("logout")
	public String getLogout(HttpSession session)throws Exception{
//		session.setAttribute("member", null);
//		session.removeAttribute("member");
//		session.removeValue("member");
		session.invalidate();
		return "redirect:../";
	}
	
	@GetMapping("login")
	public void getLogin()throws Exception{}
	
	@PostMapping("login")
	public String getLogin(MemberDTO memberDTO, HttpSession session, Model model)throws Exception{
		memberDTO = memberService.getLogin(memberDTO);
		//request.getSession()
		if(memberDTO == null) {
			model.addAttribute("msg", "ID 또는 PW 확인");
			return "member/login";
		}
		
		session.setAttribute("member", memberDTO);
		
		return "redirect:../";
		
	}
	
	@GetMapping("agreement")
	public void setAgreement()throws Exception{}
	
	
	@GetMapping("join")
	public void setJoin()throws Exception{
		
	}
	@PostMapping("join")
	public String setJoin(MemberDTO memberDTO, MultipartFile avatar, Model model)throws Exception{
		int result = memberService.setJoin(memberDTO, avatar);
		
		String msg ="회원 가입 실패";
		String path ="./join";
		if(result>0) {
			msg="회원 가입 성공";
			path="../";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("path", path);
		
		return "commons/result";
	}

}
