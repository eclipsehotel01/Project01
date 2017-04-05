package com.eclipse.hotel.admin.controller;


import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eclipse.hotel.admin.service.Management_Service;
import com.eclipse.hotel.util.PageAction_Room;
import com.eclipse.hotel.util.PageActionseul;
import com.eclipse.hotel.vo.CommandMap;
import com.eclipse.hotel.vo.paymentVO;

import com.eclipse.hotel.vo.room_infoVO;
import com.eclipse.hotel.vo.room_memoVO;
import com.eclipse.hotel.vo.room_priceVO;


@Controller

public class Management_Controller {
   
   @Autowired
   private PageActionseul page1;
   
   @Autowired
   private PageAction_Room page_r;
   
   @Resource(name = "management_service")
   private Management_Service management_service;
   


   //���Ǹ��
   @RequestMapping(value = "room_list")
   public String room_list(Model model, String pageNum, String rname){      
      if(rname==null) rname ="";
      int count = management_service.getRoomCount(rname);
      
      int pageSize = 3;
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
   
   //���ǻ󼼺���
   @RequestMapping(value = "room_detail")
   public String room_detail(Model model, int rnum){
      room_infoVO infoDetail = management_service.roomDetail(rnum);
      List<room_priceVO> pricelist = management_service.roomPrice();
      
      model.addAttribute("infoDetail", infoDetail);
      model.addAttribute("pricelist", pricelist);
      return "management/reserve/room_detail";
   }
   
   //������������
   @RequestMapping(value = "room_update")
   public String room_update(room_infoVO vo){
      management_service.roomUpdate(vo);
      return "redirect:room_list";
   }
   
   //���ǻ���
   @RequestMapping(value = "room_delete")
   public String room_delete(int rnum){
      management_service.roomDelete(rnum);
      return "redirect:room_list";
   }
   
   //���� ���������
   @RequestMapping(value = "room_insertOpen")
   public String room_insertOpen(Model model){
      List<room_priceVO> pricelist = management_service.roomPrice();
      model.addAttribute("pricelist", pricelist);
      return "management/reserve/room_insert";
   }
   
/*   //���ǵ��
   @RequestMapping(value = "room_insert")
   public String room_insert(room_infoVO vo){
      management_service.roomInsert(vo);
      return "redirect:room_list";
   }
*/   
   //���ǵ��
   @RequestMapping(value = "room_insert", method=RequestMethod.POST)
   public String room_insert(CommandMap commandMap,HttpServletRequest request) throws Exception{
	   Enumeration<?> enumeration = request.getParameterNames();
	   	String key = null;
		String[] values = null;
		while(enumeration.hasMoreElements()){
			key = (String) enumeration.nextElement();
			values = request.getParameterValues(key);
			if(values != null){
				commandMap.put(key, (values.length > 1) ? values:values[0] );
			}
		}
//		commandMap.put(img, img);
//		System.out.println("img : "+img);
		
		System.out.println("com : "+commandMap.getMap());      
	  management_service.roomInsert(commandMap.getMap(),request);           
      return "redirect:room_list";
   }

   //���ǿ�ݸ��
   @RequestMapping(value = "room_price")
   private String room_price(Model model){
      List<room_priceVO> pricelist = management_service.roomPrice();
      model.addAttribute("pricelist", pricelist);
      return "management/payment/room_price";
   }
   
   //���ǿ�ݼ���
   @RequestMapping(value = "price_update")
   public String price_update(room_priceVO vo){
      management_service.priceUpdate(vo);
      return "redirect:room_price";
   } 
   
   //�������
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
      hm.put("searchType", field);
      hm.put("word", word);
       
      List<paymentVO> paylist = management_service.payList(hm);
      String pageHtml = page1.paging(paycount, pageSize, currentPage, field, word);

      
      model.addAttribute("paycount", paycount);
      model.addAttribute("paytotal", paytotal);
      model.addAttribute("paylist", paylist);
      model.addAttribute("pageHtml", pageHtml);
      return "management/payment/pay_management";
   }

   // �������
   @RequestMapping(value = "pay_cancel")
   @ResponseBody
   public String pay_cancel(String p_num) { // �����ƴϰ� ������Ʈ!
      String msg = "";
      String[] arr = p_num.split(",");

      // ���� ��� ���� Ȯ��
      for (int i = 0; i < arr.length; i++) {
         if (management_service.cancelCheck(Integer.parseInt(arr[i])) == 1) {
            msg = "fail";
            break;
         } else
            msg = "success";
      }

      // ���õ� ���� ���
      for (int i = 0; i < arr.length; i++) {
         if (msg == "success") {
            management_service.payCancel(Integer.parseInt(arr[i]));
         }
      }
      return msg;
   }
   
   //���� Ÿ�� ���
   @RequestMapping("room_type")
   public String room_type(Model model){
	   List<room_memoVO> typelist = management_service.typelist();
	   
	   model.addAttribute("typelist", typelist);
	   return "management/reserve/room_type";
   }
   
   //���� Ÿ�� ���� ����
   @RequestMapping("rtype_update")
   public String rtype_update(room_memoVO memo){
	   management_service.rtype_update(memo);
	   return "redirect:room_type";
   }
}