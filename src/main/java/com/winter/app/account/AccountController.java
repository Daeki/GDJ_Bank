package com.winter.app.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.member.MemberDTO;
import com.winter.app.product.ProductDTO;
import com.winter.app.product.ProductService;
import com.winter.app.util.Pager;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("add")
	public ModelAndView setAdd(ProductDTO pD, ModelAndView mv) throws Exception {
		pD = productService.getDetail(pD);
		mv.addObject("detail", pD);
		mv.setViewName("account/add");

		return mv;
	}
	
	@PostMapping("add")
	public String setAdd(AccountDTO accountDTO, HttpSession session, Model model) throws Exception {
		MemberDTO ac = (MemberDTO)session.getAttribute("member");
		accountDTO.setUserName(ac.getUserName());
		int result = accountService.setAdd(accountDTO);
		
		String msg="계좌생성 실패";
		if(result>0) {
			msg="계좌생성 성공";
		}
		
		model.addAttribute("msg",msg);
		model.addAttribute("path","../product/list");
		
		return "commons/result";
	}
	
	@GetMapping("list")
	public void getList(ProductDTO productDTO, Pager pager, HttpSession session, Model model) throws Exception {
		MemberDTO ac = (MemberDTO)session.getAttribute("member");
		pager.setSearch(ac.getUserName());
		List<ProductDTO> ar = accountService.getList(pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
	}
}
