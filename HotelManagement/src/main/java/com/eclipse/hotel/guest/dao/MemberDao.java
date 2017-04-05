package com.eclipse.hotel.guest.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.eclipse.hotel.vo.memberVO;

@Repository("member_dao")
public class MemberDao {
	
	@Inject
	public SqlSession session;
	
	//mapper경로 
	private String namespace = "com.eclipse.hotel.guest.mapper.MemberMapper";
	
	//회원가입
	public void memberRegister(memberVO member){
		session.insert(namespace + ".memberInsert", member);
	}

	//아이디 중복 확인
	public String memberIdCheck(String id){		
		return session.selectOne(namespace + ".idCheck", id);
	}
	
	//로그인
	public String memberLogin(memberVO member){
		return session.selectOne(namespace + ".memberLogin", member);
	}
	
	//멤버 번호
	public int memberNo(String id){
		return session.selectOne(namespace + ".memberNo", id);
	}
	
	//마이페이지
	public memberVO memberMypage(int m_num){
		return session.selectOne(namespace + ".memberPage", m_num);
	}
	
	//회원정보 수정
	public void memberUpdate(memberVO member){
		session.update(namespace + ".memberUpdate", member);
	}
}
