//id중복 확인
function btnIdCheck(){
	if($("#id").val() == ""){
		alert("아이디를 입력해주세요.");
		return false;
	}else{
		$.get("memberIdCheck", 
				{"id" : $("#id").val()},
				function(data){
					if(data == "false"){					
						$("#id").val("");
						$("#checkIdResult").html("* 중복된 아이디입니다.");
						return false;
					}else{
						$("#checkIdResult").html("* 사용 가능한 아이디입니다.");
					}
		});	
	}
}

//회원 가입
function btnRegister(){
	if($("#name").val() == ""){
		alert("이름을 입력해주십시오.");
		return false;
	}else if($("#gender").val() == ""){
		alert("성별을 선택해주십시오.");
		return false;
	}else if($("#checkIdResult").html() == ""){
		alert("아이디 중복확인을 입력해주십시오.");
		return false;
	}else if($("#password").val() == ""){
		alert("비밀번호를 입력해주십시오.");
		return false;
	}else if($("#passwordCheck").val() == ""){
		alert("비밀번호 확인을 입력해주십시오.");
		return false;
	}else if($("#password").val() != $("#passwordCheck").val()){
		alert("비밀번호가 일치하지 않습니다. 비밀번호를 다시 확인하시기 바랍니다.");
		return false;
	}else if($("#birth").val() == ""){
		alert("생년월일을 입력해주십시오.");
		return false;
	}else if($("#phone").val() == ""){
		alert("전화번호을 입력해주십시오.");
		return false;
	}else if($("#email").val() == ""){
		alert("이메일을 입력해주십시오.");
		return false;
	}else if($("#zipcode").val() == ""){
		alert("우편번호를 입력해주십시오.");
		return false;
	}else if($("#address").val() == ""){
		alert("주소를 입력해주십시오.");
		return false;
	}else{
		$.post("memberRegister", 
				$("#registerFrm").serialize(), 
				function(data){
					alert(data);
					guestHome();
		});		
	}
}

//로그인 
function btnLogin(){
	if($("#id").val() == ""){
		alert("아이디를 입력해주십시오");
	}else if($("#password").val() == ""){
		alert("비밀번호를 입력해주십시오.");
		return false;
	}else{
		$.post("memberLogin", 
				{"id" : $("#id").val(), "password" : $("#password").val()}, 
				function(data){					
					if(data == "id_false"){
						alert("해당 아이디기 존재하지 않습니다.");
						return false;
					}else if(data == "pw_false"){
						alert("비밀번호가 일치하지 않습니다.");
						return false;
					}else if(data == "true"){
						alert("로그인되었습니다.");
						guestHome();
					}					
		});
	}
}

//마이 페이지
function memberMypage(){
	location.href="memberMypage";
}

//회원정보 수정
function memberUpdate(){
	if($("#name").val() == ""){
		alert("이름을 입력해주십시오.");
		return false;
	}else if($("#gender").val() == ""){
		alert("성별을 선택해주십시오.");
		return false;
	}else if($("#password").val() == ""){
		alert("비밀번호를 입력해주십시오.");
		return false;
	}else if($("#passwordCheck").val() == ""){
		alert("비밀번호 확인을 입력해주십시오.");
		return false;
	}else if($("#password").val() != $("#passwordCheck").val()){
		alert("비밀번호가 일치하지 않습니다. 비밀번호를 다시 확인하시기 바랍니다.");
		return false;
	}else if($("#birth").val() == ""){
		alert("생년월일을 입력해주십시오.");
		return false;
	}else if($("#phone").val() == ""){
		alert("전화번호을 입력해주십시오.");
		return false;
	}else if($("#email").val() == ""){
		alert("이메일을 입력해주십시오.");
		return false;
	}else if($("#zipcode").val() == ""){
		alert("우편번호를 입력해주십시오.");
		return false;
	}else if($("#address").val() == ""){
		alert("주소를 입력해주십시오.");
		return false;
	}else{
		$.post("memberUpdate", 
				$("#updateFrm").serialize(), 
				function(data){
					alert(data);
					guestHome();
		});	
	
	}
}
	
	
