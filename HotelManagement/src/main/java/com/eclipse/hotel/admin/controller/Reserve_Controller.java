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
import com.eclipse.hotel.vo.extra_chargeVO;
import com.eclipse.hotel.vo.memberVO;
import com.eclipse.hotel.vo.room_infoVO;
import com.eclipse.hotel.vo.room_reserveVO;

@Controller
public class Reserve_Controller {

	
	@Resource(name = "reserve_service")
	private Reserve_Service reserve_service;
	
	//캘린더 
	@RequestMapping(value = "open_reserve_list", method = RequestMethod.GET)
	public String reserveList()
	{
		return "management/reserve/room_reserve_calendar";
	}
	
	//캘린더 
	@RequestMapping(value = "admin_reserve_list", method = RequestMethod.GET,produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String list(Model model) throws UnsupportedEncodingException {		
		List<room_reserveVO> reserveList = reserve_service.list();		
		
		//parsing(json)
		JSONArray jarr = new JSONArray();
		JSONObject obj = null;
		for(room_reserveVO r : reserveList){
			obj = new JSONObject();
			try {				
				obj.put("title", r.getRnum() +  "호(" + r.getReservecode() + ")예약");// URLEncoder.encode("호(", "utf-8")URLEncoder.encode(") 예약", "utf-8")
				obj.put("start", r.getCheck_in());
				obj.put("end", r.getCheck_out());
				obj.put("url", "day_of_reserve_list?reservecode=" + r.getReservecode()+"&m_num="+r.getM_num());
				
				jarr.put(obj);
				System.out.println(jarr);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}	
		
		return jarr.toString();
		
	}
	
	//예약현황 
	@RequestMapping(value = "day_of_reserve_list", method = RequestMethod.GET)
	public String dayofreservelist(Model model,int reservecode,int m_num)
	{
		room_reserveVO selectlist= reserve_service.selectlist(reservecode);	
		List<memberVO> rmember= reserve_service.rmember(m_num);

		model.addAttribute("selectlist",selectlist);
		model.addAttribute("rmember",rmember);
		return "management/reserve/room_reserve_day";
	}
	
	//예약 삭제
	@RequestMapping(value = "del_reserve", method = RequestMethod.GET)
	public String deletereservation(String reservecode){
		
		reserve_service.delreserve(reservecode);
		
		return "management/reserve/room_reserve_calendar";
	}
	
	//예약 수정 페이지
	@RequestMapping(value = "updatereserve", method = RequestMethod.GET)
	public String updatereserve(Model model,int reservecode,int m_num,int rnum)
	{
		room_reserveVO selectlist= reserve_service.selectlist(reservecode);	
		List<memberVO> rmember= reserve_service.rmember(m_num);
		List<room_infoVO> roomnum = reserve_service.listRnum();
		
		String paytype=reserve_service.searchtype(rnum);
		
		model.addAttribute("selectlist",selectlist);
		model.addAttribute("rmember",rmember);
		model.addAttribute("paytype",paytype);
		model.addAttribute("roomnum", roomnum);
		return "management/reserve/room_reserve_day_update";
	}
	
	//호실정보 
	@RequestMapping(value="roomInfo")
	@ResponseBody
	public String roomInfo(int rnum){
		System.out.println("방번호 :" + rnum);
		room_infoVO info = reserve_service.roomInfo(rnum);	
				System.out.println("기준인원 : " + info);
		return info.getStandperson()+"/"+info.getMax_person();
	}
	
	//예약 수정
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(room_reserveVO reserve,String paytype)
	{
		paytype=reserve_service.searchtype(reserve.getRnum());
		// 시즌 비시즌 구분
		String date=reserve.getCheck_in();

		String[] array=date.split("/");
		String date2 = "";
		for(int i=1; i<array.length; i++){
			date2 += array[i];
		}
		
		int intdate=Integer.parseInt(date2);
		
		if((intdate>701 && intdate<831) || (intdate>1101 && intdate <1231))
		{
			int price=reserve_service.getpay(paytype);
			reserve.setR_price(price);		
		}
		else
		{
			int price=reserve_service.getnonpay(paytype);
			reserve.setR_price(price);	
		}
		//총 숙박일수 계산
		String date3=reserve.getCheck_out();
		String[] array2=date3.split("/");
		String date4 = "";		
		for(int i=1; i<array2.length; i++){
			date4 += array2[i];
		}
		
		int checkout=Integer.parseInt(date4);
		
		//총 숙박일수
		int dayofreserve=checkout-intdate;
		//이용요금
		int pay=reserve.getR_price();
		//예약인원
		int person=reserve.getPerson();
		//기준인원
		int room=reserve.getRnum();
		int standp=reserve_service.standperson(room);
		//추가인원
		int extraperson = 0;
		if(person>standp){
			extraperson = person-standp;
		}
		//추가요금
		int extraTot = 0;
		String[] arr =  reserve.getExtracode().split(",");
      
		//추가 금액 구하기
		for(int i=0; i<arr.length;i++){
    	 if(arr[i]!="없음"){
    		 if(extraperson!=0){
    			 extraTot += reserve_service.getExtraTotal(arr[i])*extraperson;
    		 }else{
    			 extraTot += reserve_service.getExtraTotal(arr[i]);
    		 }
    	 }
      }
      reserve.setExtracharge(extraTot);
		//추가요금
		int extra=reserve.getExtracharge();
		
		reserve.setP_price(((pay+((extraperson)*10000))*dayofreserve)+extra);
	
		reserve_service.update(reserve);
		return "management/reserve/room_reserve_calendar";
	}
		
	
}
