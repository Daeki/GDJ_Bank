package com.winter.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.util.Pager;

import oracle.security.o3logon.a;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productServices;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Pager pager, Model model) throws Exception {
		List<ProductDTO> ar = productServices.getList(pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);	
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getDetail(ProductDTO pD, ModelAndView mv) throws Exception {
		pD = productServices.getDetail(pD);
		System.out.println(pD.getProductFileDTOs());
		mv.addObject("detail", pD);
		mv.setViewName("product/detail");
		
		return mv;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void addProduct()throws Exception{
		
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addProduct(ProductDTO pD, MultipartFile[] attach, Model model) throws Exception {
		int result = productServices.addProduct(pD, attach);
		String msg="등록 실패";
		if(result>0) {
			msg="등록 성공";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("path","./list");
		
		return "commons/result";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView updateProduct(ProductDTO pD, ModelAndView mv) throws Exception {
		pD = productServices.getDetail(pD);
		mv.addObject("dto",pD);
		mv.setViewName("product/update");
		
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateProduct(ProductDTO pD, Model model) throws Exception {
		int result = productServices.updateProduct(pD);
		String msg="수정 실패";
		if(result>0) {
			msg="수정 성공";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("path","./list");
		
		return "commons/result";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public ModelAndView productDelete(ProductDTO pD, ModelAndView mv) throws Exception {
		int result = this.productServices.deleteProduct(pD);
		String msg = "삭제 실패";
		if(result>0) {
			msg = "삭제 성공";
		}
		mv.addObject("msg", msg);
		mv.addObject("path","./list");
		mv.setViewName("commons/result");
		
		return mv;
	}
}
