package com.eclipse.hotel.admin.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eclipse.hotel.admin.service.Reserve_Service;
import com.eclipse.hotel.vo.room_reserveVO;

@Controller
public class Reserve_Controller {

	@Resource(name = "reserve_service")
	private Reserve_Service reserve_service;
	
	//예약 리스트
	@RequestMapping(value = "admin_reserve_list", method = RequestMethod.GET)
	@ResponseBody
	public String list(Model model) {		
		System.out.println("admin_reserve_list");
		List<room_reserveVO> reserveList = reserve_service.list();		
		
		//parsing(json)
		JSONArray jarr = new JSONArray();
		JSONObject obj = null;
		for(room_reserveVO r : reserveList){
			obj = new JSONObject();
			try {				
				obj.put("title", r.getRnum() +  "호(" + r.getReservecode() + ") 예약");
				obj.put("start", r.getCheck_in());
				obj.put("end", r.getCheck_out());
				jarr.put(obj);
			//	System.out.println(jarr);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}	
		
		return jarr.toString();			
	}
}
