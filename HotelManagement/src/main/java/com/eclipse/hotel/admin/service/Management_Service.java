package com.eclipse.hotel.admin.service;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.eclipse.hotel.admin.dao.Management_DAO;
import com.eclipse.hotel.util.FileUtils;

import com.eclipse.hotel.vo.paymentVO;


import com.eclipse.hotel.vo.room_infoVO;
import com.eclipse.hotel.vo.room_priceVO;


@Service("management_service")
public class Management_Service {

	@Resource(name = "management_dao")
	private Management_DAO management_dao; 	

	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	private static final Logger logger = LoggerFactory.getLogger(Management_Service.class);
	//���ǵ������÷��

	public void roomInsert(Map<String, Object>map,HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
/*		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		while(iterator.hasNext()){
		multipartFile = multipartHttpServletRequest.getFile(iterator.next());
		if(multipartFile.isEmpty() == false){
			
			logger.info("------------- file start -------------");
			logger.info("name : "+multipartFile.getName());
			logger.info("filename : "+multipartFile.getOriginalFilename());
			logger.info("size : "+multipartFile.getSize());
			logger.info("-------------- file end --------------\n");
			}
		}*/
		String img=null;
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(map, request);
		System.out.println("list ORIGINAL_FILE_NAME:"+list.get(0).get("ORIGINAL_FILE_NAME"));
		map.put("img", list.get(0).get("ORIGINAL_FILE_NAME"));
		System.out.println("map :"+map);
		management_dao.roomInsert(map);
//		System.out.println("list :"+list);
		
		/*for(int i=0, size=list.size(); i<size; i++){
			management_dao.roomInsert(list.get(i));
		}*/


	}
	//���� ��ü����
	public List<room_infoVO> roomList(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return management_dao.roomList(hm);
	}
	
	//���� ��
	public int getRoomCount(String rname) {
		// TODO Auto-generated method stub
		return management_dao.getRoomCount(rname);
	} 

	//���� �󼼺���
	public room_infoVO roomDetail(int rnum) {
		// TODO Auto-generated method stub
		return management_dao.roomDetail(rnum);
	}

	//���ǿ��ǥ
	public List<room_priceVO> roomPrice() {
		// TODO Auto-generated method stub
		return management_dao.roomPrice();
	}

	//������������
	public void roomUpdate(room_infoVO vo) {
		// TODO Auto-generated method stub
		management_dao.roomUpdate(vo);
	}

	//���ǻ���
	public void roomDelete(int rnum) {
		// TODO Auto-generated method stub
		management_dao.roomDelete(rnum);
	}

/*	//���ǵ��
	public void roomInsert(room_infoVO vo) {
		// TODO Auto-generated method stub
		management_dao.roomInsert(vo);
		
	}
*/
	//���ǿ�ݼ���
	public void priceUpdate(room_priceVO vo) {
		// TODO Auto-generated method stub
		management_dao.priceUpdate(vo);
	}

	//�������
	public List<paymentVO> payList(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return management_dao.payList(hm);
	}

	//�����Ǽ�
	public int payCount(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return management_dao.payCount(hm);
	}

	//�����Ѿ�
	public int payTotal(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return management_dao.payTotal(hm);
	}

	//�������
	public void payCancel(int p_num) {
		// TODO Auto-generated method stub
		management_dao.payCancel(p_num);
	}

	//���� ��ҿ��� Ȯ��
	public int cancelCheck(int p_num) {
		// TODO Auto-generated method stub
		return management_dao.cancelCheck(p_num);
	}	
	
	//����÷��
}
