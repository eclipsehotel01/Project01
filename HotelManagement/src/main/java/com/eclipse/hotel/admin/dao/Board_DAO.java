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
	//게시판등록
	public void managementboardinsert(String sqlid, boardVO board) {
		// TODO Auto-generated method stub		
		session.insert(sqlid, board);
	}
	//게시판리스트
	public List managementboardlist(String id, HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return session.selectList(id,hm);
	}
	//게시판갯수(검색포함)
	public int getCount(String sqlid, HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return session.selectOne(sqlid,hm);
	}
	//게시판상세보기
	public boardVO managementboarddetail(String sqlid, Object board) {
		// TODO Auto-generated method stub
		boardVO managementboardlist=session.selectOne(sqlid,board);
		return managementboardlist;
	}
	//게시판수정
	public void managementboardupdate(String sqlid, boardVO updateboard) {
		// TODO Auto-generated method stub
		session.update(sqlid,updateboard);
	}
	//게시판삭제
	public void managementboarddelete(String sqlid,Object board){
		session.delete(sqlid,board); 
	}
	//게시판수정시 비밀번호확인
	public String boardCheck(String sqlid,int b_num){
		return session.selectOne(sqlid,b_num);
	}
	//댓글리스트
	public List getCommentList(String sqlid,int b_num){
		return session.selectList(sqlid,b_num);
	}
	//댓글등록
	public void commentInsert(String sqlid,boardVO comment){
		session.insert(sqlid,comment);
	}
	//댓글삭제
	public void mydelete(String sqlid,Object comment){
		session.delete(sqlid,comment);
	}
	
	//답글등록폼이동
	public boardVO findById(String sqlid, Object guest) {
		// TODO Auto-generated method stub
		boardVO boardlist=session.selectOne(sqlid,guest);
		return boardlist;		
	}
	//답글등록
	public void replyinsert(String sqlid, boardVO board){
		session.insert(sqlid, board); 
	}
	//답글 levels,groups +1 수정
	public void update1(String sqlid, boardVO updateboard) {
		// TODO Auto-generated method stub
		session.update(sqlid,updateboard); 
	}  
	//조회수증가
	public void count(String sqlid,int b_num){
		session.update(sqlid,b_num);
	}
}
