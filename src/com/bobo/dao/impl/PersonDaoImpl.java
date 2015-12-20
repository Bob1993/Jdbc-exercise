package com.bobo.dao.impl;

import java.sql.*;
import java.util.*;

import com.util.db.*;
import com.bobo.dao.PersonDao;
import com.bobo.dao.ResultSetHandler;
import com.bobo.domain.Person;

public class PersonDaoImpl implements PersonDao {
	private JdbcTemplet jTemplet= new JdbcTemplet();//创建一个模版对象
	
	@Override
	public void add(Person p) throws SQLException {//增
		// TODO Auto-generated method stub
		jTemplet.update("insert into teacher (name, gender,description) values(?,?,?)", p.getName(),p.getGender(),p.getDescription());
		System.out.println("添加成功！");
	}

	@Override
	public void delete(int id) throws SQLException {//删
		// TODO Auto-generated method stub
		jTemplet.update("delete from teacher where id= ?", id);
		System.out.println("删除成功！");
	}

	@Override
	public void update(Person p) throws SQLException {//改
		// TODO Auto-generated method stub
		jTemplet.update("update teacher set name= ?, gender= ?,description= ? where id= ?", p.getName(),p.getGender(),p.getDescription(),p.getId());
		System.out.println("修改成功！");
	}

	
	
	@Override
	public Person queryByID(final int id) throws SQLException {//查询单个对象
		// TODO Auto-generated method stub
		String sql= "select name,gender,description from teacher where id= ?";
		return (Person)jTemplet.query(sql, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				Person person= null;
					if(rs.next())
					{
						person= new Person();
						person.setId(id);
						person.setName(rs.getString(1));
						person.setGender(rs.getString(2));
						person.setDescription(rs.getString(3));
					}
				return person;
			}
		}, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> queryAll() throws SQLException {//查询所有记录
		// TODO Auto-generated method stub
		String sql= "select id,name,gender,description from teacher";
		return (List<Person>)jTemplet.query(sql, new ResultSetHandler() {//将最终结果强转为list集合
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {//用匿名内部类实现接口并作为一个参数传入函数
				// TODO Auto-generated method stub
				List<Person> persons= new ArrayList<Person>();
				Person person= null;
				while(rs.next())
				{
					person= new Person();
					person.setId(rs.getInt(1));
					person.setName(rs.getString(2));
					person.setGender(rs.getString(3));
					person.setDescription(rs.getString(4));
					persons.add(person);
				}
				return persons;
			}
		});
	}
}
