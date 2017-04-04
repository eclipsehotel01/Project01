$(document).ready(function() {
	//코멘트 리스트
	$("#comment_area").load("commentList?b_num=" + $("#b_num").val(),
			function(data) {
				$("#comment_area").html(data);
			}
	);

	// 코멘트 등록
	$("#btnComment").click(function() {
		$.ajax({
			type : "post",
			url : "commentInsert",
			data : {
				"b_num" : $("#b_num").val(),
				"memo" : $("#memo").val(),
				"id" : $("#id").val()
			},
			success : function(data) {
				$("#comment_area").html(data);
				$("#memo").val("");
			}
		});
	});
	
	//코멘트 삭제
	function commentDel(c_num){	
		$.ajax({
			type:"post",
			url:"cdelete?c_num="+c_num,
			success:function(data){
				$("#aa").html(data);			
			}
		}); 		
	};
	
});

// 우편번호 - 검색 페이지
function btnZipcode(){
	window.open("common_zipcode","","width=1000 height=300 scrollbars=yes");
}

//우편번호 - 검색(버튼)
function btnZipcodeSend(){
	sentIt();
}

//우편번호 - 검색(엔터)
function zipcodeEnter(){
	if (window.event.keyCode == 13) {
		sentIt();
	}
}

//우편번호 - 검색
function sendIt(){
	$.post("common_zipcode", 
		{"dong":$("#dong").val()}, 
		function(data){	
			$("#zipcodeArea").html(data);
		}
	); 
}



$(document).ready(function(){	
	
	
	//2-4
	$("#area").on("click","tr",function(){	//on이란 함수 실행 -> 클릭하면 tr에 발생
		var address=$("td:eq(1)", this).text()+" "+	//우편번호는 zipcode에 , 나머지 td영역은 addr에 담을 것이다.(여기서는 address변수) 몇번째를 알려주는 함수 eq, 첫째교재 475 : text, html, val 중 여기서는 text
					$("td:eq(2)", this).text()+" "+
					$("td:eq(3)", this).text()+" "+
					$("td:eq(4)", this).text();
	
	$(opener.document).find("#zipcode").val($("td:eq(0)", this).text());	//1addrinsert의 윈도우 오픈(46라인)->오프너 / 교재 475 : 여기서는 val(input태그 안이니까)
	$(opener.document).find("#eaddr").val(address);
	self.close();	//자동닫기
	})
});

