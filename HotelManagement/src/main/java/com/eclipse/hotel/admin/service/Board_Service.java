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
	
	//게시판등록
	public void managementboardinsert(boardVO vo){
		board_dao.managementboardinsert(namespace + ".managementboardinsert",vo);
	}
	//게시판리스트or찾기or페이징
	public List getSearchList(HashMap<String,Object>hm){
		return board_dao.managementboardlist(namespace + ".managementboardlist", hm);
	}
	//게시판갯수(검색포함)
	public int getSearchCount(HashMap<String,Object>hm){
		return board_dao.getCount(namespace + ".countSearchData",hm); 
	}
	//게시판상세보기
	public boardVO managementboarddetail(int b_num){
		return board_dao.managementboarddetail(namespace + ".managementboarddetail", b_num);
	}
	//게시판수정
	public void managementboardupdate(boardVO vo){
		board_dao.managementboardupdate(namespace +".managementboardupdate", vo);
	}
	//게시판삭제
	public  void managementboarddelete(HashMap<String, Object>del){
		board_dao.managementboarddelete(namespace +".managementboarddelete",del);
	}
	//수정시 비밀번호확인
	public String boardCheck(int b_num){
		return board_dao.boardCheck(namespace + ".CheckData",b_num);
	} 
	//댓글리스트
	public List getList(int b_num){
		return board_dao.getCommentList(namespace +".listData",b_num);
	}
	//댓글등록
	public void commentInsert(boardVO vo){
		board_dao.commentInsert(namespace + ".cinsertData",vo);
	}
	//댓글삭제
	public void mydelete(int c_num){
		board_dao.mydelete(namespace + ".myDelete",c_num);
	}
	
	//답글 등록폼
	public boardVO detail(int b_num){
		return board_dao.findById(namespace + ".DetailData", b_num);
	}
	//답글 수정(levels,groups)
	public void update1(boardVO vo){
		board_dao.update1(namespace + ".replyData", vo); 
	}
	//답글 등록
	public void replyinsert(boardVO vo){
		board_dao.replyinsert(namespace + ".replyData1",vo);
	}
	//조회수 증가
	public void count(int b_num){
		board_dao.count(namespace + ".CountData", b_num);
	}
	
}