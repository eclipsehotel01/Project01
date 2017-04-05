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
	//게시판리스트or찾기or페이징
	public List getSearchList(HashMap<String,Object>hm){
		return board_guest_dao.guestboardlist(namespace + ".guestboardlist", hm);
	}
	//게시판갯수(검색포함)
	public int getSearchCount(HashMap<String,Object>hm){
		return board_guest_dao.getCount(namespace + ".countSearchData",hm); 
	}
	//게시판상세보기
	public boardVO guestboarddetail(int b_num){
		return board_guest_dao.guestboarddetail(namespace + ".guestboarddetail", b_num);
	}
	//조회수 증가
	public void count(int b_num){
		board_guest_dao.count(namespace + ".CountData", b_num);
	}
	//게시판수정
	public void guestboardupdate(boardVO vo){
		board_guest_dao.guestboardupdate(namespace +".guestboardupdate", vo);
	}
	//게시판삭제
	public  void guestboarddelete(HashMap<String, Object>del){
		board_guest_dao.guestboarddelete(namespace +".guestboarddelete",del);
	}
	//수정시 비밀번호확인
	public String boardCheck(int b_num){
		return board_guest_dao.boardCheck(namespace + ".CheckData",b_num);
	} 
	//댓글리스트
	public List getList(int b_num){
		return board_guest_dao.getCommentList(namespace +".listData",b_num);
	}
	//댓글등록
	public void commentInsert(boardVO vo){
		board_guest_dao.commentInsert(namespace + ".cinsertData",vo);
	}
	//댓글삭제
	public void mydelete(int c_num){
		board_guest_dao.mydelete(namespace + ".myDelete",c_num);
	}
	
	//답글 등록폼
	public boardVO detail(int b_num){
		return board_guest_dao.findById(namespace + ".DetailData", b_num);
	}
	//답글 수정(levels,groups)
	public void update1(boardVO vo){
		board_guest_dao.update1(namespace + ".replyData", vo); 
	}
	//답글 등록
	public void replyinsert(boardVO vo){
		board_guest_dao.replyinsert(namespace + ".replyData1",vo);
	}
}
