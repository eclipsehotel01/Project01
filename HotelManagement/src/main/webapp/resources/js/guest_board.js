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
		$("#replyfrm").submit();
	});
	
}); 

//비밀번호 확인창
function checkUpdate(){
	window.open(
			"guestpwdCheck11?b_num="+$('#b_num').val()+"&title="
			+ $("#title").val() + "&content="
			+ $("#content").val()
			+ "&category="
			+ $("#category").val(), "",
	"width=350 height=200 scrollbars=yes");
}
//삭제비밀번호창
function checkDelete(){
	window.open(
			"guestpwdCheck22?b_num="+$('#b_num').val()
			+ "&groups="+ $("#groups").val() 
			+ "&levels="+ $("#levels").val()
			+ "&steps="+ $("#steps").val()
			+ "&category="+ $("#category").val(), "",
	"width=350 height=200 scrollbars=yes");
}

//게시판 수정비밀번호 확인
function passCheck() {
	$.ajax({
		type : "post",
		url : "guestpwdCheck12",
		data : {
			"password" : $("input[name=password]").val(),
			"b_num" : $("#b_num").val()
		},

		success : function(data) {
			if (data == "false") {
				alert("비밀번호가 일치하지 않습니다");
				$("input[name=password]").val("");
			} else {
				$.post("guestboardUpdate", {
					"b_num" : $("#b_num").val(),
					"content" : $("#content").val(),
					"title" : $("#title").val()
				});
				opener.location.href = "guestboardlist?category="
						+ $("#category").val();
				self.close();
			}
		},
		beforeSend : showRequest,
		error : function(e) {
			alert("error:" + e)
		}
	});
}

//게시판 삭제비밀번호 확인
function passCheck11() {
	$.ajax({
		type : "post",
		url : "guestpwdCheck12",
		data : {
			"password" : $("input[name=password]").val(),
			"b_num" : $("#b_num").val()
		},

		success : function(data) {
			if (data == "false") {
				alert("비밀번호가 일치하지 않습니다");
				$("input[name=password]").val("");
			} else {
				$.get("guestboarddelete", {
					"b_num" : $("#b_num").val(),
					"category" : $("#category").val(),
					"levels" : $("#levels").val(),
					"groups" : $("#groups").val(),
					"steps" : $("#steps").val()
					},
					function(data){
						aa();
					});		
				
				
				/*opener.location.href = "guestboardlist?category="
						+ $("#category").val();
				self.close();*/
			}
		},
		beforeSend : showRequest,
		error : function(e) {
			alert("error:" + e)
		}
	});
}

//비밀번호 입력 확인
function showRequest(chk) {
	var flag = true;
	if (!$("input[name=password]").val()) {
		alert("비밀번호를 입력하세요");
		flag = false;
	}
	return flag;
}

function aa(){
	opener.location.href = "guestboardlist?category="
		+ $("#category").val();
	self.close();
}


