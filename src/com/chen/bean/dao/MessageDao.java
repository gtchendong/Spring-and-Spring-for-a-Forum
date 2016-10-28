package com.chen.bean.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.chen.bean.model.Message;
@Repository
public class MessageDao implements Dao {

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
	@Autowired
	JdbcTemplate jt;

	@Override
	public List<?> get(int a, int b) {
		String sql="select * from message order by id desc limit ?,?";
		Object[] o={a,b};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		RowMapper<?> rm=new BeanPropertyRowMapper(Message.class) ;
		return (List<?>)jt.query(sql, o, rm);
	}
	
}
