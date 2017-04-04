package com.eclipse.hotel.guest.dao;


import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;


import com.eclipse.hotel.vo.memberVO;
import com.eclipse.hotel.vo.paymentVO;
import com.eclipse.hotel.vo.room_reserveVO;

import com.eclipse.hotel.vo.room_infoVO;
import com.eclipse.hotel.vo.room_priceVO;


@Repository("room_dao")
public class Room_DAO {
	
	@Inject
	private SqlSession session;
	
	//mapper경로 
	private String namespace = "com.eclipse.hotel.guest.mapper.RoomMapper";

	//객실목록
	public List<room_infoVO> roomInfoList() {
		// TODO Auto-generated method stub
		return session.selectList("roomInfoList");
	}

	//객실 타이틀
	public List<room_infoVO> room_infoTitle(String rname) {
		// TODO Auto-generated method stub		
		return session.selectList("roomInfoTitle", rname);
	}

	public List<room_infoVO> room_infoDetail(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return session.selectList("roomInfoDetail", hm);
	}

}
