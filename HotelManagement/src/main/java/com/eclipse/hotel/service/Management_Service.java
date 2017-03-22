package com.eclipse.hotel.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eclipse.hotel.dao.Management_DAO;
import com.eclipse.hotel.vo.memberVO;
import com.eclipse.hotel.vo.room_reserveVO;

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
}
