package com.eclipse.hotel.admin.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.eclipse.hotel.vo.room_reserveVO;

@Repository("reserve_dao")
public class Reserve_DAO {
	
	@Inject
	private SqlSession session;
	
	//mapper��� 
	private String namespace = "com.eclipse.hotel.admin.mapper.ReserveMapper";
	
	//���� ����Ʈ
	public List<room_reserveVO> list(){
		return session.selectList(namespace + ".reserveList");
	}
	

}
