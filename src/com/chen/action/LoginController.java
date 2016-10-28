package com.chen.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.bean.service.Service;

@Controller
public class LoginController {
	@Autowired
	@Qualifier("messageService")
	private Service messageService;
	@Autowired
	@Qualifier("testService")
	private Service testService;
	@RequestMapping(value="/login.do")
	public String login(Model model,HttpServletRequest request,HttpSession session){
		String str1=testService.myservice(request.getParameter("username"));
		System.out.println(request.getRequestedSessionId());
		String str3=request.getParameter("username");
		session.setAttribute("pageid", 1);
		String str2=request.getParameter("password");
		if(str1==null){
			model.addAttribute("er", "账号不存在");
			return "error";
		}
		else if(str1.equals(str2)){
		session.setAttribute("username", str3);
		session.setAttribute("login","yes");
		List<?> list=messageService.myservice(0, 10);
		session.setAttribute("list", list);
		int pagelast=messageService.mylast();    //不让第一次进去isok页面，控指针异常
		session.setAttribute("pagelast", pagelast);
		return "loginisok";
		}
		else{
			model.addAttribute("er", "密码错误");
			return "../Login";
		}
	}
	@RequestMapping(value="/cancel.do")
	public String cancel(HttpSession session){
		session.removeAttribute("username");
		return "../Login";
	}
}
