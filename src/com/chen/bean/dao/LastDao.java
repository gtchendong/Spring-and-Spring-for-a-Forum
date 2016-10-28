package com.chen.bean.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LastDao implements Dao {
	@Autowired
	JdbcTemplate jt;
	@Override
	public String get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(int a, int b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(String name) {
		// TODO Auto-generated method stub
		
	}
	@SuppressWarnings("deprecation")
	public int getLast(){
		String sql="select count(*) from message";
		return (int)jt.queryForInt(sql);
	}
	

}
