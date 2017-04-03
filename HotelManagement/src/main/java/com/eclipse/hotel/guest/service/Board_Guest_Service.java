package com.eclipse.hotel.guest.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eclipse.hotel.guest.dao.Board_Guest_DAO;

@Service("board_guest_service")
public class Board_Guest_Service {

	@Resource(name="board_guest_dao")
	private Board_Guest_DAO board_guest_dao;

	//mapper
	private String namespace = "com.eclipse.hotel.guest.mapper.MyGuestboard";
}
