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
	
	
	//회원 가입 페이지
	@RequestMapping(value = "memberRegister", method = RequestMethod.GET)
	public String memberRegister(){
		return "guest/member/member_register";
	}
	
	//회원가입
	@RequestMapping(value = "memberRegister", method = RequestMethod.POST)
	@ResponseBody
	public String memberRegister(memberVO member){
		member_service.memberRegister(member);
		
		return "SUCCESS";
	}
	
	//아이디 중복 확인
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
	
	//로그인 페이지
	@RequestMapping(value = "memberLogin", method = RequestMethod.GET)
	public String memberLogin(){
		return "guest/member/member_login";
	}
	
	//로그인
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
	
	//로그아웃
	@RequestMapping(value = "memberLogout", method = RequestMethod.GET)
	public String memberLogout(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:guestHome";
	}
		
	//마이 페이지
	@RequestMapping(value = "memberMypage", method = RequestMethod.GET)
	public String memberMypage(HttpServletRequest request, Model model){		
		int m_num = (Integer)request.getSession().getAttribute("loginNO");
		
		memberVO member = member_service.memberMypage(m_num);
		model.addAttribute("member", member);
		
		return "guest/member/member_mypage";
	}
	
	//회원 정보 수정
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String memberUpdate(memberVO member){	
		member_service.memberUpdate(member);
		
		return "SUCCESS";
	}

}
