package com.eclipse.hotel.dao;


import java.util.List;

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
import com.eclipse.hotel.vo.room_priceVO;


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

	//���� ��ü����
	public List<room_infoVO> roomList(String rname) {
		// TODO Auto-generated method stub
		return session.selectList("roomlist", rname);
	}

	//���� �󼼺���
	public room_infoVO roomDetail(int rnum) {
		// TODO Auto-generated method stub
		return session.selectOne("roomdetail", rnum);
	}

	//���ǿ��ǥ
	public List<room_priceVO> roomPrice() {
		// TODO Auto-generated method stub
		return session.selectList("roomprice");
	}

	//���Ǽ���
	public void roomUpdate(room_infoVO vo) {
		// TODO Auto-generated method stub
		session.update("roomupdate", vo);
	}

	//���ǻ���
	public void roomDelete(int rnum) {
		// TODO Auto-generated method stub
		session.delete("roomdelete", rnum);
	}

	//���ǵ��
	public void roomInsert(room_infoVO vo) {
		// TODO Auto-generated method stub
		session.insert("roominsert", vo);
	}

	public void priceUpdate(room_priceVO vo) {
		// TODO Auto-generated method stub
		session.update("priceupdate", vo);
	}

	public List<paymentVO> payList(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return session.selectList("paylist", hm);
	}

	public int payCount(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return session.selectOne("paycount", hm);
	}

	public int payTotal(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return session.selectOne("paytotal", hm);
	}


	
	
	
}
