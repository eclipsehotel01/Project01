package com.eclipse.hotel.admin.controller;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eclipse.hotel.admin.service.Membership_Service;
import com.eclipse.hotel.util.PageAction;
import com.eclipse.hotel.vo.memberVO;
import com.eclipse.hotel.vo.room_reserveVO;

import com.eclipse.hotel.vo.room_infoVO;


@Controller

public class Membership_Controller {

	@Resource(name = "membership_service")
	private Membership_Service membership_service;
	
	@Autowired
	private PageAction pageaction;
	

	//회원 리스트
	@RequestMapping(value = "admin_membership_list")
	public String list(String field, String word, String pageNum, Model model){	
		//검색
		if(field==null) field="";
		if(word==null) word="";
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("field", field);
		hm.put("word", word);
		
		//회원수
		int memberCount = membership_service.count(hm);
		int todayCount = membership_service.todayCount();
		
		//페이징
		int pageSize = 15;		
		if(pageNum==null) pageNum="1";
		int currentPage = Integer.parseInt(pageNum);		
		int startRow = (currentPage-1)*pageSize+1; //시작
		int endRow = startRow+pageSize-1; //마지막
		if(endRow>memberCount) endRow=memberCount;
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
		String category = "";		
		
		List<memberVO> memberList = membership_service.list(hm);
		String pageHtml = pageaction.paging(memberCount, pageSize, currentPage, field, word, category);
	
		model.addAttribute("memberList", memberList);
		model.addAttribute("memberCount", memberCount);
		model.addAttribute("todayCount", todayCount);
		model.addAttribute("pageHtml", pageHtml);
		
		return "management/membership/membership_list";
	}
	
	//회원 상세보기
	@RequestMapping(value = "admin_membership_detail", method = RequestMethod.GET)
	public String detail(int m_num, Model model){
		memberVO member = membership_service.detail(m_num);
		List<room_reserveVO> reserveList = membership_service.reserveList(m_num);
		List<room_reserveVO> pre_reserveList = membership_service.preReserveList(m_num);
		
		model.addAttribute("member", member);
		model.addAttribute("reserveList", reserveList);
		model.addAttribute("pre_reserveList", pre_reserveList);
		
		return "management/membership/membership_detail";
	}
	
	//회원 수정 페이지
	@RequestMapping(value = "admin_membership_updatepage", method = RequestMethod.GET)
	public String updatePage(int m_num, Model model){
		memberVO member = membership_service.detail(m_num);
		
		model.addAttribute("member", member);
		
		return "management/membership/membership_update";
	}
	
	//회원 수정
	@RequestMapping(value = "admin_membership_update", method = RequestMethod.POST)
	public String update(memberVO member){		
		membership_service.update(member);
		
		return "redirect:admin_membership_detail?m_num="+member.getM_num();
	}
	
	//회원 삭제
	@RequestMapping(value = "admin_membership_delete", method = RequestMethod.GET)
	public String delete(int m_num){
		membership_service.delete(m_num);
		
		return "redirect:admin_membership_list";
	}
		
}
