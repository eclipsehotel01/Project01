package com.eclipse.hotel.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eclipse.hotel.admin.dao.Reserve_DAO;
import com.eclipse.hotel.vo.room_reserveVO;

@Service("reserve_service")
public class Reserve_Service {
	
	@Resource(name = "reserve_dao")
	private Reserve_DAO reserve_dao;
	
	//���� ����Ʈ
	public List<room_reserveVO> list(){
		return reserve_dao.list();
	}

}
