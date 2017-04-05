package com.eclipse.hotel.guest.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eclipse.hotel.guest.dao.MemberDao;
import com.eclipse.hotel.vo.memberVO;

@Service("member_service")
public class MemberService {

	@Resource(name = "member_dao")
	public MemberDao member_dao;
	
	//ȸ�� ����
	public void memberRegister(memberVO member){
		member_dao.memberRegister(member);
	}
	
	//���̵� �ߺ� Ȯ��
	public String memberIdCheck(String id){
		return member_dao.memberIdCheck(id);
	}
	
	//�α���
	public String memberLogin(memberVO member){
		return member_dao.memberLogin(member);
	}
	
	//����ȣ 
	public int memberNo(String id){
		return member_dao.memberNo(id);
	}
	
	//���� ������
	public memberVO memberMypage(int m_num){
		return member_dao.memberMypage(m_num);
	}
	
	//ȸ������ ����
	public void memberUpdate(memberVO member){
		member_dao.memberUpdate(member);
	}
}
