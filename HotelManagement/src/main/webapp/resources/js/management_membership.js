//전체목록
function btnAllList(){
	location.href = "admin_membership_list";
}

//전체선택
function btnAll(){
	$("#checkAll").prop("checked", true);
}

//검색
function btnSearch(){
	if($("#search_word") == ""){
		alert("검색어를 입력해주십시오.")
	}else{
		location.href = "admin_membership_list?field=" + $("#field").val() 
						+ "&word=" + $("#word").val();
	}
}

//수정페이지
function btnUpdatePage(m_num){
	location.href = "admin_membership_updatepage?m_num=" + m_num;	
}

//수정
function btnUpdate(){
	if($("#password") != $("#passwordCheck")){
		alert("비밀번호가 일치하지 않습니다.");
		return false;		
	}else{
		$("#updateForm").submit();
	}	
}

//삭제
function btnDelete(m_num){
	location.href = "admin_membership_delete?m_num=" + m_num;	
}

//페이징
function getListData(pageNum, field, category, word) {
    word = (word == "") ? $("#word").val() : word;
    field = (field == "") ? $("#field").val() : field;
    $("body").load(
    		"admin_membership_list", 
    		{
		       "pageNum" : pageNum,
		       "field" : field,
		       "category" : "",
		       "word" : word
    		}, 
    		function(responseText) {
    			$("body").html(responseText);
    		}
    );
 }

