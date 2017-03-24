package com.eclipse.hotel.admin.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eclipse.hotel.admin.service.Membership_Service;
import com.eclipse.hotel.service.Management_Service;

import com.eclipse.hotel.vo.memberVO;
import com.eclipse.hotel.vo.room_reserveVO;

import com.eclipse.hotel.vo.room_infoVO;


@Controller

public class Membership_Controller {

	@Resource(name = "membership_service")
	private Membership_Service membership_service;
	

	//전체회원 보기
	@RequestMapping(value = "admin_membership_list", method = RequestMethod.GET)
	public String list(Model model){
		List<memberVO> memberList = membership_service.list();
		int memberCount = membership_service.count();
		int todayCount = membership_service.todayCount();
	
		model.addAttribute("memberList", memberList);
		model.addAttribute("memberCount", memberCount);
		model.addAttribute("todayCount", todayCount);
		
		return "management/membership/membership_list";
	}
	
	//회원 상세보기
	@RequestMapping(value = "admin_membership_detail", method = RequestMethod.GET)
	public String detail(int m_num, Model model){
		memberVO member = membership_service.detail(m_num);
		List<room_reserveVO> reserveList = membership_service.reserveList(m_num);
		List<room_reserveVO> pre_reserveList = membership_service.preReserveList(m_num);
		
		model.addAttribute("member", member);
		model.addAttribute("reserveList", reserveList);
		model.addAttribute("pre_reserveList", pre_reserveList);
		
		return "management/membership/membership_detail";
	}
	
	//회원 수정 페이지
	@RequestMapping(value = "admin_membership_update", method = RequestMethod.GET)
	public String updatePage(int m_num, Model model){
		memberVO member = membership_service.detail(m_num);
		
		model.addAttribute("member", member);
		
		return "management/membership/membership_update";
	}
		
}
