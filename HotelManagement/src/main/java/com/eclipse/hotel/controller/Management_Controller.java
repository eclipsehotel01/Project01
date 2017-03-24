package com.eclipse.hotel.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eclipse.hotel.service.Management_Service;

import com.eclipse.hotel.vo.memberVO;
import com.eclipse.hotel.vo.room_reserveVO;

import com.eclipse.hotel.vo.room_infoVO;


@Controller

public class Management_Controller {

	@Resource(name = "management_service")
	private Management_Service management_service;
	
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
