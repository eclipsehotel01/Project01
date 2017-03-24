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
	
	//��üȸ�� ����
	public List<memberVO> list(){
		return session.selectList(namespace + ".membershipList");
	}
	
	//��üȸ�� ��
	public int count(){
		return session.selectOne(namespace + ".membershipCount");
	}
	
	//���� ���� ȸ�� ��
	public int todayCount(){
		return session.selectOne(namespace + ".todayCount");
	}
	
	//ȸ�� �󼼺���
	public memberVO detail(int m_num){
		return session.selectOne(namespace + ".membershipDetail", m_num);
	}
	
	//ȸ�� �󼼺��� - ���� ����(���� �Ϸ�)
	public List<room_reserveVO> reserveList(int m_num){
		return session.selectList(namespace + ".membershipReserve", m_num);
	}
	
	//ȸ�� �󼼺��� - ���� ����(���� ����)
	public List<room_reserveVO> preReserveList(int m_num){
		return session.selectList(namespace + ".membershipPreReserve", m_num);
	}		
	
}
