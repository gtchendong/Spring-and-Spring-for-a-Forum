package com.chen.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.chen.bean.dao.CreateDao;

@Controller
public class RegisterController {
	@Autowired
	private CreateDao create;
	@RequestMapping(value="/register.do")
	public String register(){
		
		return "register";
	}
	@RequestMapping(value="/reput.do")
	public String create(HttpSession session,HttpServletRequest request){
		String title =request.getParameter("title");
		String context=request.getParameter("context");
		String username=(String) session.getAttribute("username");
		create.create(title, context, username);
		return "forward:/bottom/0.do";
	}
}
