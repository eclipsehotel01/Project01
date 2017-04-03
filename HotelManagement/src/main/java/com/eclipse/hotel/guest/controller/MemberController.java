package com.eclipse.hotel.guest.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eclipse.hotel.guest.service.MemberService;

@Controller
public class MemberController {
	
	@Resource(name="guest_service")
	public MemberService guest_service;
	
	//회원 가입 페이지
	@RequestMapping(value = "guestRegister", method = RequestMethod.GET)
	public String guestRegister(){
		return "guest/member/member_register";
	}
	

}
