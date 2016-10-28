package com.chen.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
	@RequestMapping(value="/Login.jsp")
	public void jsp(){
		
		System.out.println("iiiii");
		
		
	}
	
}
