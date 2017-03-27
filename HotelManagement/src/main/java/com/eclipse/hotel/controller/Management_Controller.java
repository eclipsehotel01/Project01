package com.eclipse.hotel.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.eclipse.hotel.service.Management_Service;


import java.util.List;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eclipse.hotel.vo.memberVO;
import com.eclipse.hotel.vo.room_reserveVO;

import com.eclipse.hotel.vo.room_infoVO;


@Controller

public class Management_Controller {

	@Resource(name = "management_service")
	private Management_Service management_service;	

	//전체회원 보기
	@RequestMapping(value = "admin_membership_list", method = RequestMethod.GET)
	public String membershipList(Model model){
		List<memberVO> memberList = management_service.membershipList();
		int memberCount = management_service.membershipCount();
		int todayCount = management_service.todayMembershipCount();
		
		model.addAttribute("memberList", memberList);
		model.addAttribute("memberCount", memberCount);
		model.addAttribute("todayCount", todayCount);
		
		return "management/membership/membership_list";
	}
	
	//회원 상세보기
	@RequestMapping(value = "admin_membership_detail", method = RequestMethod.GET)
	public String membershipDetail(int m_num, Model model){
		memberVO member = management_service.membershipDetail(m_num);
		List<room_reserveVO> reserveList = management_service.membershipReserve(m_num);
		List<room_reserveVO> pre_reserveList = management_service.membershipPreReserve(m_num);
		
		model.addAttribute("member", member);
		model.addAttribute("reserveList", reserveList);
		model.addAttribute("pre_reserveList", pre_reserveList);
		
		return "management/membership/membership_detail";
	}

	//객실목록
	@RequestMapping(value = "room_list")
	public String room_list(Model model, String rname){
		if(rname==null) rname ="";
		System.out.println("rname : " + rname);
		List<room_infoVO> infoList = management_service.roomList(rname);
		
		model.addAttribute("roomlist", infoList);
		return "management/reserve/room_management";
	}
	
	
	//객실정보수정
	@RequestMapping(value = "room_detail")
	public String room_detail(Model model, int rnum){
		room_infoVO infoDetail = management_service.roomDetail(rnum);
		
		model.addAttribute("infoDetail", infoDetail);
		return "management/reserve/room_detail";
	}
	
	//결제목록
	@RequestMapping(value = "pay_list")
	public String pay_list(){
		
		return "management/payment/pay_management";

	}
}
