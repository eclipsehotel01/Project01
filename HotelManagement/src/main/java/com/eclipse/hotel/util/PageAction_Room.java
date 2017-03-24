package com.eclipse.hotel.util;

import org.springframework.stereotype.Component;

@Component
public class PageAction_Room {
public String paging(int count,int pageSize,int currentPage,String rname){
      
      int pageCount =count/pageSize+(count%pageSize==0?0:1);//����������
      int pageBlock =3; //[����] ������ �� [����]
      int startPage= ((currentPage-1)/pageBlock)*pageBlock+1;
      int endPage=startPage+pageBlock-1;
      if(endPage>pageCount) endPage=pageCount;
      
      StringBuffer sb=new StringBuffer();
      if(count>0){
         //����
         if(startPage>pageBlock){
            //sb.append("<a href='member_list.m?pageNum=1'>[����]</a>");
            sb.append("<a href=javascript:getListData(");
            sb.append((startPage-pageBlock));
            sb.append(",'" + rname + "')");
            sb.append(">[����]</a>");
         }
         
         //������ ��
         for(int i=startPage; i<=endPage;i++){
            if(i==currentPage){
               sb.append("["+i+"]");
            }else{
            sb.append("<a href=javascript:getListData(");
            sb.append(i);
            sb.append(",'" + rname + "')");
            sb.append(">["+i+"]</a>");         
            }
          } 
         //����
         if(endPage<pageCount){
            sb.append("<a href=javascript:getListData(");
            sb.append("pageNum="+(startPage+pageBlock));
            sb.append(",'" + rname + "')");
            sb.append(">[����]</a>");
         }
      }
      return sb.toString();
   }
}