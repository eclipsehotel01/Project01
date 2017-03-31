package com.eclipse.hotel.admin.service;

import java.util.HashMap;
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
	
	//ȸ�� ����Ʈ
	public List<memberVO> list(HashMap<String, Object> hm){
		return membership_dao.list(hm);
	}
	
	//ȸ�� ��
	public int count(HashMap<String, Object> hm){
		return membership_dao.count(hm);
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
	
	//ȸ�� ����
	public void update(memberVO member){
		membership_dao.update(member);
	}

	//ȸ�� ����
	public void delete(int m_num){
		membership_dao.delete(m_num);
	}
	

}
