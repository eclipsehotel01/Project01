package com.eclipse.hotel.guest.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eclipse.hotel.guest.dao.MemberDao;

@Service("guest_service")
public class MemberService {

	@Resource(name = "guest_dao")
	public MemberDao guest_dao;
}
