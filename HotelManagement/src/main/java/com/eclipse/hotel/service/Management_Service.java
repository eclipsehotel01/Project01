package com.eclipse.hotel.service;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eclipse.hotel.dao.Management_DAO;

import com.eclipse.hotel.vo.memberVO;
import com.eclipse.hotel.vo.paymentVO;
import com.eclipse.hotel.vo.room_reserveVO;

import com.eclipse.hotel.vo.room_infoVO;
import com.eclipse.hotel.vo.room_priceVO;


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

	//갹실 전체보기
	public List<room_infoVO> roomList(String rname) {
		// TODO Auto-generated method stub
		return management_dao.roomList(rname);
	}

	//객실 상세보기
	public room_infoVO roomDetail(int rnum) {
		// TODO Auto-generated method stub
		return management_dao.roomDetail(rnum);
	}

	//객실요금표
	public List<room_priceVO> roomPrice() {
		// TODO Auto-generated method stub
		return management_dao.roomPrice();
	}

	//객실정보수정
	public void roomUpdate(room_infoVO vo) {
		// TODO Auto-generated method stub
		management_dao.roomUpdate(vo);
	}

	//객실삭제
	public void roomDelete(int rnum) {
		// TODO Auto-generated method stub
		management_dao.roomDelete(rnum);
	}

	//객실등록
	public void roomInsert(room_infoVO vo) {
		// TODO Auto-generated method stub
		management_dao.roomInsert(vo);
	}

	public void priceUpdate(room_priceVO vo) {
		// TODO Auto-generated method stub
		management_dao.priceUpdate(vo);
	}

	public List<paymentVO> payList(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return management_dao.payList(hm);
	}

	public int payCount(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return management_dao.payCount(hm);
	}

	public int payTotal(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return management_dao.payTotal(hm);
	} 
	

}
