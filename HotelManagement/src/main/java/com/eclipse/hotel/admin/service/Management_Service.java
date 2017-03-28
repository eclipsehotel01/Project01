package com.eclipse.hotel.admin.service;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eclipse.hotel.admin.dao.Management_DAO;
import com.eclipse.hotel.vo.memberVO;
import com.eclipse.hotel.vo.paymentVO;
import com.eclipse.hotel.vo.room_reserveVO;

import com.eclipse.hotel.vo.room_infoVO;
import com.eclipse.hotel.vo.room_priceVO;


@Service("management_service")
public class Management_Service {

	@Resource(name = "management_dao")
	private Management_DAO management_dao; 	

	//객실 전체보기
	public List<room_infoVO> roomList(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return management_dao.roomList(hm);
	}
	
	//객실 수
	public int getRoomCount(String rname) {
		// TODO Auto-generated method stub
		return management_dao.getRoomCount(rname);
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

	//객실요금수정
	public void priceUpdate(room_priceVO vo) {
		// TODO Auto-generated method stub
		management_dao.priceUpdate(vo);
	}

	//결제목록
	public List<paymentVO> payList(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return management_dao.payList(hm);
	}

	//결제건수
	public int payCount(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return management_dao.payCount(hm);
	}

	//결제총액
	public int payTotal(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return management_dao.payTotal(hm);
	}

	//결제취소
	public void payCancel(int p_num) {
		// TODO Auto-generated method stub
		management_dao.payCancel(p_num);
	}

	//결제 취소여부 확인
	public int cancelCheck(int pnum) {
		// TODO Auto-generated method stub
		return management_dao.cancelCheck(pnum);
	}	

}
