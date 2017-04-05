package com.eclipse.hotel.guest.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eclipse.hotel.guest.dao.MemberDao;
import com.eclipse.hotel.vo.memberVO;

@Service("member_service")
public class MemberService {

	@Resource(name = "member_dao")
	public MemberDao member_dao;
	
	//회원 가입
	public void memberRegister(memberVO member){
		member_dao.memberRegister(member);
	}
	
	//아이디 중복 확인
	public String memberIdCheck(String id){
		return member_dao.memberIdCheck(id);
	}
	
	//로그인
	public String memberLogin(memberVO member){
		return member_dao.memberLogin(member);
	}
	
	//고객번호 
	public int memberNo(String id){
		return member_dao.memberNo(id);
	}
	
	//마이 페이지
	public memberVO memberMypage(int m_num){
		return member_dao.memberMypage(m_num);
	}
	
	//회원정보 수정
	public void memberUpdate(memberVO member){
		member_dao.memberUpdate(member);
	}
}
