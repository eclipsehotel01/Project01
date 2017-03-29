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
	
	//Ķ���� 
	@RequestMapping(value = "open_reserve_list", method = RequestMethod.GET)
	public String reserveList()
	{
		return "management/reserve/room_reserve_calendar";
	}
	
	//Ķ���� 
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
				obj.put("title", r.getRnum() +  "ȣ(" + r.getReservecode() + ")����");// URLEncoder.encode("ȣ(", "utf-8")URLEncoder.encode(") ����", "utf-8")
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
	
	//������Ȳ 
	@RequestMapping(value = "day_of_reserve_list", method = RequestMethod.GET)
	public String dayofreservelist(Model model,int reservecode,int m_num)
	{
		room_reserveVO selectlist= reserve_service.selectlist(reservecode);	
		List<memberVO> rmember= reserve_service.rmember(m_num);

		model.addAttribute("selectlist",selectlist);
		model.addAttribute("rmember",rmember);
		return "management/reserve/room_reserve_day";
	}
	
	//���� ����
	@RequestMapping(value = "del_reserve", method = RequestMethod.GET)
	public String deletereservation(String reservecode){
		
		reserve_service.delreserve(reservecode);
		
		return "management/reserve/room_reserve_calendar";
	}
	
	//���� ���� ������
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
	
	//ȣ������ 
	@RequestMapping(value="roomInfo")
	@ResponseBody
	public String roomInfo(int rnum){
		System.out.println("���ȣ :" + rnum);
		room_infoVO info = reserve_service.roomInfo(rnum);	
				System.out.println("�����ο� : " + info);
		return info.getStandperson()+"/"+info.getMax_person();
	}
	
	//���� ����
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(room_reserveVO reserve,String paytype)
	{
		paytype=reserve_service.searchtype(reserve.getRnum());
		// ���� ����� ����
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
		//�� �����ϼ� ���
		String date3=reserve.getCheck_out();
		String[] array2=date3.split("/");
		String date4 = "";		
		for(int i=1; i<array2.length; i++){
			date4 += array2[i];
		}
		
		int checkout=Integer.parseInt(date4);
		
		//�� �����ϼ�
		int dayofreserve=checkout-intdate;
		//�̿���
		int pay=reserve.getR_price();
		//�����ο�
		int person=reserve.getPerson();
		//�����ο�
		int room=reserve.getRnum();
		int standp=reserve_service.standperson(room);
		//�߰��ο�
		int extraperson = 0;
		if(person>standp){
			extraperson = person-standp;
		}
		//�߰����
		int extraTot = 0;
		String[] arr =  reserve.getExtracode().split(",");
      
		//�߰� �ݾ� ���ϱ�
		for(int i=0; i<arr.length;i++){
    	 if(arr[i]!="����"){
    		 if(extraperson!=0){
    			 extraTot += reserve_service.getExtraTotal(arr[i])*extraperson;
    		 }else{
    			 extraTot += reserve_service.getExtraTotal(arr[i]);
    		 }
    	 }
      }
      reserve.setExtracharge(extraTot);
		//�߰����
		int extra=reserve.getExtracharge();
		
		reserve.setP_price(((pay+((extraperson)*10000))*dayofreserve)+extra);
	
		reserve_service.update(reserve);
		return "management/reserve/room_reserve_calendar";
	}
		
	
}
