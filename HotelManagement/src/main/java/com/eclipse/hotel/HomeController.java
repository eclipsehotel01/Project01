package com.eclipse.hotel;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "management/NewFile";
	}
	
	@RequestMapping("Managementboardregister")
	public String Managementboardregisterboard(String category,Model model){
		model.addAttribute("category",category);
		return "management/board/Managementboardregister";
	} 
	@RequestMapping("loginform")
	public String login(){
		return "management/board/login";
	}
	@RequestMapping(value = "room_management")
	public String room_management(){
		return "redirect:room_list";
	}
	
	@RequestMapping(value = "pay_management")
	public String pay_management(){
		return "redirect:pay_list";
	}	
}
