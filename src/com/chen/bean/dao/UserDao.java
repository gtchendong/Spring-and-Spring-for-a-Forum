package com.chen.bean.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class UserDao implements Dao {
	@Autowired
	JdbcTemplate jt;
	@Override
	public String get() {
		
		
		return null;
	}

	@Override
	public String get(int id) {
		
		String sql="select username from user where id=?";
		Map<String, Object> a=jt.queryForMap(sql, id);
		String aa=(String) a.get("username");
		System.out.println("aa");
		return aa;
	}

	@Override
	public String get(String name) {
		try {
			String sql="select password from user where username=?";
			Map<String, Object> a=jt.queryForMap(sql, name);
			String aa=(String) a.get("password");
			return aa;
		} catch (DataAccessException e) {
			return null;
		}
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

	@Override
	public Object get(int a, int b) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
