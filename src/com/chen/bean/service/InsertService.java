package com.chen.bean.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.bean.dao.InsertReplyDao;

@Service
public class InsertService {
	@Autowired
	private InsertReplyDao reply;
	
	public void insert(String title,String context,String username){
		reply.insert(title, context, username);
	}
}
