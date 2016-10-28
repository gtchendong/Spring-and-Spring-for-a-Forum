package com.chen.bean.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chen.bean.dao.Dao;
import com.chen.bean.dao.LastDao;
@org.springframework.stereotype.Service
public class MessageService implements Service {
	@Autowired
	@Qualifier("messageDao")
	private Dao messageDao;
	@Autowired
	@Qualifier("lastDao")
	private LastDao lastDao;
	@Override
	public void myservice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String myservice(String n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> myservice(int a, int b) {
		
		
		return (List<?>) messageDao.get(a, b);
		
	}
	public int mylast(){
		return lastDao.getLast();
	}

	@Override
	public List<?> myservice(int a) {
		// TODO Auto-generated method stub
		return null;
	}

}
