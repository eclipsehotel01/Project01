package com.eclipse.hotel.admin.dao;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.eclipse.hotel.vo.boardVO;

@Repository("board_dao")
public class Board_DAO {
	@Autowired
	private SqlSession session;	
	//�Խ��ǵ��
	public void managementboardinsert(String sqlid, boardVO board) {
		// TODO Auto-generated method stub		
		session.insert(sqlid, board);
	}
	//�Խ��Ǹ���Ʈ
	public List managementboardlist(String id, HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return session.selectList(id,hm);
	}
	//�Խ��ǰ���(�˻�����)
	public int getCount(String sqlid, HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return session.selectOne(sqlid,hm);
	}
	//�Խ��ǻ󼼺���
	public boardVO managementboarddetail(String sqlid, Object board) {
		// TODO Auto-generated method stub
		boardVO managementboardlist=session.selectOne(sqlid,board);
		return managementboardlist;
	}
	//�Խ��Ǽ���
	public void managementboardupdate(String sqlid, boardVO updateboard) {
		// TODO Auto-generated method stub
		session.update(sqlid,updateboard);
	}
	//�Խ��ǻ���
	public void managementboarddelete(String sqlid,Object board){
		session.delete(sqlid,board); 
	}
	//�Խ��Ǽ����� ��й�ȣȮ��
	public String boardCheck(String sqlid,int b_num){
		return session.selectOne(sqlid,b_num);
	}
	//��۸���Ʈ
	public List getCommentList(String sqlid,int b_num){
		return session.selectList(sqlid,b_num);
	}
	//��۵��
	public void commentInsert(String sqlid,boardVO comment){
		session.insert(sqlid,comment);
	}
	//��ۻ���
	public void mydelete(String sqlid,Object comment){
		session.delete(sqlid,comment);
	}
	
	//��۵�����̵�
	public boardVO findById(String sqlid, Object guest) {
		// TODO Auto-generated method stub
		boardVO boardlist=session.selectOne(sqlid,guest);
		return boardlist;		
	}
	//��۵��
	public void replyinsert(String sqlid, boardVO board){
		session.insert(sqlid, board); 
	}
	//��� levels,groups +1 ����
	public void update1(String sqlid, boardVO updateboard) {
		// TODO Auto-generated method stub
		session.update(sqlid,updateboard); 
	}  
	//��ȸ������
	public void count(String sqlid,int b_num){
		session.update(sqlid,b_num);
	}
}
