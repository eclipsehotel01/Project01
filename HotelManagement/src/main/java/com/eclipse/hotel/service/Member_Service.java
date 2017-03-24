package com.eclipse.hotel.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eclipse.hotel.dao.Member_DAO;

@Service("member_service")
public class Member_Service {

	@Resource(name = "member_dao")
	private Member_DAO member_dao;
}
