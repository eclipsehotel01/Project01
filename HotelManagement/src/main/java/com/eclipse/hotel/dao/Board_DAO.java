package com.eclipse.hotel.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eclipse.hotel.vo.boardVO;

@Repository("board_dao")
public class Board_DAO {
	@Autowired
	private SqlSession session;	
	
	public void managementboardinsert(String sqlid, boardVO board) {
		// TODO Auto-generated method stub		
		session.insert(sqlid, board);
	}
	public List managementboardlist(String id, HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
//		SqlSession session=sqlMap.openSession(ExecutorType.REUSE);
		return session.selectList(id,hm);
	}
	public int getCount(String sqlid, HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
//		SqlSession session=sqlMap.openSession(ExecutorType.REUSE);
		return session.selectOne(sqlid,hm);
	}
	public boardVO managementboarddetail(String sqlid, Object board) {
		// TODO Auto-generated method stub
//		SqlSession session=sqlMap.openSession(ExecutorType.REUSE);
		boardVO managementboardlist=session.selectOne(sqlid,board);
		return managementboardlist;
	}
	public void managementboardupdate(String sqlid, boardVO updateboard) {
		// TODO Auto-generated method stub
//		SqlSession session=sqlMap.openSession(ExecutorType.REUSE);
		session.update(sqlid,updateboard);
	}
	public void managementboarddelete(String sqlid,Object board){
		session.delete(sqlid,board); 
	}
	
	public String boardCheck(String sqlid,int b_num){
//		SqlSession session=sqlMap.openSession(ExecutorType.REUSE);
		return session.selectOne(sqlid,b_num);
	}
	//댓글
	public List getCommentList(String sqlid,int b_num){
//		SqlSession session=sqlMap.openSession(ExecutorType.REUSE);
		return session.selectList(sqlid,b_num);
	}
	public void commentInsert(String sqlid,boardVO comment){
//		SqlSession session=sqlMap.openSession(ExecutorType.REUSE);
		session.insert(sqlid,comment);
	}
	public void mydelete(String sqlid,Object comment){
//		SqlSession session=sqlMap.openSession(ExecutorType.REUSE);
		session.delete(sqlid,comment);
	}
	
	//답글
	public boardVO findById(String sqlid, Object guest) {
		// TODO Auto-generated method stub
//		SqlSession session=sqlMap.openSession(ExecutorType.REUSE);
		boardVO boardlist=session.selectOne(sqlid,guest);
		return boardlist;		
	}

	public void replyinsert(String sqlid, boardVO board){
//		SqlSession session=sqlMap.openSession(ExecutorType.REUSE);
		session.insert(sqlid, board); 
	}
	public void update1(String sqlid, boardVO updateboard) {
		// TODO Auto-generated method stub
//		SqlSession session=sqlMap.openSession(ExecutorType.REUSE);
		session.update(sqlid,updateboard); 
	}  
	//조회수증가
	public void count(String sqlid,int b_num){
		session.update(sqlid,b_num);
	}
}
