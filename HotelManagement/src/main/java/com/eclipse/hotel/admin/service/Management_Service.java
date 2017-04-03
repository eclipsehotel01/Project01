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
	//객실등록파일첨부

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
	//객실 전체보기
	public List<room_infoVO> roomList(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return management_dao.roomList(hm);
	}
	
	//객실 수
	public int getRoomCount(String rname) {
		// TODO Auto-generated method stub
		return management_dao.getRoomCount(rname);
	} 

	//객실 상세보기
	public room_infoVO roomDetail(int rnum) {
		// TODO Auto-generated method stub
		return management_dao.roomDetail(rnum);
	}

	//객실요금표
	public List<room_priceVO> roomPrice() {
		// TODO Auto-generated method stub
		return management_dao.roomPrice();
	}

	//객실정보수정
	public void roomUpdate(room_infoVO vo) {
		// TODO Auto-generated method stub
		management_dao.roomUpdate(vo);
	}

	//객실삭제
	public void roomDelete(int rnum) {
		// TODO Auto-generated method stub
		management_dao.roomDelete(rnum);
	}

/*	//객실등록
	public void roomInsert(room_infoVO vo) {
		// TODO Auto-generated method stub
		management_dao.roomInsert(vo);
		
	}
*/
	//객실요금수정
	public void priceUpdate(room_priceVO vo) {
		// TODO Auto-generated method stub
		management_dao.priceUpdate(vo);
	}

	//결제목록
	public List<paymentVO> payList(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return management_dao.payList(hm);
	}

	//결제건수
	public int payCount(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return management_dao.payCount(hm);
	}

	//결제총액
	public int payTotal(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return management_dao.payTotal(hm);
	}

	//결제취소
	public void payCancel(int p_num) {
		// TODO Auto-generated method stub
		management_dao.payCancel(p_num);
	}

	//결제 취소여부 확인
	public int cancelCheck(int p_num) {
		// TODO Auto-generated method stub
		return management_dao.cancelCheck(p_num);
	}	
	
	//파일첨부
}
