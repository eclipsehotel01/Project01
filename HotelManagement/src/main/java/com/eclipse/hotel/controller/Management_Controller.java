package com.eclipse.hotel.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.eclipse.hotel.service.Management_Service;

@Controller
public class Management_Controller {

	@Resource(name = "management_service")
	private Management_Service management_service;
}
