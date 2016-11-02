package com.chen.bean.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CreateDao {
	@Autowired
	private JdbcTemplate jt;
	
	public void create(String title,String context,String username,String image){
		String sql="INSERT INTO message (title,context,username)VALUES (?,?,?)";
		Object[] o={title,context,username};
		jt.update(sql, o);
		String sql1="INSERT INTO reply (title,context,username,image)VALUES (?,?,?,?)";
		Object[] o1={title,context,username,image};
		jt.update(sql1,o1);
	}
}
