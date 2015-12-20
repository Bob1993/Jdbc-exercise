package com.bobo.dao;

import java.sql.SQLException;
import java.util.List;

import com.bobo.domain.*;

public interface PersonDao {
	public void add(Person p) throws SQLException;//��
	public void delete(int id) throws SQLException;//ɾ
	public void update(Person p) throws SQLException;//��
	public Person queryByID(int id) throws SQLException;//��һ��
	public List<Person> queryAll() throws SQLException;//����ȫ����Ϣ��List���ظ���������collection������
}
