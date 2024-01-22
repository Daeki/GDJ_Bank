package com.winter.app.interceptors;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.winter.app.board.BoardDAO;
import com.winter.app.board.BoardDTO;
import com.winter.app.board.notice.NoticeDAO;
import com.winter.app.board.qna.QnaDAO;
import com.winter.app.member.MemberDTO;

@Component
public class WriterCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			// /qna/update, /notice/update
			String path = request.getRequestURI();
			path = path.substring(0, path.lastIndexOf("/"));
			
			//num 
			long n = Long.parseLong(request.getParameter("boardNum"));
			
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setBoardNum(n);
			
			if(path.equals("/qna")) {
				boardDTO= qnaDAO.getDetail(boardDTO);
			}else {
				boardDTO= noticeDAO.getDetail(boardDTO);
			}
			
			//
			MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
			
			if(boardDTO.getBoardWriter().equals(memberDTO.getUserName())) {
				return true;
			}else {
				request.setAttribute("path", "./list");
				request.setAttribute("msg", "작성자만 가능");
				RequestDispatcher v = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
				v.forward(request, response);
				return false;
			}		
	}
	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		
//		String method = request.getMethod();
//		
//		if(method.toUpperCase().equals("POST")) {
//			return;
//		}
//		
//		
//		Map<String, Object> map= modelAndView.getModel();
////		Iterator<String> it = map.keySet().iterator();
////		while(it.hasNext()) {
////			String k = it.next();
////			System.out.println(k);
////			System.out.println(map.get(k));
////		}
//		//작성자 정보
//		BoardDTO boardDTO  = (BoardDTO)map.get("boardDTO");
//		
//		
//		//로그인 정보
//		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
//		
//		//비교
//		if(!boardDTO.getBoardWriter().equals(memberDTO.getUserName())) {
//			modelAndView.addObject("path", "./list");
//			modelAndView.addObject("msg", "작성자만 가능");
//			modelAndView.setViewName("commons/result");
//		}
//		
//		
//		System.out.println(modelAndView.getViewName());
//		
//	}

}
