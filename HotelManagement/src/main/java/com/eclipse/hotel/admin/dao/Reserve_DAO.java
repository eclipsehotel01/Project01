package com.eclipse.hotel.admin.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.eclipse.hotel.vo.extra_chargeVO;
import com.eclipse.hotel.vo.memberVO;
import com.eclipse.hotel.vo.room_infoVO;
import com.eclipse.hotel.vo.room_reserveVO;

@Repository("reserve_dao")
public class Reserve_DAO {
	
	@Inject
	private SqlSession session;
	
	//mapper��� 
	private String namespace = "com.eclipse.hotel.admin.mapper.ReserveMapper";
	
	//���� ����Ʈ
	public List<room_reserveVO> list(){
		return session.selectList(namespace + ".reserveList");
	}
	//Ŭ���� ����
	public room_reserveVO selectlist(int reservecode)
	{
		return session.selectOne(namespace+".selectlist",reservecode);
	}
	//Ŭ���� ���
	public List<memberVO>rmember(int m_num)
	{
		return session.selectList(namespace+".rmember",m_num);
	}
	//���� ����
	public void delreserve(String reservecode)
	{
		session.delete(namespace+".delreserve",reservecode);
	}
	//���� ����
	public void update(room_reserveVO reserve)
	{ 
		
		session.update(namespace+".update",reserve);
		System.out.println("dao :"+reserve.getP_price());
	}
	//����� ȣ��
	public String searchtype(int rnum)
	{
		return session.selectOne(namespace+".searchtype",rnum);
	}
	//����� ȣ���� ������
	public int getpay(String paytype)
	{
		return session.selectOne(namespace+".getpay",paytype);
	}
	//����� ȣ���� ����� ���
	public int getnonpay(String paytype)
	{
		return session.selectOne(namespace+".getnonpay",paytype);
	}
	//����� ȣ���� ���� �ο�
	public int standperson(int room)
	{
		return session.selectOne(namespace+".standperson",room);
	}
	//���ȣ ����Ʈ
	public List<room_infoVO> listRnum(){
		return session.selectList(namespace + ".rnumList");
	}
	//�߰����
	public int getExtraTotal(String string) {
		// TODO Auto-generated method stub
		System.out.println("dao"+string);
		return session.selectOne(namespace + ".getextracharge", string);
		
	}
	public room_infoVO roomInfo(int rnum) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".roomInfo", rnum);
	}

}
