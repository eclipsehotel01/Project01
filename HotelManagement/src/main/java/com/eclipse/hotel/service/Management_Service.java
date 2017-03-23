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
	
	//��üȸ�� ����
	public List<memberVO> membershipList(){
		return management_dao.membershipList();
	}
	
	//��üȸ�� ��
	public int membershipCount(){
		return management_dao.membershipCount();
	}
	
	//���� ���� ȸ�� ��
	public int todayMembershipCount(){
		return management_dao.todayMembershipCount();
	}
	
	//ȸ�� �󼼺��� 
	public memberVO membershipDetail(int m_num){
		return management_dao.membershipDetail(m_num);
	}
	
	//ȸ�� �󼼺��� - ���� ����(���� �Ϸ�)
	public List<room_reserveVO> membershipReserve(int m_num){
		return management_dao.membershipReserve(m_num);
	}
	
	//ȸ�� �󼼺��� - ���� ����(���� ����)
	public List<room_reserveVO> membershipPreReserve(int m_num){
		return management_dao.membershipPreReserve(m_num);
	}	

	//���� ��ü����
	public List<room_infoVO> roomList(String rname) {
		// TODO Auto-generated method stub
		return management_dao.roomList(rname);
	}

	//���� �󼼺���
	public room_infoVO roomDetail(int rnum) {
		// TODO Auto-generated method stub
		return management_dao.roomDetail(rnum);
	}

	//���ǿ��ǥ
	public List<room_priceVO> roomPrice() {
		// TODO Auto-generated method stub
		return management_dao.roomPrice();
	}

	//������������
	public void roomUpdate(room_infoVO vo) {
		// TODO Auto-generated method stub
		management_dao.roomUpdate(vo);
	}

	//���ǻ���
	public void roomDelete(int rnum) {
		// TODO Auto-generated method stub
		management_dao.roomDelete(rnum);
	}

	//���ǵ��
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
