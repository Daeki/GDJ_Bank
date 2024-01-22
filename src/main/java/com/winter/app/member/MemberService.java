package com.winter.app.member;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.FileManager;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private ServletContext servletContext;
	
	public MemberDTO getDetail(MemberDTO memberDTO)throws Exception{
		return memberDAO.getDetail(memberDTO);
	}
	
	public int setUpdate(MemberDTO memberDTO)throws Exception{
		return memberDAO.setUpdate(memberDTO);
	}
	
	public MemberDTO getLogin(MemberDTO memberDTO)throws Exception{
		MemberDTO m = memberDAO.getDetail(memberDTO);
		
		if(m != null) {
			if(m.getPassword().equals(memberDTO.getPassword())) {
				return memberDTO;
			}else {
				m=null;
				//return null;
			}
		}
		
		return m;
		
	}
	
	public int setJoin (MemberDTO memberDTO, MultipartFile avatar)throws Exception{
		int result=0;
		result = memberDAO.setJoin(memberDTO);

		if(avatar.isEmpty()) {
			return result;
		}
		String path = servletContext.getRealPath("/resources/upload/member");
		
		String fileName = fileManager.fileSave(path, avatar);
		
		AvatarDTO avatarDTO = new AvatarDTO();
		avatarDTO.setFileName(fileName);
		avatarDTO.setOriName(avatar.getOriginalFilename());
		avatarDTO.setUserName(memberDTO.getUserName());
		
		result = memberDAO.setAvatarAdd(avatarDTO);
		
		
		
		return result;
	}

}
