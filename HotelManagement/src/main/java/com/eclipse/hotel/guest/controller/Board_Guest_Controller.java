package com.eclipse.hotel.guest.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.SessionScope;

import com.eclipse.hotel.guest.service.Board_Guest_Service;
import com.eclipse.hotel.util.PageAction;
import com.eclipse.hotel.vo.boardVO;


@Controller
public class Board_Guest_Controller {
	@Resource(name="board_guest_service")
	private Board_Guest_Service board_guest_service;
	
	@Autowired
	PageAction pageaction;
	
	//게시판등록폼
	@RequestMapping("guestboardregister")
	private String guestboardregister(String category,Model model){
		model.addAttribute("category",category);
		return "guest/board/guestboardinsert";
	} 
	
	//게시판등록
	@RequestMapping(value="guestboardinsert",method=RequestMethod.GET)
	private String guestboardinsert(boardVO vo,HttpSession session) throws UnsupportedEncodingException{
		String category = URLEncoder.encode(vo.getCategory(), "utf-8");
		int mnum = Integer.parseInt(session.getAttribute("loginNO").toString());
		vo.setM_num(mnum);
		board_guest_service.guestboardinsert(vo);
		return "redirect:guestboardlist?category="+category;
	}
	
	//게시판전체보기
	@RequestMapping(value="guestboardlist")
	public String guestboardlist(String field,String word,String pageNum,String category,Model model){
					
				if(word==null)word="";
				if(field==null)field="";
				HashMap<String,Object> hm=new HashMap<String, Object>();
				
				hm.put("field", field);
				hm.put("word", word);
				hm.put("category", category);
				
				//PageAction pageaction=new PageAction();
				int count=board_guest_service.getSearchCount(hm);
				int pageSize=15; 
				if(pageNum==null) pageNum="1";
				int currentPage=Integer.parseInt(pageNum);
				int startRow=(currentPage-1)*pageSize+1;
				int endRow=startRow+pageSize-1;
				if(endRow>count) endRow=count;		
				
//					String url = "getListData";
				
				hm.put("startRow", startRow); 
				hm.put("endRow", endRow);
				List guestboardlist=board_guest_service.getSearchList(hm);
				String pageHtml=pageaction.paging(count, pageSize, currentPage,field,word,category);	
				model.addAttribute("category",category); 
				model.addAttribute("count",count);
				model.addAttribute("guestboardlist",guestboardlist);
				model.addAttribute("pageHtml",pageHtml);			
		return "guest/board/guestboardlist";
	}
	//게시판 상세보기
	@RequestMapping("guestboarddetail")
	public String guestboarddetail(int b_num,Model model){
		board_guest_service.count(b_num);
		boardVO board=board_guest_service.guestboarddetail(b_num);
		model.addAttribute("board",board);
		return "guest/board/guestboarddetail";
	}
	//게시판수정시 비밀번호 체크
	@RequestMapping(value="guestpwdCheck12")
	@ResponseBody
	public String pwdCheck12(int b_num,String password){
		String pwd=board_guest_service.boardCheck(b_num);
		String chk="false";
		if(pwd.equals(password)){
			chk="true";					
		}
		return chk;
	}
	
	//게시판수정시 jsp로 이동
	@RequestMapping("guestpwdCheck11")
	public String pwdCheck11(Model model,int b_num,String title,String content,String category){
		model.addAttribute("b_num",b_num);
		model.addAttribute("title",title);
		model.addAttribute("content",content);
		model.addAttribute("category",category);
		return "guest/board/guestboardupdate";
	}
	
	//게시판수정
	@RequestMapping(value="guestboardUpdate",method=RequestMethod.POST)
	public String guestboardupdate(boardVO vo){
		board_guest_service.guestboardupdate(vo);
		return "redirect:guestboardlist"; 
	}
	
	//게시판삭제시 jsp로 이동
	@RequestMapping("guestpwdCheck22")
	public String pwdCheck22(Model model,int b_num,int levels,int groups,int steps,String category){
		model.addAttribute("b_num",b_num);
		model.addAttribute("levels",levels);
		model.addAttribute("groups",groups);
		model.addAttribute("steps",steps);
		model.addAttribute("category",category);
		return "guest/board/guestboarddelete";
	}
	//게시판삭제
	@RequestMapping(value="guestboarddelete")
	public String guestboarddelete(int b_num,String category,int levels,int steps,int groups) throws UnsupportedEncodingException{
		
		HashMap<String, Object> del=new HashMap<String, Object>();
		del.put("groups", groups); 
		del.put("levels", levels);
		del.put("steps", steps);
		del.put("b_num", b_num);
		
		board_guest_service.guestboarddelete(del);
		
		String category1 = URLEncoder.encode(category, "utf-8");
		
		return "redirect:guestboardlist?category="+category1; 
	}
/*	//
	@RequestMapping("pwdCheck")
	public String pwdCheck(Model model, int b_num){
		model.addAttribute("b_num", b_num);
		return "guest/board/guestboarddelete";
	}	
*/		

	//댓글리스트
	@RequestMapping("guestcommentList")
	public String commentList(Model model,int b_num){
		
		List commentlist=board_guest_service.getList(b_num);
		model.addAttribute("commentlist",commentlist);
		return "common/commentlist"; 
	}
	//댓글등록
	@RequestMapping(value="guestcommentInsert")
	public String insert(boardVO vo,HttpSession session){
		int mnum = Integer.parseInt(session.getAttribute("loginNO").toString());
		vo.setM_num(mnum);
		board_guest_service.commentInsert(vo);
		return "redirect:commentList?b_num="+vo.getB_num(); 
	}
	//댓글삭제
	@RequestMapping("guestcdelete")
	public String mydelete(int c_num){
		board_guest_service.mydelete(c_num);
		return "guest/board/guestboarddetail";
	}
	
	//답글등록폼으로이동
	@RequestMapping("guestboardReply")
	public String replyinsert(int b_num,Model model){
		boardVO board=board_guest_service.detail(b_num);
		model.addAttribute("board",board);
		return "guest/board/guestboardreply";
	}
	
	//답글등록
	@RequestMapping("guestboardReply1")
	public String replyinsert1(boardVO vo,HttpSession session) throws UnsupportedEncodingException{ 
		int mnum = Integer.parseInt(session.getAttribute("loginNO").toString());
		vo.setM_num(mnum);
		board_guest_service.update1(vo);
		board_guest_service.replyinsert(vo);
		String category = URLEncoder.encode(vo.getCategory(), "utf-8");
		return "redirect:guestboardlist?category="+category;
	}
}
