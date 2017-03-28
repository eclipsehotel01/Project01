package com.eclipse.hotel.admin.service;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eclipse.hotel.admin.dao.Management_DAO;
import com.eclipse.hotel.vo.memberVO;
import com.eclipse.hotel.vo.paymentVO;
import com.eclipse.hotel.vo.room_reserveVO;

import com.eclipse.hotel.vo.room_infoVO;
import com.eclipse.hotel.vo.room_priceVO;


@Service("management_service")
public class Management_Service {

	@Resource(name = "management_dao")
	private Management_DAO management_dao; 	

	//���� ��ü����
	public List<room_infoVO> roomList(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return management_dao.roomList(hm);
	}
	
	//���� ��
	public int getRoomCount(String rname) {
		// TODO Auto-generated method stub
		return management_dao.getRoomCount(rname);
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

	//���ǿ�ݼ���
	public void priceUpdate(room_priceVO vo) {
		// TODO Auto-generated method stub
		management_dao.priceUpdate(vo);
	}

	//�������
	public List<paymentVO> payList(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return management_dao.payList(hm);
	}

	//�����Ǽ�
	public int payCount(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return management_dao.payCount(hm);
	}

	//�����Ѿ�
	public int payTotal(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return management_dao.payTotal(hm);
	}

	//�������
	public void payCancel(int p_num) {
		// TODO Auto-generated method stub
		management_dao.payCancel(p_num);
	}

	//���� ��ҿ��� Ȯ��
	public int cancelCheck(int pnum) {
		// TODO Auto-generated method stub
		return management_dao.cancelCheck(pnum);
	}	

}
