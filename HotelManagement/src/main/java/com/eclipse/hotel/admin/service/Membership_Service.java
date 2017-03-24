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
	
	//��üȸ�� ����
	public List<memberVO> list(){
		return membership_dao.list();
	}
	
	//��üȸ�� ��
	public int count(){
		return membership_dao.count();
	}
	
	//���� ���� ȸ�� ��
	public int todayCount(){
		return membership_dao.todayCount();
	}
	
	//ȸ�� �󼼺���
	public memberVO detail(int m_num){
		return membership_dao.detail(m_num);
	}
	
	//ȸ�� �󼼺��� - ���� ����(���� �Ϸ�)
	public List<room_reserveVO> reserveList(int m_num){
		return membership_dao.reserveList(m_num);
	}
	
	//ȸ�� �󼼺��� - ���� ����(���� ����)
	public List<room_reserveVO> preReserveList(int m_num){
		return membership_dao.preReserveList(m_num);
	}	

	

}
