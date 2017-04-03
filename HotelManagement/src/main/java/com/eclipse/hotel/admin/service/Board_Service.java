package com.eclipse.hotel.admin.service;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import com.eclipse.hotel.admin.dao.Board_DAO;
import com.eclipse.hotel.vo.boardVO;

@Service("board_service")
public class Board_Service {
	
	@Resource(name = "board_dao")
	private Board_DAO board_dao;
	
	//mapper
	private String namespace = "com.eclipse.hotel.admin.mapper.Myboard";
	
	//�Խ��ǵ��
	public void managementboardinsert(boardVO vo){
		board_dao.managementboardinsert(namespace + ".managementboardinsert",vo);
	}
	//�Խ��Ǹ���Ʈorã��or����¡
	public List getSearchList(HashMap<String,Object>hm){
		return board_dao.managementboardlist(namespace + ".managementboardlist", hm);
	}
	//�Խ��ǰ���(�˻�����)
	public int getSearchCount(HashMap<String,Object>hm){
		return board_dao.getCount(namespace + ".countSearchData",hm); 
	}
	//�Խ��ǻ󼼺���
	public boardVO managementboarddetail(int b_num){
		return board_dao.managementboarddetail(namespace + ".managementboarddetail", b_num);
	}
	//�Խ��Ǽ���
	public void managementboardupdate(boardVO vo){
		board_dao.managementboardupdate(namespace +".managementboardupdate", vo);
	}
	//�Խ��ǻ���
	public  void managementboarddelete(HashMap<String, Object>del){
		board_dao.managementboarddelete(namespace +".managementboarddelete",del);
	}
	//������ ��й�ȣȮ��
	public String boardCheck(int b_num){
		return board_dao.boardCheck(namespace + ".CheckData",b_num);
	} 
	//��۸���Ʈ
	public List getList(int b_num){
		return board_dao.getCommentList(namespace +".listData",b_num);
	}
	//��۵��
	public void commentInsert(boardVO vo){
		board_dao.commentInsert(namespace + ".cinsertData",vo);
	}
	//��ۻ���
	public void mydelete(int c_num){
		board_dao.mydelete(namespace + ".myDelete",c_num);
	}
	
	//��� �����
	public boardVO detail(int b_num){
		return board_dao.findById(namespace + ".DetailData", b_num);
	}
	//��� ����(levels,groups)
	public void update1(boardVO vo){
		board_dao.update1(namespace + ".replyData", vo); 
	}
	//��� ���
	public void replyinsert(boardVO vo){
		board_dao.replyinsert(namespace + ".replyData1",vo);
	}
	//��ȸ�� ����
	public void count(int b_num){
		board_dao.count(namespace + ".CountData", b_num);
	}
	
}