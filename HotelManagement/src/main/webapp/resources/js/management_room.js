$(document).ready(function() {
	//유형선택
	$("#roomType").change(function() {
		$.get("room_list", {
			"rname" : $("#roomType").val()
		}, function(data) {
			$("body").html(data);
			});
		});
	});
	
	//paging
	function getListData(pageNum, rname) {
		$("body").load("room_list", {
		"pageNum" : pageNum,
		"rname" : rname
	}, function(responseText) {
		$("body").html(responseText);
		});
	}

$(document).ready(function(){
	//객실 등록 - 빈값확인
	$("#insertBtn").click(function(){
		if($("#rnum").val()==""){
			alert("호실을 입력하세요"); 
			return false;
		}if($("#rsize").val()==""){	
			alert("객실 면적을 입력하세요");
			return false;
		}if($("#rname").val()==""){	
			alert("객실 유형을 선택하세요");
			return false;
		}if($("#rtype").val()==""){	
			alert("침대 유형을 선택하세요");
			return false;
		}if($("#standperson").val()==""){	
			alert("기준 인원을 입력하세요");
			return false;
		}if($("#max_person").val()==""){	
			alert("최대 인원을 입력하세요");
			return false;
		}if($("#img").val()==""){	
			alert("이미지를 추가하세요");
			return false;
		}if($("#price").val()==""){	
			alert("요금을 선택하세요");
			return false;
		}else{
			insert.submit();
		}
	});
	
	//객실 수정 - 빈값확인	
	$("#updateBtn").click(function(){
		alert("여기로?");
		if($("#rnum").val()==""){
			alert("호실을 입력하세요"); 
			return false;
		}if($("#rsize").val()==""){	
			alert("객실 면적을 입력하세요");
			return false;
		}if($("#rname").val()==""){	
			alert("객실 유형을 선택하세요");
			return false;
		}if($("#rtype").val()==""){	
			alert("침대 유형을 선택하세요");
			return false;
		}if($("#standperson").val()==""){	
			alert("기준 인원을 입력하세요");
			return false;
		}if($("#max_person").val()==""){	
			alert("최대 인원을 입력하세요");
			return false;
		}if($("#price").val()==""){	
			alert("요금을 선택하세요");
			return false;
		}$("#update").submit();
	});
});

//객실 요금 수정
function update(price){
	if($("#season").val()==""){
	     alert("금액을 입력하세요"); 
	     return false;
	}else if($("#nonseason").val()==""){   
	     alert("금액을 입력하세요");
	     return false;
	}else if(price=="A"){
	   $.get("price_update",
	           {"price" : "A", "season" : $("#season0").val(), "nonseason" : $("#nonseason0").val() },
	           function(data){
	        	   alert(data);
	           }
	      );
	}else if(price=="B"){
	   $.get("price_update",
	           {"price" : "B", "season" : $("#season1").val(), "nonseason" : $("#nonseason1").val() },
	           function(data){
	        	   alert(data);
	           }
	      );
	}else if(price=="C"){
	   $.get("price_update",
	           {"price" : "C", "season" : $("#season2").val(), "nonseason" : $("#nonseason2").val() },
	           function(data){
	        	   alert(data);
	           }
	      );
	}else if(price=="D"){
	   $.get("price_update",
	           {"price" : "D", "season" : $("#season3").val(), "nonseason" : $("#nonseason3").val() },
	           function(data){
	        	   alert(data);
	           }
	      );
	}else if(price=="E"){
	   $.get("price_update",
	           {"price" : "E", "season" : $("#season4").val(), "nonseason" : $("#nonseason4").val() },
	           function(data){
	        	   alert(data);
	           }
	      );
	}else if(price=="F"){
	   $.get("price_update",
	           {"price" : "F", "season" : $("#season5").val(), "nonseason" : $("#nonseason5").val() },
	           function(data){
	        	   alert(data);
	           }
	      );
	}else{
	   alert("fail");
	}	 
}