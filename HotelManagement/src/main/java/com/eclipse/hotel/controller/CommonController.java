package com.eclipse.hotel.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eclipse.hotel.service.CommonService;
import com.eclipse.hotel.vo.zipcodeVO;

@Controller
public class CommonController {

	@Resource(name = "common_service")
	private CommonService common_service;
	
	//관리자 홈페이지 이동
	@RequestMapping(value = "adminHome")
	public String adminHome(){
		return "management/reserve/room_reserve_calendar";
	}
	
	//사용자홈페이지
	@RequestMapping(value = "guestHome", method = RequestMethod.GET)
	public String memberHome(){
		return "guest/main/home";
	}
	
	//우편번호 페이지
	@RequestMapping(value = "common_zipcode", method = RequestMethod.GET)
	public String zipcodePage(){	
		
		return "common/zipcodeCheck";
	}	
	//우편번호 검색
	@RequestMapping(value = "common_zipcode", method = RequestMethod.POST)
	public String zipcode(String dong, Model model){		
		List<zipcodeVO> zipcodeList = common_service.zipcode(dong);
		model.addAttribute("zipcodeList", zipcodeList);	
		System.out.println(zipcodeList.size());
		return "";
	}
}
