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
	
	//���� ����Ʈ
	public List<room_reserveVO> list(){
		return reserve_dao.list();
	}
	//������ ��������
	public room_reserveVO selectlist(int reservecode)
	{
		return reserve_dao.selectlist(reservecode);
	}
	//������ ������
	public List<memberVO>rmember(int m_num)
	{
		return reserve_dao.rmember(m_num);
	}
	//���� ����
	public void delreserve(String reservecode)
	{
		reserve_dao.delreserve(reservecode);
	}
	//���� ����
	public void  update(room_reserveVO reserve)
	{
		 System.out.println("service update");
		 reserve_dao.update(reserve);
	}
	//����� ȣ��Ÿ��
	public String searchtype(int rnum)
	{
		return reserve_dao.searchtype(rnum);
	}
	//����� ȣ���� ������
	public int getpay(String paytype)
	{
		return reserve_dao.getpay(paytype);
	}
	//����� ȣ���� ����� ���
	public int getnonpay(String paytype)
	{
		return reserve_dao.getnonpay(paytype);
	}
	//����� ȣ���� �����ο�
	public int standperson(int room)
	{
		return reserve_dao.standperson(room);
	}
	//���ȣ ����Ʈ
	public List<room_infoVO> listRnum(){
		return reserve_dao.listRnum();
	}
	//�߰� ���
	public int getExtraTotal(String string) {
		// TODO Auto-generated method stub
		return reserve_dao.getExtraTotal(string);
	}
	
	//ȣ������
	public room_infoVO roomInfo(int rnum) {
		// TODO Auto-generated method stub
		return reserve_dao.roomInfo(rnum);
	}

}
