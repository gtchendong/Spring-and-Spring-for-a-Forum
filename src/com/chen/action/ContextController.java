package com.chen.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.bean.service.ReplyService;

@Controller
@RequestMapping(value="/middle")
public class ContextController {
	@Autowired
	private ReplyService reply;
	
	@RequestMapping(value="/{id}.do")
	public String context(@PathVariable("id") String id,HttpSession session,HttpServletRequest request){
		List<?> list=reply.myservice(id);
		request.setAttribute("reply",list);
		return "context";
	}
}
