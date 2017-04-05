
$(document).ready(function(){	
	//family
	$('.family a').on('click', function(e){
		//e.preventDefault();
		$(this).find('span').toggleClass('on');
		  $('.family > ul').slideToggle(200);
	});
	$('.family').on('mouseleave', function(e){
		//e.preventDefault();
		$(this).find('span').removeClass('on');
		  $('.family > ul').slideUp(200);
	});

	//sub-gnb
	$('.bg-v1 #header .menu li').on('click focusin', function(){
		$(this).addClass('current').siblings().removeClass('current');
	});	
	//main-gnb
	$('#main-header .menu li').on('click focusin', function(){
		$(this).addClass('current').siblings().removeClass('current');
	});
	$('#main-header').on('mouseleave', function(){
		$(this).find('li').removeClass('current');
	});
	
});

//로그인 페이지
function memberLogin(){
	location.href='memberLogin'
}

//로그아웃
function memberLogout(){
	location.href="memberLogout";
	alert("로그아웃되었습니다.");
}

//회원가입 페이지
function memberRegister(){
	location.href='memberRegister'
}