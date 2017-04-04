package com.eclipse.hotel.guest.service;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eclipse.hotel.guest.dao.Room_DAO;
import com.eclipse.hotel.vo.room_infoVO;


@Service("room_service")
public class Room_Service {

	@Resource(name = "room_dao")
	private Room_DAO room_dao;

	//∞¥Ω«∏Ò∑œ
	public List<room_infoVO> roomInfoList() {
		// TODO Auto-generated method stub
		return room_dao.roomInfoList();
	}

	//∞¥Ω« ≈∏¿Ã∆≤
	public List<room_infoVO> room_infoTitle(String rname) {
		// TODO Auto-generated method stub
		return room_dao.room_infoTitle(rname);
	}

	public List<room_infoVO> room_infoDetail(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return room_dao.room_infoDetail(hm);
	} 	

}
