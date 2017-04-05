//게시물 검색
function search() {
	$.ajax({
		type : "get",
		url : "guestboardlist",
		data : {
			"field" : $("#field").val(),
			"word" : $("#word").val(),
			"category" : $("#category").val()
		},

		success : function(data) {
			$("body").html(data);
		},
		error : function(e) {
			alert("error:" + e)
		},
		beforeSend : wordCheck
	});
}

//검색 조건
function wordCheck() {
	if ($("#word").val() == "") {
		alert("검색어를 입력하세요");
		$("#word").focus();
		return false;
	}
	return true;
}

//페이징
function getListData(pageNum, field, category, word) {
	word = (word == "") ? $("#word").val() : word;
	field = (field == "") ? $("#field").val() : field;
	$("body").load("guestboardlist", {
		"pageNum" : pageNum,
		"field" : field,
		"category" : category,
		"word" : word
	}, function(responseText) {
		$("body").html(responseText);
	});
}

//게시물 삭제
function btnDel() {
	if (confirm("정말 삭제할까요?")) {
		location.href = "guestboarddelete?b_num=" + $('#b_num').val()
				+ "&category=" + $("#category").val() + "&groups="
				+ $("#groups").val() + "&levels=" + $("#levels").val()
				+ "&steps=" + $("#steps").val();
	}

}

$(document).ready(function() {
	//게시물 등록 버튼	
	$("#btnRegister").click(function(){
		if($("#title").val()==""){   
			alert("제목을 입력하세요");
			return false;
		}
		if($("#password").val()==""){
			alert("비밀번호를 입력하세요");
			return false;
		}
		if($("#content").val()==""){
			alert("내용을 입력하세요");
			return false;
		}
		alert("와라");
		$("#frm").submit();
	});	
	
	// 답글 등록
	$("#btnReply").click(function() {
		if ($("#password").val() == "") {
			alert("비밀번호를 입력하세요");
			return false;
		}
		if ($("#content").val() == "") {
			alert("내용을 입력하세요");
			return false;
		}
		$("#frm").submit();
	});
	
	
}); 

