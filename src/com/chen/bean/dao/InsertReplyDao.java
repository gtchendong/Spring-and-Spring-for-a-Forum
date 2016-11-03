package com.chen.bean.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InsertReplyDao {
	@Autowired
	private JdbcTemplate jt;
	
	public void insert(String title,String context,String username,String image){
		String sql ="INSERT INTO reply (title,context,username,image)VALUES (?,?,?,?)";
		Object[] o={title,context,username,image};
		jt.update(sql, o);
	}
	
}
