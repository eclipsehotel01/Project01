package com.eclipse.hotel.guest.controller;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eclipse.hotel.guest.service.Room_Service;
import com.eclipse.hotel.vo.room_infoVO;
import com.eclipse.hotel.vo.room_reserveVO;


@Controller
public class Room_Controller {
   
   @Resource(name = "room_service")
   private Room_Service room_service;
   
   //객실목록
   @RequestMapping("room_infoList")
   public String room_list(Model model){
	   List<room_infoVO> room_infoList = room_service.roomInfoList();
	   
	   model.addAttribute("room_infoList", room_infoList);
	   return "guest/room/room_infoList";
   }
   
   //객실 상세보기 페이지
   @RequestMapping("room_infoTitle")
   public String room_infoDetail(Model model, String rname){
	   System.out.println("rname : " + rname);
	   List<room_infoVO> room_infoTitle = room_service.room_infoTitle(rname);
	   
	   model.addAttribute("room_infoTitle", room_infoTitle);
	   return "guest/room/room_infoDetail";
   }
   
   //객실 상세보기
   @RequestMapping(value="room_infoDetail", method=RequestMethod.GET)
   @ResponseBody
   public String room_infoDetail(Model model, String rname, String rtype){
	   HashMap<String, Object> hm = new HashMap<String, Object>();
	   hm.put("rname", rname);
	   hm.put("rtype", rtype);
	   
	   List<room_infoVO> room_infoDetail = room_service.room_infoDetail(hm);
	  
		JSONObject obj = null;
		for(room_infoVO i : room_infoDetail){		
			obj = new JSONObject();
			
			try {
				obj.put("rnum", i.getRnum());
				obj.put("rname", i.getRname());
				obj.put("rsize", i.getRsize());
				obj.put("rtype", i.getRtype());
				obj.put("standperson", i.getStandperson());
				obj.put("max_person", i.getMax_person());
				obj.put("img", i.getImg());
				obj.put("price", i.getPrice());
				obj.put("memo", i.getMemo());
				obj.put("m_memo", i.getM_memo());
				obj.put("season", i.getSeason());
				obj.put("nonseason", i.getNonseason());
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return obj.toString();
   }
   
   
}