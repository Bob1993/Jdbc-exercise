package com.bobo.dao;

import java.sql.SQLException;
import java.util.List;

import com.bobo.domain.*;

public interface PersonDao {
	public void add(Person p) throws SQLException;//增
	public void delete(int id) throws SQLException;//删
	public void update(Person p) throws SQLException;//改
	public Person queryByID(int id) throws SQLException;//查一个
	public List<Person> queryAll() throws SQLException;//罗列全部信息，List可重复，有序。是collection的特性
}
