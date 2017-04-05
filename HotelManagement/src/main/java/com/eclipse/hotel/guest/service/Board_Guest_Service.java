package com.eclipse.hotel.guest.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eclipse.hotel.guest.dao.Board_Guest_DAO;
import com.eclipse.hotel.vo.boardVO;

@Service("board_guest_service")
public class Board_Guest_Service {

	@Resource(name="board_guest_dao")
	private Board_Guest_DAO board_guest_dao;

	//mapper
	private String namespace = "com.eclipse.hotel.guest.mapper.MyGuestboard";
	public void guestboardinsert(boardVO vo) {
		// TODO Auto-generated method stub
		board_guest_dao.guestboardinsert(namespace +".guestboardinsert",vo);
	}
	//�Խ��Ǹ���Ʈorã��or����¡
	public List getSearchList(HashMap<String,Object>hm){
		return board_guest_dao.guestboardlist(namespace + ".guestboardlist", hm);
	}
	//�Խ��ǰ���(�˻�����)
	public int getSearchCount(HashMap<String,Object>hm){
		return board_guest_dao.getCount(namespace + ".countSearchData",hm); 
	}
	//�Խ��ǻ󼼺���
	public boardVO guestboarddetail(int b_num){
		return board_guest_dao.guestboarddetail(namespace + ".guestboarddetail", b_num);
	}
	//��ȸ�� ����
	public void count(int b_num){
		board_guest_dao.count(namespace + ".CountData", b_num);
	}
	//�Խ��Ǽ���
	public void guestboardupdate(boardVO vo){
		board_guest_dao.guestboardupdate(namespace +".guestboardupdate", vo);
	}
	//�Խ��ǻ���
	public  void guestboarddelete(HashMap<String, Object>del){
		board_guest_dao.guestboarddelete(namespace +".guestboarddelete",del);
	}
	//������ ��й�ȣȮ��
	public String boardCheck(int b_num){
		return board_guest_dao.boardCheck(namespace + ".CheckData",b_num);
	} 
	//��۸���Ʈ
	public List getList(int b_num){
		return board_guest_dao.getCommentList(namespace +".listData",b_num);
	}
	//��۵��
	public void commentInsert(boardVO vo){
		board_guest_dao.commentInsert(namespace + ".cinsertData",vo);
	}
	//��ۻ���
	public void mydelete(int c_num){
		board_guest_dao.mydelete(namespace + ".myDelete",c_num);
	}
	
	//��� �����
	public boardVO detail(int b_num){
		return board_guest_dao.findById(namespace + ".DetailData", b_num);
	}
	//��� ����(levels,groups)
	public void update1(boardVO vo){
		board_guest_dao.update1(namespace + ".replyData", vo); 
	}
	//��� ���
	public void replyinsert(boardVO vo){
		board_guest_dao.replyinsert(namespace + ".replyData1",vo);
	}
}
