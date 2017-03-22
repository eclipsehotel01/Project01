package com.eclipse.hotel.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eclipse.hotel.dao.Management_DAO;
import com.eclipse.hotel.vo.memberVO;
import com.eclipse.hotel.vo.room_reserveVO;

@Service("management_service")
public class Management_Service {

	@Resource(name = "management_dao")
	private Management_DAO management_dao; 
	
	//전체회원 보기
	public List<memberVO> membershipList(){
		return management_dao.membershipList();
	}
	
	//전체회원 수
	public int membershipCount(){
		return management_dao.membershipCount();
	}
	
	//오늘 가입 회원 수
	public int todayMembershipCount(){
		return management_dao.todayMembershipCount();
	}
	
	//회원 상세보기 
	public memberVO membershipDetail(int m_num){
		return management_dao.membershipDetail(m_num);
	}
	
	//회원 상세보기 - 예약 정보(숙박 완료)
	public List<room_reserveVO> membershipReserve(int m_num){
		return management_dao.membershipReserve(m_num);
	}
	
	//회원 상세보기 - 예약 정보(숙박 예정)
	public List<room_reserveVO> membershipPreReserve(int m_num){
		return management_dao.membershipPreReserve(m_num);
	}
}
