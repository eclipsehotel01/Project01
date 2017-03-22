package com.eclipse.hotel.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.eclipse.hotel.vo.room_infoVO;

@Repository("management_dao")
public class Management_DAO {
	
	@Inject
	private SqlSession session;
	
	private String namespace = "com.eclipse.hotel.mapper.ManagementMapper";

	public List<room_infoVO> roomList(String rname) {
		// TODO Auto-generated method stub
		return session.selectList("roomlist", rname);
	}

	public room_infoVO roomDetail(int rnum) {
		// TODO Auto-generated method stub
		return session.selectOne("roomdetail", rnum);
	}

}
