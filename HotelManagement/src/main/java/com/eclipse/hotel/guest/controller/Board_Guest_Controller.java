package com.eclipse.hotel.guest.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eclipse.hotel.guest.service.Board_Guest_Service;

@Controller
public class Board_Guest_Controller {
	@Resource(name="board_guest_service")
	private Board_Guest_Service board_guest_service;
	
	@RequestMapping("guestboardregister")
	private String guestboardregister(){
		return "guest/board/guestboardinsert";
	}
}
