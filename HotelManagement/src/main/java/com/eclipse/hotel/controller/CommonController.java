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
	
	//������ Ȩ������ �̵�
	@RequestMapping(value = "adminHome")
	public String adminHome(){
		return "management/reserve/room_reserve_calendar";
	}
	
	//�����Ȩ������
	@RequestMapping(value = "guestHome", method = RequestMethod.GET)
	public String memberHome(){
		return "guest/main/home";
	}
	
	//�����ȣ ������
	@RequestMapping(value = "common_zipcode", method = RequestMethod.GET)
	public String zipcodePage(){	
		
		return "common/zipcodeCheck";
	}	
	//�����ȣ �˻�
	@RequestMapping(value = "common_zipcode", method = RequestMethod.POST)
	public String zipcode(String dong, Model model){		
		List<zipcodeVO> zipcodeList = common_service.zipcode(dong);
		model.addAttribute("zipcodeList", zipcodeList);	
		System.out.println(zipcodeList.size());
		return "";
	}
}
