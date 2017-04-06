//페이지 변경 시 객실 정보 검색
 $(document).ready(function(){
	 detailGo(0);
}); 

//객실 정보 검색
function detailGo(i){		
	$.ajax({
		type:"GET",
		url:"room_infoDetail",
		data:{"rname" : $("#rname"+i).val(), "rtype" : $("#rtype"+i).val()},
		success:function(data){
			parse(data);
		}
	});
}

//parsing data
function parse(data){
	data = $.parseJSON(data);
	var str = "";
	
	//이름&사진
	str += "<div>";
	str += "<h3>"+ data.rname + " " + data.rtype +" ROOM</h3>";
	str += "<ul><li><img src='" + data.img +"'/></li></ul>";
	str += "</div>";
	
	//설명
	str += "<div>";
	str += "<h4>" + data.m_memo + "</h4>";
	str += data.memo;
	str += "</div>";
	
	//상세정보
	str += "<div>";
	str += "<ul>";
	
	str += "<li><dl>";
	str += "<dt>위치</dt>";
	str += "<dd>" + data.rnum + "층</dd>";
	str += "</dl></li>";
	
	str += "<li><dl>";
	str += "<dt>침대타입</dt>";
	str += "<dd>" + data.rtype + "</dd>";
	str += "</dl></li>";
	
	str += "<li><dl>";
	str += "<dt>객실크기</dt>";
	str += "<dd>" + data.rsize + "m<sup>2</sup></dd>";
	str += "</dl></li>";
	
	str += "<li><dl>";
	str += "<dt>가격</dt>";
	str += "<dd>성수기:" + data.season + "원 / 비성수기:" + data.nonseason +"원</dd>";
	str += "</dl></li>";
	
	str += "</ul>";
	str += "</div>";
	
	$("#detail").html(str);
 }