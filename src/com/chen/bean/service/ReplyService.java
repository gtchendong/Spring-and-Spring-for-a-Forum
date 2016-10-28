package com.chen.bean.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.chen.bean.dao.QueryReply;
@org.springframework.stereotype.Service
public class ReplyService  {
	@Autowired
	private QueryReply reply;
	
	public List<?> myservice(String title) {
		
		return reply.list(title);
	}
}
