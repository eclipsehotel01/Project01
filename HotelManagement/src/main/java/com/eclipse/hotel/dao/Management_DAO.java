package com.eclipse.hotel.dao;


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

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


@Repository("management_dao")
public class Management_DAO {
	
	@Inject
	private SqlSession session;
	
	//mapper경로 
	private String namespace = "com.eclipse.hotel.mapper.ManagementMapper";
	
	//전체회원 보기
	public List<memberVO> membershipList(){
		return session.selectList(namespace + ".membershipList");
	}
	
	//전체회원 수
	public int membershipCount(){
		return session.selectOne(namespace + ".membershipCount");
	}
	
	//오늘 가입 회원 수
	public int todayMembershipCount(){
		return session.selectOne(namespace + ".todayCount");
	}
	
	//회원 상세보기
	public memberVO membershipDetail(int m_num){
		return session.selectOne(namespace + ".membershipDetail", m_num);
	}
	
	//회원 상세보기 - 예약 정보(숙박 완료)
	public List<room_reserveVO>membershipReserve(int m_num){
		return session.selectList(namespace + ".membershipReserve", m_num);
	}
	
	//회원 상세보기 - 예약 정보(숙박 예정)
	public List<room_reserveVO> membershipPreReserve(int m_num){
		return session.selectList(namespace + ".membershipPreReserve", m_num);
	}	

	//객실 전체보기
	public List<room_infoVO> roomList(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		
		return session.selectList("roomlist", hm);
	}
	
	//객실수
	public int getRoomCount(String rname) {
		// TODO Auto-generated method stub
		return session.selectOne("roomcount", rname);
	}

	//객실 상세보기
	public room_infoVO roomDetail(int rnum) {
		// TODO Auto-generated method stub
		return session.selectOne("roomdetail", rnum);
	}

	//객실요금표
	public List<room_priceVO> roomPrice() {
		// TODO Auto-generated method stub
		return session.selectList("roomprice");
	}

	//객실수정
	public void roomUpdate(room_infoVO vo) {
		// TODO Auto-generated method stub
		session.update("roomupdate", vo);
	}

	//객실삭제
	public void roomDelete(int rnum) {
		// TODO Auto-generated method stub
		session.delete("roomdelete", rnum);
	}

	//객실등록
	public void roomInsert(room_infoVO vo) {
		// TODO Auto-generated method stub
		session.insert("roominsert", vo);
	}

	//객실요금수정
	public void priceUpdate(room_priceVO vo) {
		// TODO Auto-generated method stub
		session.update("priceupdate", vo);
	}

	//결제목록
	public List<paymentVO> payList(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return session.selectList("paylist", hm);
	}

	//결제건수
	public int payCount(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return session.selectOne("paycount", hm);
	}

	//결제총액
	public int payTotal(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return session.selectOne("paytotal", hm);
	}

	//결제취소
	public void payCancel(int p_num) {
		// TODO Auto-generated method stub
		session.update("paycancel", p_num);
	}

	//결제 취소여부 확인
	public int cancelCheck(int pnum) {
		// TODO Auto-generated method stub
		return session.selectOne("cancelcheck", pnum);
	}	
	
	
}
