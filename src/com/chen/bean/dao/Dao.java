package com.chen.bean.dao;

public interface Dao {
	public String get();
	public String get(int id);
	public String get(String name);
	public Object get(int a,int b);
	public void update();
	public void update(int id);
	public void update(String name);
	public void delete();
	public void delete(int id);
	public void delete(String name);
	public void insert();
	public void insert(int id);
	public void insert(String name);
}
