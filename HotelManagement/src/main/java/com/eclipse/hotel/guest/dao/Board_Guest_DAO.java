package com.eclipse.hotel.guest.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("board_guest_dao")
public class Board_Guest_DAO {
	@Autowired
	private SqlSession session;
}
