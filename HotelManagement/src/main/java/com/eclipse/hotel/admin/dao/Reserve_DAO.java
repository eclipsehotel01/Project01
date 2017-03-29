package com.eclipse.hotel.admin.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.eclipse.hotel.vo.extra_chargeVO;
import com.eclipse.hotel.vo.memberVO;
import com.eclipse.hotel.vo.room_infoVO;
import com.eclipse.hotel.vo.room_reserveVO;

@Repository("reserve_dao")
public class Reserve_DAO {
	
	@Inject
	private SqlSession session;
	
	//mapper경로 
	private String namespace = "com.eclipse.hotel.admin.mapper.ReserveMapper";
	
	//예약 리스트
	public List<room_reserveVO> list(){
		return session.selectList(namespace + ".reserveList");
	}
	//클릭된 예약
	public room_reserveVO selectlist(int reservecode)
	{
		return session.selectOne(namespace+".selectlist",reservecode);
	}
	//클릭된 멤버
	public List<memberVO>rmember(int m_num)
	{
		return session.selectList(namespace+".rmember",m_num);
	}
	//예약 삭제
	public void delreserve(String reservecode)
	{
		session.delete(namespace+".delreserve",reservecode);
	}
	//예약 수정
	public void update(room_reserveVO reserve)
	{ 
		
		session.update(namespace+".update",reserve);
		System.out.println("dao :"+reserve.getP_price());
	}
	//예약된 호실
	public String searchtype(int rnum)
	{
		return session.selectOne(namespace+".searchtype",rnum);
	}
	//예약된 호실의 시즌요금
	public int getpay(String paytype)
	{
		return session.selectOne(namespace+".getpay",paytype);
	}
	//예약된 호실의 비시즌 요금
	public int getnonpay(String paytype)
	{
		return session.selectOne(namespace+".getnonpay",paytype);
	}
	//예약된 호실의 기준 인원
	public int standperson(int room)
	{
		return session.selectOne(namespace+".standperson",room);
	}
	//방번호 리스트
	public List<room_infoVO> listRnum(){
		return session.selectList(namespace + ".rnumList");
	}
	//추가요금
	public int getExtraTotal(String string) {
		// TODO Auto-generated method stub
		System.out.println("dao"+string);
		return session.selectOne(namespace + ".getextracharge", string);
		
	}
	public room_infoVO roomInfo(int rnum) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".roomInfo", rnum);
	}

}
