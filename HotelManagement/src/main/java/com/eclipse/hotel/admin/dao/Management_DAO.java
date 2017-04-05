package com.eclipse.hotel.admin.dao;


import java.util.List;
import java.util.Map;

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
import com.eclipse.hotel.vo.room_memoVO;
import com.eclipse.hotel.vo.room_priceVO;


@Repository("management_dao")
public class Management_DAO {
	
	@Inject
	private SqlSession session;
	
	//mapper경로 
	private String namespace = "com.eclipse.hotel.admin.mapper.ManagementMapper";
	
/*	public int insertFile(Map<String, Object> map) throws Exception{
		
		return session.insert("sample.insertFile", map);
	}*/

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
	public void roomInsert(Map<String, Object>map) {
		// TODO Auto-generated method stub
		session.insert("roominsert", map);
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
	public int cancelCheck(int p_num) {
		// TODO Auto-generated method stub
		return session.selectOne("cancelcheck", p_num);
	}	
	
	//객실 타입 목록
	public List<room_memoVO> typelist() {
		// TODO Auto-generated method stub
		return session.selectList("typelist");
	}

	//객실 타입 설명 수정
	public void rtype_update(room_memoVO memo) {
		// TODO Auto-generated method stub
		session.selectList("rtypeupdate", memo);
	}	
}
