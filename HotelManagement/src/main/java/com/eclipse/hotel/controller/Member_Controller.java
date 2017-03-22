package com.eclipse.hotel.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.eclipse.hotel.service.Member_Service;

@Controller
public class Member_Controller {
	
	@Resource(name = "member_service")
	private Member_Service member_service;

}
