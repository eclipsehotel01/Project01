package com.eclipse.hotel.admin.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.eclipse.hotel.vo.memberVO;
import com.eclipse.hotel.vo.room_reserveVO;

@Repository("membership_dao")
public class Membership_DAO {
	
	@Inject
	private SqlSession session;
	
	//mapper
	private String namespace = "com.eclipse.hotel.admin.mapper.MembershipMapper";
	
	//전체회원 보기
	public List<memberVO> list(){
		return session.selectList(namespace + ".membershipList");
	}
	
	//전체회원 수
	public int count(){
		return session.selectOne(namespace + ".membershipCount");
	}
	
	//오늘 가입 회원 수
	public int todayCount(){
		return session.selectOne(namespace + ".todayCount");
	}
	
	//회원 상세보기
	public memberVO detail(int m_num){
		return session.selectOne(namespace + ".membershipDetail", m_num);
	}
	
	//회원 상세보기 - 예약 정보(숙박 완료)
	public List<room_reserveVO> reserveList(int m_num){
		return session.selectList(namespace + ".membershipReserve", m_num);
	}
	
	//회원 상세보기 - 예약 정보(숙박 예정)
	public List<room_reserveVO> preReserveList(int m_num){
		return session.selectList(namespace + ".membershipPreReserve", m_num);
	}		
	
}
