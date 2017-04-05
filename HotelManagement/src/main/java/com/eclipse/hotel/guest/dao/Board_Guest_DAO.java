package com.eclipse.hotel.guest.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eclipse.hotel.vo.boardVO;

@Repository("board_guest_dao")
public class Board_Guest_DAO {
	@Autowired
	private SqlSession session;
	
	//�Խ��ǵ��
	public void guestboardinsert(String sqlid,boardVO vo) {
		// TODO Auto-generated method stub
		session.insert(sqlid,vo);
	}
	//�Խ��Ǹ���Ʈ
	public List guestboardlist(String id, HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return session.selectList(id,hm);
	}
	//�Խ��ǰ���(�˻�����)
	public int getCount(String sqlid, HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return session.selectOne(sqlid,hm);
	}
	//�Խ��ǻ󼼺���
	public boardVO guestboarddetail(String sqlid, Object board) {
		// TODO Auto-generated method stub
		boardVO guestboardlist=session.selectOne(sqlid,board);
		return guestboardlist;
	}
	//��ȸ������
	public void count(String sqlid,int b_num){
		session.update(sqlid,b_num);
	}
	//�Խ��Ǽ���
	public void guestboardupdate(String sqlid, boardVO updateboard) {
		// TODO Auto-generated method stub
		session.update(sqlid,updateboard);
	}
	//�Խ��ǻ���
	public void guestboarddelete(String sqlid,Object board){
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
}
