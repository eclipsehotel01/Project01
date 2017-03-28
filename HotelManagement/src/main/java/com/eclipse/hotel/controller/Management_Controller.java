package com.eclipse.hotel.controller;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eclipse.hotel.service.Management_Service;
import com.eclipse.hotel.util.PageAction;
import com.eclipse.hotel.util.PageAction_Room;
import com.eclipse.hotel.vo.memberVO;
import com.eclipse.hotel.vo.paymentVO;
import com.eclipse.hotel.vo.room_reserveVO;

import com.eclipse.hotel.vo.room_infoVO;
import com.eclipse.hotel.vo.room_priceVO;


@Controller

public class Management_Controller {
	
	@Autowired
	private PageAction page;
	
	@Autowired
	private PageAction_Room page_r;
	
	@Resource(name = "management_service")
	private Management_Service management_service;
	

	//전체회원 보기
	@RequestMapping(value = "admin_membership_list", method = RequestMethod.GET)
	public String membershipList(Model model){
		List<memberVO> memberList = management_service.membershipList();
		int memberCount = management_service.membershipCount();
		int todayCount = management_service.todayMembershipCount();
		
		model.addAttribute("memberList", memberList);
		model.addAttribute("memberCount", memberCount);
		model.addAttribute("todayCount", todayCount);
		
		return "management/membership/membership_list";
	}
	
	//회원 상세보기
	@RequestMapping(value = "admin_membership_detail", method = RequestMethod.GET)
	public String membershipDetail(int m_num, Model model){
		memberVO member = management_service.membershipDetail(m_num);
		List<room_reserveVO> reserveList = management_service.membershipReserve(m_num);
		List<room_reserveVO> pre_reserveList = management_service.membershipPreReserve(m_num);
		
		model.addAttribute("member", member);
		model.addAttribute("reserveList", reserveList);
		model.addAttribute("pre_reserveList", pre_reserveList);
		
		return "management/membership/membership_detail";
	}
	
	//객실목록
	@RequestMapping(value = "room_list")
	public String room_list(Model model, String pageNum, String rname){		
		if(rname==null) rname ="";
		int count = management_service.getRoomCount(rname);
		
		int pageSize = 4;
			if(pageNum==null) pageNum="1";
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
			if(endRow > count) endRow = count;
			
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
		hm.put("rname", rname);
		
		List<room_infoVO> infoList = management_service.roomList(hm);
		String pageHtml = page_r.paging(count, pageSize, currentPage, rname);
		
		model.addAttribute("count", count);
		model.addAttribute("roomlist", infoList);
		model.addAttribute("pageHtml", pageHtml);
		return "management/reserve/room_management";
	}	
	
	//객실상세보기
	@RequestMapping(value = "room_detail")
	public String room_detail(Model model, int rnum){
		room_infoVO infoDetail = management_service.roomDetail(rnum);
		List<room_priceVO> pricelist = management_service.roomPrice();
		
		model.addAttribute("infoDetail", infoDetail);
		model.addAttribute("pricelist", pricelist);
		return "management/reserve/room_detail";
	}
	
	//객실정보수정
	@RequestMapping(value = "room_update")
	public String room_update(room_infoVO vo){
		management_service.roomUpdate(vo);
		return "redirect:room_list";
	}
	
	//객실삭제
	@RequestMapping(value = "room_delete")
	public String room_delete(int rnum){
		management_service.roomDelete(rnum);
		return "redirect:room_list";
	}
	
	//객실 등록페이지
	@RequestMapping(value = "room_insertOpen")
	public String room_insertOpen(Model model){
		List<room_priceVO> pricelist = management_service.roomPrice();
		model.addAttribute("pricelist", pricelist);
		return "management/reserve/room_insert";
	}
	
	//객실등록
	@RequestMapping(value = "room_insert")
	public String room_insert(room_infoVO vo){
		management_service.roomInsert(vo);
		return "redirect:room_list";
	}
	
	//객실요금목록
	@RequestMapping(value = "room_price")
	private String room_price(Model model){
		List<room_priceVO> pricelist = management_service.roomPrice();
		model.addAttribute("pricelist", pricelist);
		return "management/payment/room_price";
	}
	
	//객실요금수정
	@RequestMapping(value = "price_update")
	public String price_update(room_priceVO vo){
		management_service.priceUpdate(vo);
		return "redirect:room_price";
	} 
	
	//결제목록
	@RequestMapping(value = "pay_list")
	public String pay_list(Model model, String pageNum, String field, String word){
		if(field==null) field = "";
		if(word==null) word = "";
		
		HashMap<String, Object> hm11 = new HashMap<String, Object>();
		hm11.put("searchType", field);
		hm11.put("word", word);
		
		int paycount = management_service.payCount(hm11);
		int paytotal = management_service.payTotal(hm11);
		
		int pageSize = 4;
		if(pageNum==null) pageNum="1";
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		if(endRow > paycount) endRow = paycount;
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
		hm11.put("searchType", field);
		hm11.put("word", word);
		
		List<paymentVO> paylist = management_service.payList(hm);
		String pageHtml = page.paging(paycount, pageSize, currentPage, field, word);
		
		model.addAttribute("paycount", paycount);
		model.addAttribute("paytotal", paytotal);
		model.addAttribute("paylist", paylist);
		model.addAttribute("pageHtml", pageHtml);
		
		return "management/payment/pay_management";
	}
	
	//결제취소
	@RequestMapping(value = "pay_cancel")
	@ResponseBody
	public String pay_cancel(String p_num){	//삭제아니고 업데이트!
		String msg = "";
		String[] arr =  p_num.split(",");
		
		//결제 취소 여부 확인
		for(int i=0; i<arr.length;i++){
			if(management_service.cancelCheck(Integer.parseInt(arr[i]))==1){
				msg = "fail";
				break;
			}else	msg = "success";
		}
		
		//선택된 결제 취소
		for(int i=0; i<arr.length;i++){
			if(msg == "success"){
				 management_service.payCancel(Integer.parseInt(arr[i]));
			}
		}
		return msg;
	}
}
