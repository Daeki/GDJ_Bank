package com.winter.app.wishlist;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winter.app.account.AccountDTO;
import com.winter.app.member.MemberDTO;
import com.winter.app.product.ProductDTO;

@Controller
@RequestMapping("/wishlist/*")
public class WishListController {

	@Autowired
	private WishListService wsListService;
	
	@PostMapping("delete")
	public String setDelete(Long [] productNum, HttpSession session, Model model)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		int result = wsListService.setDelete(productNum, memberDTO);
		
		//다시 조회
		List<ProductDTO> ar = wsListService.getList(memberDTO);
		
		//model.addAttribute("result", result);
		model.addAttribute("list", ar);
		
		return "wishlist/ajaxList";
	}
	
	@GetMapping("list")
	public void getList(HttpSession session, Model model)throws Exception{
		MemberDTO memberDTO =(MemberDTO)session.getAttribute("member");
		List<ProductDTO> ar = wsListService.getList(memberDTO);
		model.addAttribute("list", ar);
		
	}
	
	@GetMapping("add")
	public String setAdd(HttpSession session, AccountDTO accountDTO, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		accountDTO.setUserName(memberDTO.getUserName());
		int result = wsListService.setAdd(accountDTO);
		
		model.addAttribute("result",result);
		
		return "commons/ajaxResult";
	}
	
}
