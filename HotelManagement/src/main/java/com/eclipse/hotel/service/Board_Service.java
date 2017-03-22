package com.eclipse.hotel.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eclipse.hotel.dao.Board_DAO;

@Service("board_service")
public class Board_Service {
	
	@Resource(name = "board_dao")
	private Board_DAO board_dao;

}
