package com.eclipse.hotel.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eclipse.hotel.admin.dao.Reserve_DAO;
import com.eclipse.hotel.vo.extra_chargeVO;
import com.eclipse.hotel.vo.memberVO;
import com.eclipse.hotel.vo.room_infoVO;
import com.eclipse.hotel.vo.room_reserveVO;

@Service("reserve_service")
public class Reserve_Service {
	
	@Resource(name = "reserve_dao")
	private Reserve_DAO reserve_dao;
	
	//예약 리스트
	public List<room_reserveVO> list(){
		return reserve_dao.list();
	}
	//선택한 예약정보
	public room_reserveVO selectlist(int reservecode)
	{
		return reserve_dao.selectlist(reservecode);
	}
	//선택한 예약멤버
	public List<memberVO>rmember(int m_num)
	{
		return reserve_dao.rmember(m_num);
	}
	//예약 삭제
	public void delreserve(String reservecode)
	{
		reserve_dao.delreserve(reservecode);
	}
	//예약 수정
	public void  update(room_reserveVO reserve)
	{
		 System.out.println("service update");
		 reserve_dao.update(reserve);
	}
	//예약된 호실타입
	public String searchtype(int rnum)
	{
		return reserve_dao.searchtype(rnum);
	}
	//예약된 호실의 시즌요금
	public int getpay(String paytype)
	{
		return reserve_dao.getpay(paytype);
	}
	//예약된 호실의 비시즌 요금
	public int getnonpay(String paytype)
	{
		return reserve_dao.getnonpay(paytype);
	}
	//예약된 호실의 기준인원
	public int standperson(int room)
	{
		return reserve_dao.standperson(room);
	}
	//방번호 리스트
	public List<room_infoVO> listRnum(){
		return reserve_dao.listRnum();
	}
	//추가 요금
	public int getExtraTotal(String string) {
		// TODO Auto-generated method stub
		return reserve_dao.getExtraTotal(string);
	}
	
	//호실정보
	public room_infoVO roomInfo(int rnum) {
		// TODO Auto-generated method stub
		return reserve_dao.roomInfo(rnum);
	}

}
