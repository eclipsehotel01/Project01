<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- S : ASIDE -->
<aside>
	<div id="admin-aside">
		<ul>
			<li class="aside-title">회원관리</li>				
				<div id="aside-member" class="aside-content">
					<ul>
						<a href="admin_membership_list"><li>전체회원관리</li></a>						
					</ul>
				</div>
			<hr>
			<li class="aside-title">게시물관리</li>
				<div id="aside-board" class="aside-content">
					<ul>
						<a href="managementboardlist?category=공지사항"><li>공지사항</li></a>
						<a href="managementboardlist?category=QnA"><li>QnA</li></a>
						<a href="managementboardlist?category=환불신청게시판"><li>환불신청게시판</li></a>
						<a href="managementboardlist?category=자유게시판"><li>자유게시판</li></a> 
						<a href="managementboardlist?category=후기게시판"><li>후기게시판</li></a>
					</ul> 
				</div>
			<hr>
			<li class="aside-title">객실예약관리</li>
				<div id="aside-reserv" class="aside-content">
					<ul>
						<a href="room_management"><li>객실 등록/관리</li></a>
						<a href="open_reserve_list"><li>예약관리</li></a>
						<a href=""><li>할인이벤트</li>	</a>					
					</ul>
				</div>
			<hr>
			<li class="aside-title">결제관리</li>
				<div id="aside-pay" class="aside-content">
					<ul>
						<a href="pay_management"><li>결제내역관리</li></a>
						<a href="room_price"><li>객실요금관리</li></a>					
					</ul>
				</div>
		</ul>
	</div>
</aside>
<!-- E : ASIEDE -->