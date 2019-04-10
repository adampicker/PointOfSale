package com.adam.dao;
import java.util.List;

public interface Dao<T> {
	
	
	T create(T t);
	
	T read(int index);
	
	T update(T t, int index);
	
	void save(T t);	
	
	List<T> findAll();
	
	
	
	
	
	

}
