package com.eclipse.hotel.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eclipse.hotel.dao.Management_DAO;
import com.eclipse.hotel.vo.room_infoVO;

@Service("management_service")
public class Management_Service {

	@Resource(name = "management_dao")
	private Management_DAO management_dao;

	public List<room_infoVO> roomList(String rname) {
		// TODO Auto-generated method stub
		return management_dao.roomList(rname);
	}

	public room_infoVO roomDetail(int rnum) {
		// TODO Auto-generated method stub
		return management_dao.roomDetail(rnum);
	} 
	
}
