package com.eclipse.hotel.guest.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.eclipse.hotel.vo.memberVO;

@Repository("member_dao")
public class MemberDao {
	
	@Inject
	public SqlSession session;
	
	//mapper��� 
	private String namespace = "com.eclipse.hotel.guest.mapper.MemberMapper";
	
	//ȸ������
	public void memberRegister(memberVO member){
		session.insert(namespace + ".memberInsert", member);
	}

	//���̵� �ߺ� Ȯ��
	public String memberIdCheck(String id){		
		return session.selectOne(namespace + ".idCheck", id);
	}
	
	//�α���
	public String memberLogin(memberVO member){
		return session.selectOne(namespace + ".memberLogin", member);
	}
	
	//��� ��ȣ
	public int memberNo(String id){
		return session.selectOne(namespace + ".memberNo", id);
	}
	
	//����������
	public memberVO memberMypage(int m_num){
		return session.selectOne(namespace + ".memberPage", m_num);
	}
	
	//ȸ������ ����
	public void memberUpdate(memberVO member){
		session.update(namespace + ".memberUpdate", member);
	}
}
