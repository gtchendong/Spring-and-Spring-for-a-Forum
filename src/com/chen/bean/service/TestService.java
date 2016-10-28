package com.chen.bean.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.chen.bean.dao.Dao;
@Service
public class TestService implements com.chen.bean.service.Service {
	@Autowired
	@Qualifier("userDao")
	private Dao userDao;
	
	public String myservice(String username){
		String p1=userDao.get(username);
		return p1;
	}

	@Override
	public void myservice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<?> myservice(int a, int b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int mylast() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<?> myservice(int a) {
		// TODO Auto-generated method stub
		return null;
	}
}
