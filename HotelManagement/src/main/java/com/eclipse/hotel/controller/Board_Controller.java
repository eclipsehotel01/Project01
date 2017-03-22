package com.eclipse.hotel.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.eclipse.hotel.service.Board_Service;

@Controller
public class Board_Controller {
	
	@Resource(name = "board_service")
	private Board_Service board_service;

}
