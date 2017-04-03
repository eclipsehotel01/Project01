
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

