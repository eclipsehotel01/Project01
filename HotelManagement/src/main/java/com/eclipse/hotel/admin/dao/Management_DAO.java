package com.eclipse.hotel.admin.dao;


import java.util.List;
import java.util.Map;

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
import com.eclipse.hotel.vo.room_memoVO;
import com.eclipse.hotel.vo.room_priceVO;


@Repository("management_dao")
public class Management_DAO {
	
	@Inject
	private SqlSession session;
	
	//mapper��� 
	private String namespace = "com.eclipse.hotel.admin.mapper.ManagementMapper";
	
/*	public int insertFile(Map<String, Object> map) throws Exception{
		
		return session.insert("sample.insertFile", map);
	}*/

	//���� ��ü����
	public List<room_infoVO> roomList(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		
		return session.selectList("roomlist", hm);
	}
	
	//���Ǽ�
	public int getRoomCount(String rname) {
		// TODO Auto-generated method stub
		return session.selectOne("roomcount", rname);
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
	public void roomInsert(Map<String, Object>map) {
		// TODO Auto-generated method stub
		session.insert("roominsert", map);
	}

	//���ǿ�ݼ���
	public void priceUpdate(room_priceVO vo) {
		// TODO Auto-generated method stub
		session.update("priceupdate", vo);
	}

	//�������
	public List<paymentVO> payList(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return session.selectList("paylist", hm);
	}

	//�����Ǽ�
	public int payCount(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return session.selectOne("paycount", hm);
	}

	//�����Ѿ�
	public int payTotal(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return session.selectOne("paytotal", hm);
	}

	//�������
	public void payCancel(int p_num) {
		// TODO Auto-generated method stub
		session.update("paycancel", p_num);
	}

	//���� ��ҿ��� Ȯ��
	public int cancelCheck(int p_num) {
		// TODO Auto-generated method stub
		return session.selectOne("cancelcheck", p_num);
	}	
	
	//���� Ÿ�� ���
	public List<room_memoVO> typelist() {
		// TODO Auto-generated method stub
		return session.selectList("typelist");
	}

	//���� Ÿ�� ���� ����
	public void rtype_update(room_memoVO memo) {
		// TODO Auto-generated method stub
		session.selectList("rtypeupdate", memo);
	}	
}
