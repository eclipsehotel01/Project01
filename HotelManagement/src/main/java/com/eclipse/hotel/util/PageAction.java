package com.eclipse.hotel.util;

import org.springframework.stereotype.Component;

@Component
public class PageAction {
public String paging(int count,int pageSize,int currentPage,String field,String word,String category){
		
		int pageCount =count/pageSize+(count%pageSize==0?0:1);//총페이지수
		int pageBlock =3; //[이전] 페이지 블럭 [다음]
		int startPage= ((currentPage-1)/pageBlock)*pageBlock+1;
		int endPage=startPage+pageBlock-1;
		if(endPage>pageCount) endPage=pageCount;
		
		StringBuffer sb=new StringBuffer();
		if(count>0){
			//이전
			if(startPage>pageBlock){
				//sb.append("<a href='member_list.m?pageNum=1'>[이전]</a>");
				sb.append("<a href=javascript:getListData(");
				sb.append((startPage-pageBlock));
				sb.append(",'"+field);
				sb.append("','"+category);
				sb.append("','"+word+"')");
				sb.append(">[이전]</a>");
			}
			
			//페이지 수
			for(int i=startPage; i<=endPage;i++){
				if(i==currentPage){
					sb.append("["+i+"]");
				}else{
				/*sb.append("<a href=javascript:");
				sb.append(url);
				sb.append("(");*/
				sb.append("<a href=javascript:getListData(");	
				sb.append(i);
				sb.append(",'"+field);
				sb.append("','"+category);
				sb.append("','"+word+"')");
				sb.append(">["+i+"]</a>");			
				}
	 		} 
			//다음
			if(endPage<pageCount){
				/*sb.append("<a href=javascript:");
				sb.append(url);
				sb.append("(");*/
				sb.append("<a href=javascript:getListData(");
				sb.append("pageNum="+(startPage+pageBlock));
				sb.append(",'"+field);
				sb.append("','"+category); 
				sb.append("','"+word+"')");
				sb.append(">[다음]</a>");
			}
		}
		return sb.toString();
	}
}
