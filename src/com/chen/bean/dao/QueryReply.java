package com.chen.bean.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.chen.bean.model.Reply;

@Repository
public class QueryReply {
	@Autowired
	private JdbcTemplate jt;
	
	public List<?> list(String title){
		String sql="select * from reply where title=?";
		Object[] o={title};
		RowMapper<Reply> row = new BeanPropertyRowMapper<>(Reply.class);
		return jt.query(sql, o,row);
	}
}
