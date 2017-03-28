package com.eclipse.hotel.admin.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eclipse.hotel.admin.service.Board_Service;
import com.eclipse.hotel.util.PageAction;
import com.eclipse.hotel.vo.boardVO;

@Controller
public class Board_Controller {
	
	@Resource(name = "board_service")
	private Board_Service board_service;
	@Autowired
	
	PageAction pageaction;
	
	//게시판등록
	@RequestMapping(value="managementboardinsert",method=RequestMethod.POST)	
	public String managementboardinsert(boardVO vo) throws UnsupportedEncodingException{
		System.out.println("cate : "+vo.getCategory());
		board_service.managementboardinsert(vo); 
		String category = URLEncoder.encode(vo.getCategory(), "utf-8");
		return "redirect:managementboardlist?category="+category;   
	}
	//게시판전체보기
	@RequestMapping(value="managementboardlist")
	public String managementboardlist(String field,String word,String pageNum,String category,Model model){
					
				if(word==null)word="";
				if(field==null)field="";
				HashMap<String,Object> hm=new HashMap<String, Object>();
				
				hm.put("field", field);
				hm.put("word", word);
				hm.put("category", category);
				
				//PageAction pageaction=new PageAction();
				int count=board_service.getSearchCount(hm);
				System.out.println("sss : "+category);
				int pageSize=10; 
				if(pageNum==null) pageNum="1";
				int currentPage=Integer.parseInt(pageNum);
				int startRow=(currentPage-1)*pageSize+1;
				int endRow=startRow+pageSize-1;
				if(endRow>count) endRow=count;		
				
//				String url = "getListData";
				
				hm.put("startRow", startRow); 
				hm.put("endRow", endRow);
				List managementboardlist=board_service.getSearchList(hm);
				String pageHtml=pageaction.paging(count, pageSize, currentPage,field,word,category);	
				model.addAttribute("category",category); 
				model.addAttribute("count",count);
				model.addAttribute("managementboardlist",managementboardlist);
				model.addAttribute("pageHtml",pageHtml);
		
		return "management/board/managementboardlist";
	}
	//게시판 상세보기
	@RequestMapping("managementboarddetail")
	public String managementboarddetail(int b_num,Model model){
		board_service.count(b_num);
		boardVO board=board_service.managementboarddetail(b_num);
		model.addAttribute("board",board);
		return "management/board/managementboarddetail";
	}
	
	//게시판수정시 비밀번호 체크
	@RequestMapping(value="pwdCheck12")
	@ResponseBody
	public String pwdCheck12(int b_num,String password){
		System.out.println(b_num +":" + password);
		String pwd=board_service.boardCheck(b_num);
		String chk="false";
		if(pwd.equals(password)){
			chk="true";					
		}
		return chk;
	}
	
	//게시판수정시 jsp로 이동
	@RequestMapping("pwdCheck11")
	public String pwdCheck11(Model model,int b_num,String title,String content,String category){
		model.addAttribute("b_num",b_num);
		model.addAttribute("title",title);
		model.addAttribute("content",content);
		model.addAttribute("category",category);
		return "management/board/managementboardupdate";
	}
	
	//게시판수정
	@RequestMapping(value="managementboardUpdate",method=RequestMethod.POST)
	public String managementboardupdate(boardVO vo){
		board_service.managementboardupdate(vo);
		return "redirect:managementboardlist"; 
	}
	//게시판삭제
	@RequestMapping(value="managementboarddelete")
	public String managementboarddelete(int b_num,String category,int levels,int steps,int groups) throws UnsupportedEncodingException{
		HashMap<String, Object> del=new HashMap<String, Object>();
		del.put("groups", groups); 
		del.put("levels", levels);
		del.put("steps", steps);
		del.put("b_num", b_num);

		board_service.managementboarddelete(del);
		System.out.println(category);  
		String category1 = URLEncoder.encode(category, "utf-8");
		return "redirect:managementboardlist?category="+category1; 
	}
/*	//
	@RequestMapping("pwdCheck")
	public String pwdCheck(Model model, int b_num){
		model.addAttribute("b_num", b_num);
		return "management/board/managementboarddelete";
	}	
*/		

	//댓글리스트
	@RequestMapping("commentList")
	public String commentList(Model model,int b_num){
		List commentlist=board_service.getList(b_num);
		model.addAttribute("commentlist",commentlist);
		return "management/board/commentlist"; 
	}
	//댓글등록
	@RequestMapping(value="commentInsert")
	public String insert(boardVO vo){
		board_service.commentInsert(vo);
		return "redirect:commentList?b_num="+vo.getB_num(); 
	}
	//댓글삭제
	@RequestMapping("cdelete")
	public String mydelete(int c_num){
		board_service.mydelete(c_num);
		return "management/board/managementboarddetail";
	}
	
	//답글등록폼으로이동
	@RequestMapping("boardReply")
	public String replyinsert(int b_num,Model model){
		boardVO board=board_service.detail(b_num);
		model.addAttribute("board",board);
		return "management/board/managementboardreply";
	}
	
	//답글등록
	@RequestMapping("boardReply1")
	public String replyinsert1(boardVO vo) throws UnsupportedEncodingException{ 
		board_service.update1(vo);
		board_service.replyinsert(vo);
		String category = URLEncoder.encode(vo.getCategory(), "utf-8");
		return "redirect:managementboardlist?category="+category;
	}
}
