package com.eclipse.hotel.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eclipse.hotel.admin.dao.Membership_DAO;
import com.eclipse.hotel.vo.memberVO;
import com.eclipse.hotel.vo.room_reserveVO;

@Service("membership_service")
public class Membership_Service {

	@Resource(name = "membership_dao")
	private Membership_DAO membership_dao; 
	
	//전체회원 보기
	public List<memberVO> list(){
		return membership_dao.list();
	}
	
	//전체회원 수
	public int count(){
		return membership_dao.count();
	}
	
	//오늘 가입 회원 수
	public int todayCount(){
		return membership_dao.todayCount();
	}
	
	//회원 상세보기
	public memberVO detail(int m_num){
		return membership_dao.detail(m_num);
	}
	
	//회원 상세보기 - 예약 정보(숙박 완료)
	public List<room_reserveVO> reserveList(int m_num){
		return membership_dao.reserveList(m_num);
	}
	
	//회원 상세보기 - 예약 정보(숙박 예정)
	public List<room_reserveVO> preReserveList(int m_num){
		return membership_dao.preReserveList(m_num);
	}	

	

}
