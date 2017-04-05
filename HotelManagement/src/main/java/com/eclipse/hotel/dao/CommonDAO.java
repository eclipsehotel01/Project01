package com.eclipse.hotel.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.eclipse.hotel.vo.zipcodeVO;

@Repository("common_dao")
public class CommonDAO {
	
	@Inject
	private SqlSession session;
	
	//mapper��� 
	private String namespace = "com.eclipse.hotel.mapper.CommonMapper";

	//�����ȣ �˻�
	public List<zipcodeVO> zipcode(String dong){
		return session.selectList(namespace + ".zipcode", dong);
	}
}
