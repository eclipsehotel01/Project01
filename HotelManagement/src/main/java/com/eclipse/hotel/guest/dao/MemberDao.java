package com.eclipse.hotel.guest.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("guest_dao")
public class MemberDao {
	
	@Inject
	public SqlSession session;
	
	//mapper��� 
	private String namespace = "com.eclipse.hotel.guest.mapper.GuestMapper";

}
