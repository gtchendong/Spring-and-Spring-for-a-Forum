package com.chen.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.bean.service.ReplyService;
import com.chen.bean.service.Service;

@Controller
@RequestMapping(value="/bottom")
public class PageController {
	@Autowired
	@Qualifier("messageService")
	private Service messageService;
	
	@Autowired
	private ReplyService reply;
	@RequestMapping(value="/{id}.do")
	public String pagebottom(@PathVariable("id") int id,HttpSession session){
		int pageid;
		if(id==0){
			session.setAttribute("pageid",1);
			id=id+1;
		}
		pageid=(int)session.getAttribute("pageid");
		pageid=id+pageid-1;
		int num=(pageid-1)*10;
		List<?> list=messageService.myservice(num, num+10);
		session.setAttribute("list", list);
		session.setAttribute("pageid",pageid);
		return "loginisok";
	}
	
	@RequestMapping(value="/middle/{id}.do")
	public String context(@PathVariable("id") String id,HttpSession session,HttpServletRequest request){
		List<?> list=reply.myservice(id);
		request.setAttribute("reply",list);
		System.out.println(list);
		return "context";
	}
}
