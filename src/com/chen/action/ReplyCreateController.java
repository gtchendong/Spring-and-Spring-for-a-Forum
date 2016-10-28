package com.chen.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.bean.service.InsertService;

@Controller
@RequestMapping(value="/reply")
public class ReplyCreateController {
	@Autowired
	private InsertService insert;
	
	@RequestMapping(value="/replymessage.do")
	public String createReply(HttpServletRequest request,HttpSession session){
		insert.insert(request.getParameter("title"), request.getParameter("context"),(String)session.getAttribute("username"));
		return "forward:../middle/"+request.getParameter("title")+".do";
	}
	
}
