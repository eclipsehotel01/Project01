package com.eclipse.hotel.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.eclipse.hotel.vo.memberVO;
import com.eclipse.hotel.vo.room_reserveVO;

import com.eclipse.hotel.vo.room_infoVO;


@Repository("management_dao")
public class Management_DAO {
	
	@Inject
	private SqlSession session;
	
	//mapper��� 
	private String namespace = "com.eclipse.hotel.mapper.ManagementMapper";
	
	//��üȸ�� ����
	public List<memberVO> membershipList(){
		return session.selectList(namespace + ".membershipList");
	}
	
	//��üȸ�� ��
	public int membershipCount(){
		return session.selectOne(namespace + ".membershipCount");
	}
	
	//���� ���� ȸ�� ��
	public int todayMembershipCount(){
		return session.selectOne(namespace + ".todayCount");
	}
	
	//ȸ�� �󼼺���
	public memberVO membershipDetail(int m_num){
		return session.selectOne(namespace + ".membershipDetail", m_num);
	}
	
	//ȸ�� �󼼺��� - ���� ����(���� �Ϸ�)
	public List<room_reserveVO>membershipReserve(int m_num){
		return session.selectList(namespace + ".membershipReserve", m_num);
	}
	
	//ȸ�� �󼼺��� - ���� ����(���� ����)
	public List<room_reserveVO> membershipPreReserve(int m_num){
		return session.selectList(namespace + ".membershipPreReserve", m_num);
	}	

	public List<room_infoVO> roomList(String rname) {
		// TODO Auto-generated method stub
		return session.selectList("roomlist", rname);
	}

	public room_infoVO roomDetail(int rnum) {
		// TODO Auto-generated method stub
		return session.selectOne("roomdetail", rnum);
	}


	
	
	
}
