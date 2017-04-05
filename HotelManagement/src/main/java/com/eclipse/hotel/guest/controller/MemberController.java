package com.eclipse.hotel.guest.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.eclipse.hotel.guest.service.MemberService;
import com.eclipse.hotel.vo.memberVO;

@Controller
public class MemberController {
	
	@Resource(name="member_service")
	public MemberService member_service;	
	
	
	//ȸ�� ���� ������
	@RequestMapping(value = "memberRegister", method = RequestMethod.GET)
	public String memberRegister(){
		return "guest/member/member_register";
	}
	
	//ȸ������
	@RequestMapping(value = "memberRegister", method = RequestMethod.POST)
	@ResponseBody
	public String memberRegister(memberVO member){
		member_service.memberRegister(member);
		
		return "SUCCESS";
	}
	
	//���̵� �ߺ� Ȯ��
	@RequestMapping(value = "memberIdCheck", method = RequestMethod.GET)
	@ResponseBody
	public String memberIdCheck(String id){		
		String result = "";
		String checkId = member_service.memberIdCheck(id);
		
		if(checkId == null){
			result = "true";
		}else {
			result = "false";
		}		
		
		return result;
	}
	
	//�α��� ������
	@RequestMapping(value = "memberLogin", method = RequestMethod.GET)
	public String memberLogin(){
		return "guest/member/member_login";
	}
	
	//�α���
	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	@ResponseBody
	public String memberLogin(memberVO member, HttpServletRequest request){		
		HttpSession session = request.getSession();
		String checkPw = "";
		String result = "";		
		
		checkPw = member_service.memberLogin(member);		
		
		if(checkPw == null){
			result = "id_false";
		}else if(!checkPw.equals(member.getPassword())){
			result = "pw_false";
		}else if(checkPw.equals(member.getPassword())){
			result = "true";
			int m_num = member_service.memberNo(member.getId());
			
			session.setAttribute("loginID", member.getId());	
			session.setAttribute("loginNO", m_num);
		}		
		return result;
	}
	
	//�α׾ƿ�
	@RequestMapping(value = "memberLogout", method = RequestMethod.GET)
	public String memberLogout(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:guestHome";
	}
		
	//���� ������
	@RequestMapping(value = "memberMypage", method = RequestMethod.GET)
	public String memberMypage(HttpServletRequest request, Model model){		
		int m_num = (Integer)request.getSession().getAttribute("loginNO");
		
		memberVO member = member_service.memberMypage(m_num);
		model.addAttribute("member", member);
		
		return "guest/member/member_mypage";
	}
	
	//ȸ�� ���� ����
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String memberUpdate(memberVO member){	
		member_service.memberUpdate(member);
		
		return "SUCCESS";
	}

}
