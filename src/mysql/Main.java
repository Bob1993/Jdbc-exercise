package mysql;

import com.bobo.dao.impl.PersonDaoImpl;
import com.bobo.domain.Person;

public class Main {
	public static void main(String[] args) {
		PersonDaoImpl exp= new PersonDaoImpl();//DAO���ݿ����ʵ��
		//Person p= null;
		try {
			//exp.add(new Person("���ޱ�", "��", "һλ��������ϸ�������ʦ"));
			while(true)
			{
				exp.add(new Person(1,"���ޱ�", "��", "һλ��������ϸ��������������ʦ"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.toString();
		}
	}
}
