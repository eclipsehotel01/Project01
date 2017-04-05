package com.eclipse.hotel.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eclipse.hotel.dao.CommonDAO;
import com.eclipse.hotel.vo.zipcodeVO;

@Service("common_service")
public class CommonService {

	@Resource(name = "common_dao")
	private CommonDAO common_dao;
	
	//�����ȣ �˻�
	public List<zipcodeVO> zipcode(String dong){
		return common_dao.zipcode(dong);
	}
}
