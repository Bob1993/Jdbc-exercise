package com.bobo.dao.impl;

import java.sql.*;
import java.util.*;

import com.util.db.*;
import com.bobo.dao.PersonDao;
import com.bobo.dao.ResultSetHandler;
import com.bobo.domain.Person;

public class PersonDaoImpl implements PersonDao {
	private JdbcTemplet jTemplet= new JdbcTemplet();//����һ��ģ�����
	
	@Override
	public void add(Person p) throws SQLException {//��
		// TODO Auto-generated method stub
		jTemplet.update("insert into teacher (name, gender,description) values(?,?,?)", p.getName(),p.getGender(),p.getDescription());
		System.out.println("��ӳɹ���");
	}

	@Override
	public void delete(int id) throws SQLException {//ɾ
		// TODO Auto-generated method stub
		jTemplet.update("delete from teacher where id= ?", id);
		System.out.println("ɾ���ɹ���");
	}

	@Override
	public void update(Person p) throws SQLException {//��
		// TODO Auto-generated method stub
		jTemplet.update("update teacher set name= ?, gender= ?,description= ? where id= ?", p.getName(),p.getGender(),p.getDescription(),p.getId());
		System.out.println("�޸ĳɹ���");
	}

	
	
	@Override
	public Person queryByID(final int id) throws SQLException {//��ѯ��������
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
	public List<Person> queryAll() throws SQLException {//��ѯ���м�¼
		// TODO Auto-generated method stub
		String sql= "select id,name,gender,description from teacher";
		return (List<Person>)jTemplet.query(sql, new ResultSetHandler() {//�����ս��ǿתΪlist����
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {//�������ڲ���ʵ�ֽӿڲ���Ϊһ���������뺯��
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
